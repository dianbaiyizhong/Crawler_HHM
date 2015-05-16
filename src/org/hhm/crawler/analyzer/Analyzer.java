package org.hhm.crawler.analyzer;

import org.apache.log4j.Logger;
import org.hhm.crawler.database.impl.DataImpl;
import org.hhm.crawler.pojo.Content;
import org.hhm.crawler.pojo.Seeds;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Analyzer {

	Seeds seeds_plan;
	String sourceCode;
	private static Logger logger = Logger.getLogger(Analyzer.class);

	static DataImpl dataImpl = new DataImpl();

	public Analyzer(Seeds seeds_plan, String sourceCode) {
		this.seeds_plan = seeds_plan;
		this.sourceCode = sourceCode;
	}

	public void start() {
		Content content = new Content();

		content.setUrl(seeds_plan.getUrl());

		Document doc = Jsoup.parse(sourceCode);

		if (seeds_plan.getTitle() != null) {

			content.setTitle(doc.title());

		}

		if (seeds_plan.getText() != null) {

			String lablename = seeds_plan.getText().attributeValue("lablename");

			String labelclass = seeds_plan.getText().attributeValue(
					"labelclass");
			String labelid = seeds_plan.getText().attributeValue("labelid");

			String text = "";
			if (labelclass != "") {
				text = doc.select(lablename + "[class=" + labelclass + "]")
						.text();
			} else if (labelid != "") {
				text = doc.select(lablename + "[id=" + labelid + "]").text();

			}

			content.setText(text.trim());
		}

		logger.info(content);

		dataImpl.saveData(content);

	}
}
