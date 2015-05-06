package org.hhm.crawler.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.hhm.crawler.fetch.Gather;
import org.hhm.crawler.init.Init;
import org.hhm.crawler.pojo.seed.Seeds;
import org.hhm.crawler.update.Crawldb;
import org.hhm.crawler.util.xml.XMLElement;
import org.hhm.crawler.util.xml.XmlBean;

public class Controller {
	private static int threadMax; // 最大线程数
	private static int gatherMax;// 单位线程最大抓取数
	private ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors
			.newFixedThreadPool(threadMax);

	static Crawldb crawldb = Crawldb.getInstance();

	public void Start() {

		// 获取种子列表
		XmlBean xmlBean = new XmlBean();
		List<Seeds> seedlist = xmlBean.get(new XMLElement("config/Seeds.xml")
				.get());
		Init init = new Init(seedlist);
		init.action();

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				if (threadPool.getActiveCount() < threadMax) {

					List<Seeds> list = new ArrayList<Seeds>();
					for (int i = 0; i < gatherMax; i++) {

						list.add(crawldb.get());

					}

					Gather gather = new Gather(list);

					threadPool.execute(gather);

				}

			}

		});
		t.start();

	}

}
