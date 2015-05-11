package org.hhm.crawler.init;

import java.util.List;

import org.hhm.crawler.pojo.Seeds;
import org.hhm.crawler.update.BloomFilter;
import org.hhm.crawler.update.Crawldb;

public class Init {

	static Crawldb crawldb = Crawldb.getInstance();
	private List<Seeds> seedlist;

	static BloomFilter bloomFilter = BloomFilter.getInstance();

	public Init(List<Seeds> seedlist) {
		this.seedlist = seedlist;
	}

	public void action() {
		// 初始化布隆过滤器
		bloomFilter.init();
		// 存入待抓队列
		for (int i = 0; i < seedlist.size(); i++) {
			// 设置初始深度为0
			seedlist.get(i).setNow_depth(0);

			crawldb.set(seedlist.get(i));

		}

	}

}
