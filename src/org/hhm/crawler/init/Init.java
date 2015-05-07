package org.hhm.crawler.init;

import java.util.List;

import org.hhm.crawler.pojo.seed.Seeds;
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
			crawldb.set(seedlist.get(i));

		}

	}

}
