package org.hhm.crawler.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;
import org.hhm.crawler.fetch.Gather;
import org.hhm.crawler.init.Init;
import org.hhm.crawler.pojo.Seeds;
import org.hhm.crawler.update.Crawldb;
import org.hhm.crawler.util.xml.XMLElement;
import org.hhm.crawler.util.xml.XmlBean;

public class Controller {
	private static int threadMax = 1; // 最大线程数
	private static int gatherMax = 20;// 单位线程最大抓取数
	private ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors
			.newFixedThreadPool(threadMax);
	private static Logger logger = Logger.getLogger(Controller.class);

	public void Start() {

		// 获取种子列表
		XmlBean xmlBean = new XmlBean();
		List<Seeds> seedlist = xmlBean.get(new XMLElement("config/Seeds.xml")
				.get());

		Init init = new Init(seedlist);
		init.action();
		final Crawldb crawldb = Crawldb.getInstance();

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					int ActiveCount = threadPool.getActiveCount();
					if (ActiveCount != 0) {
						logger.info("当前活跃线程为:" + ActiveCount);
					}

					if (ActiveCount < threadMax) {

						List<Seeds> list = new ArrayList<Seeds>();
						for (int i = 0; i < gatherMax; i++) {
							Seeds seeds = crawldb.get();

							if (seeds != null) {
								list.add(seeds);

							}
						}

						Gather gather = new Gather(list);

						threadPool.execute(gather);

					} else {
						// 如果线程池中的线程已满，则等待一段时间
						try {
							Thread.sleep(8000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			}

		});
		t.start();

	}
}
