package org.hhm.crawler.test;

import org.hhm.crawler.fetch.jsoup.Parser;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Parser p = new Parser();
		System.out.println(p.getSourseCode("http://www.oclc.org"));
	}

}
