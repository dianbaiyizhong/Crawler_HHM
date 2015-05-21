package org.hhm.crawler.analyzer;

import org.apache.log4j.Logger;
import org.hhm.crawler.analyzer.impl.DataImpl;
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

		try {
			if (seeds_plan.getTitle() != null) {

				content.setTitle(doc.title());

			}

			if (seeds_plan.getText() != null) {

				String lablename = seeds_plan.getText().attr("lablename");
				String labelclass = seeds_plan.getText().attr("labelclass");

				String labelid = seeds_plan.getText().attr("labelid");

				String text = "";
				if (labelclass != "") {
					text = doc.select(lablename + "[class=" + labelclass + "]")
							.text();
				} else if (labelid != "") {
					text = doc.select(lablename + "[id=" + labelid + "]")
							.text();

				}

				content.setText(text.trim());
			}

			if (seeds_plan.getTime() != null) {

				String lablename = seeds_plan.getTime().attr("lablename");
				String labelclass = seeds_plan.getTime().attr("labelclass");
				String labelid = seeds_plan.getTime().attr("labelid");

				String arrIndex[] = seeds_plan.getTime().text().split("-");
				String time = "";
				if (labelclass != "") {

					time = doc.select(lablename + "[class=" + labelclass + "]")
							.select(arrIndex[0])
							.get(Integer.parseInt(arrIndex[1])).text();

				} else if (labelid != "") {
					time = doc.select(lablename + "[id=" + labelid + "]")
							.text();

				}
				content.setTime(time);

			}

			if (seeds_plan.getAuthor() != null) {

				String lablename = seeds_plan.getAuthor().attr("lablename");
				String labelclass = seeds_plan.getAuthor().attr("labelclass");
				String labelid = seeds_plan.getAuthor().attr("labelid");

				String arrIndex[] = seeds_plan.getAuthor().text().split("-");
				String author = "";
				if (labelclass != "") {

					author = doc
							.select(lablename + "[class=" + labelclass + "]")
							.select(arrIndex[0])
							.get(Integer.parseInt(arrIndex[1])).text();

				} else if (labelid != "") {
					author = doc.select(lablename + "[id=" + labelid + "]")
							.text();

				}
				content.setAuthor(author);

			}

		} catch (Exception e) {

			logger.info("url为【" + seeds_plan.getUrl() + "】的链接内容不符合指定模板");

		}
		logger.info(content);

		dataImpl.saveData(content);

	}
}
