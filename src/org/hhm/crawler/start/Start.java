package org.hhm.crawler.start;

import java.util.List;

import org.hhm.crawler.controller.Controller;
import org.hhm.crawler.pojo.seed.Seeds;
import org.hhm.crawler.util.xml.XMLElement;
import org.hhm.crawler.util.xml.XmlBean;

public class Start {
	public static void main(String[] args) {

		Controller controller = new Controller();
		controller.Start();
		// BloomFilter bloomFilter = new BloomFilter();
		// System.out.println(bloomFilter
		// .isExit("http://www.plating.org/news_info.asp?pid=28&id=2857"));

	}
}
