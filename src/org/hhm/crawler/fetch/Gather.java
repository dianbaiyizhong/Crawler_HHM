package org.hhm.crawler.fetch;

import java.util.ArrayList;
import java.util.List;

import org.hhm.crawler.fetch.jsoup.Parser;
import org.hhm.crawler.pojo.seed.Seeds;
import org.hhm.crawler.update.Crawldb;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

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
				String sourseCode = parser.getSourseCode(url);
				// 获取a标签
				Document doc = Jsoup.parse(sourseCode);
				Elements el_lable_A = doc.select("a");

				List<String> list_A = new ArrayList<String>();
				for (int k = 0; k < el_lable_A.size(); k++) {

					list_A.add(el_lable_A.get(k).attr("href"));

				}
				// 把url存进crawldb

				for (int j = 0; j < list_A.size(); j++) {
					Seeds seeds = new Seeds();
					seeds = list.get(i);
					seeds.setUrl(list_A.get(j));
					crawldb.set(seeds);
				}

			}

		}

	}

}
