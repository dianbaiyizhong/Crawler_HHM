package org.hhm.crawler.analyzer;

import org.apache.log4j.Logger;
import org.hhm.crawler.pojo.Content;
import org.hhm.crawler.pojo.Seeds;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Analyzer {

	Seeds seeds_plan;
	String sourceCode;
	private static Logger logger = Logger.getLogger(Analyzer.class);

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

		logger.info(content);
		// System.out.println(content);

	}
}
