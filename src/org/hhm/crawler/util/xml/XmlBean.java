package org.hhm.crawler.util.xml;

import org.dom4j.Element;
import org.hhm.crawler.pojo.DBConfig;

public class XmlBean {

	public DBConfig getDBConfig(Element root) {
		DBConfig dBConfig = new DBConfig();
		dBConfig.setName(root.elementText("name"));
		dBConfig.setiP(root.elementText("ip"));
		dBConfig.setPort(root.elementText("port"));
		dBConfig.setUsername(root.elementText("username"));
		dBConfig.setPassword(root.elementText("password"));
		return dBConfig;
	}

}
