package org.hhm.crawler.init;

import java.util.List;

import org.hhm.crawler.pojo.seed.Seeds;
import org.hhm.crawler.update.Crawldb;

public class Init {

	static Crawldb U = new Crawldb();
	private List<Seeds> seedlist;

	public Init(List<Seeds> seedlist) {
		this.seedlist = seedlist;
	}

	public void action() {

		// 存入待抓队列
		for (int i = 0; i < seedlist.size(); i++) {
			U.set(seedlist.get(i));

		}

	}

}
