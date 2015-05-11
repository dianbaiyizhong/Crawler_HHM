package org.hhm.crawler.start;

import org.hhm.crawler.controller.Controller;
import org.hhm.crawler.update.BloomFilter;
import org.hhm.crawler.update.Crawldb;

public class Start {
	static Crawldb crawldb = Crawldb.getInstance();
	static BloomFilter bloomFilter = BloomFilter.getInstance();

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.Start();

	}
}
