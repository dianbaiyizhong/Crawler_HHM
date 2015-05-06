package org.hhm.crawler.util.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;
import org.hhm.crawler.pojo.seed.Seeds;

public class XmlBean {

	public List<Seeds> get(Element root) {
		List<Seeds> list = new ArrayList<Seeds>();

		for (Iterator it = root.elementIterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Seeds seeds = new Seeds();

			for (Iterator it1 = e.elementIterator(); it1.hasNext();) {
				// e1包含了seed节点中的所有field

				Element e1 = (Element) it1.next();

				String name = e1.attributeValue("name");

				if (name.equals("url")) {
					seeds.setUrl(e1.getText().trim());
				} else if (name.equals("title")) {
					seeds.setTitle(e1.getText().trim());
				} else if (name.equals("text")) {
					seeds.setText(e1.getText().trim());
				} else if (name.equals("time")) {
					seeds.setTime(e1.getText().trim());
				} else if (name.equals("author")) {
					seeds.setAuthor(e1.getText().trim());
				} else if (name.equals("depth")) {
					seeds.setDepth(Integer.parseInt(e1.getText().trim()));
				} else if (name.equals("filterSuffix")) {
					seeds.setFilterSuffix(e1.getText().trim());
				} else if (name.equals("directDomain")) {
					seeds.setDirectDomain(e1.getText().trim());
				}

			}
			list.add(seeds);

		}
		return list;

	}
}
