package org.hhm.crawler.fetch.jsoup;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.hhm.crawler.analyzer.Analyzer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Parser {

	private static Logger logger = Logger.getLogger(Analyzer.class);

	public String getSourseCode(String url) {

		String sourseCode = null;
		Document doc_sourseCode = null;
		try {

			doc_sourseCode = Jsoup.connect(url).timeout(60000).get();
		} catch (IOException e) {

			logger.error(e.getMessage());
			return null;
		}

		sourseCode = doc_sourseCode.html();

		return sourseCode.trim();
	}

}
