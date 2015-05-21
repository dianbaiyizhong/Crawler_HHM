package org.hhm.crawler.init;

import java.util.List;

import org.hhm.crawler.init.impl.InitImpl;
import org.hhm.crawler.pojo.Seeds;
import org.hhm.crawler.update.BloomFilter;
import org.hhm.crawler.update.Crawldb;
import org.hhm.crawler.util.xml.XMLElement;
import org.hhm.crawler.util.xml.XmlBean;

public class Init {

	static Crawldb crawldb = Crawldb.getInstance();

	static BloomFilter bloomFilter = BloomFilter.getInstance();

	public void action() {

		// 加载数据库信息
		XmlBean xmlBean = new XmlBean();
		xmlBean.getDBConfig(new XMLElement("Config/DBConfig.xml").get());

		InitImpl initImpl = new InitImpl();
		// 获取任务列表
		initImpl.getTaskInfo(1);
		// 获取种子列表
		List<Seeds> seedlist = initImpl.getGatherwebsite(1);

		// 初始化布隆过滤器
		bloomFilter.init();

		// 存入待抓队列
		for (int i = 0; i < seedlist.size(); i++) {

			crawldb.set(seedlist.get(i));

		}

	}

}
