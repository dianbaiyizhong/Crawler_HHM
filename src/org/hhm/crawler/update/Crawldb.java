package org.hhm.crawler.update;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hhm.crawler.pojo.seed.Seeds;

public class Crawldb {
	static BloomFilter bloomFilter = new BloomFilter();

	private Set<Seeds> uList = new HashSet<Seeds>();
	private static final Crawldb INSTANCE = new Crawldb();

	public synchronized static final Crawldb getInstance() {
		return Crawldb.INSTANCE;
	}

	public synchronized Seeds get() {
		Iterator it = uList.iterator();

		while (it.hasNext()) {
			Seeds seeds = new Seeds();
			seeds = (Seeds) it.next();

			it.remove();
			return seeds;

		}

		return null;

	}

	public synchronized void set(Seeds seeds) {
		if (seeds != null) {
			// 在把种子放进队列之前，先检测一下布隆过滤器中是否存在
			boolean b = bloomFilter.isExit(seeds.getMd5());

			if (b) {

			} else {
				// 如果不存在，那就存入
				uList.add(seeds);
				bloomFilter.add(seeds.getMd5());

			}

		}

	}

}
