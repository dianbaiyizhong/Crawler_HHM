package org.hhm.crawler.update;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hhm.crawler.pojo.Seeds;

public class Crawldb {
	static BloomFilter bloomFilter = BloomFilter.getInstance();

	private static Set<Seeds> uList = new HashSet<Seeds>();
	private static final Crawldb INSTANCE = new Crawldb();
	static Logger log = Logger.getLogger("");

	public synchronized static final Crawldb getInstance() {
		return Crawldb.INSTANCE;
	}

	public synchronized Seeds get() {
		Iterator<Seeds> it = uList.iterator();

		synchronized (this) {
			while (it.hasNext()) {
				Seeds seeds = new Seeds();
				seeds = it.next();

				it.remove();
				return seeds;
			}

			return null;
		}

	}

	public synchronized void set(Seeds seeds) {
		synchronized (this) {

			if (seeds != null) {
				// 在把种子放进队列之前，先检测一下布隆过滤器中是否存在
				boolean b = bloomFilter.isExit(seeds.getMd5());

				if (b) {

				} else {
					// 如果不存在，那就存入

					uList.add(seeds);

					log.info("新增url为:" + seeds.getUrl());
					log.info("待抓队列中现有数据:" + uList.size());
					bloomFilter.add(seeds.getMd5());

				}

			}
		}
	}

	public String filter(Seeds seeds, String url) {
		// 定向
		String directDomain = seeds.getDirectDomain();
		// 先判断是否为http开头的域名
		if (!url.startsWith("http")) {

			url = directDomain + url;
		}

		if (!url.startsWith(directDomain)) {

			return null;

		}

		String id = seeds.getId();
		String Suffix = seeds.getFilterSuffix();
		if (!IsFitSuffix(url, Suffix, id)) {
			return null;
		}

		return url;

	}

	private boolean IsFitSuffix(String url, String Suffix, String id) {

		List<String> list = getSuffixList(Suffix, id);
		for (int j = 0; j < list.size(); j++) {

			if (url.endsWith(list.get(j))) {
				return false;

			}

		}

		if (list.size() == 0) {
			return true;
		}
		return true;
	}

	private List<String> getSuffixList(String Suffix, String id) {
		List<String> list = new ArrayList<String>();
		try {
			String Arr[] = Suffix.split(",");
			for (int i = 0; i < Arr.length; i++) {
				list.add(Arr[i]);
			}
		} catch (Exception e) {

			log.warning("id为【 " + id + "】的任务未设置【" + "url过滤后缀" + "】");

		}
		return list;

	}
}
