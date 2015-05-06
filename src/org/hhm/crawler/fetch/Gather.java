package org.hhm.crawler.fetch;

import java.util.List;

import org.hhm.crawler.fetch.jsoup.Parser;
import org.hhm.crawler.pojo.seed.Seeds;
import org.hhm.crawler.update.Crawldb;

public class Gather implements Runnable {

	static Parser parser = new Parser();
	static Crawldb crawldb = new Crawldb();
	private List<Seeds> list;

	public Gather(List<Seeds> list) {
		this.list = list;
	}

	@Override
	public void run() {

		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {

				// 获取url
				String url = list.get(i).getUrl();
				// 根据url获取源代码
				String sourse = parser.getSourseCode(url);
				
				

				// 把url存进crawldb

				Seeds seeds = new Seeds();
				seeds = list.get(i);

				seeds.setUrl(url);
				crawldb.set(seeds);

			}

		}

	}

}
