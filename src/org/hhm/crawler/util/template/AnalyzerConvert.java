package org.hhm.crawler.util.template;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AnalyzerConvert {
	public Elements Convert_Text(String Template) {

		Document doc = Jsoup.parse(Template);

		Elements elements = doc.select("field[name=text]");

		return elements;

	}

	public Elements Convert_Title(String Template) {

		Document doc = Jsoup.parse(Template);

		Elements elements = doc.select("field[name=title]");

		return elements;

	}

	public Elements Convert_Time(String Template) {

		Document doc = Jsoup.parse(Template);

		Elements elements = doc.select("field[name=time]");

		return elements;

	}

	public Elements Convert_Author(String Template) {

		Document doc = Jsoup.parse(Template);

		Elements elements = doc.select("field[name=author]");

		return elements;

	}
}
