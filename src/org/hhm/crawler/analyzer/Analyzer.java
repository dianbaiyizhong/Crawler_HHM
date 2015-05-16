package org.hhm.crawler.analyzer;

import org.hhm.crawler.pojo.Content;
import org.hhm.crawler.pojo.Seeds;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Analyzer {

	Seeds seeds_plan;
	String sourceCode;

	public Analyzer(Seeds seeds_plan, String sourceCode) {
		this.seeds_plan = seeds_plan;
		this.sourceCode = sourceCode;
	}

	public void start() {
		Content content = new Content();
		Document doc = Jsoup.parse(sourceCode);

		if (seeds_plan.getTitle() != null) {

			content.setTitle(doc.title());

		}

		System.out.println(content);

	}
}
