package org.hhm.crawler.pojo.seed;

import org.hhm.crawler.util.md5.MD5;

public class Seeds {

	private String url;

	@Override
	public String toString() {
		return "Seeds [url=" + url + ", title=" + title + ", text=" + text
				+ ", time=" + time + ", author=" + author + ", md5=" + md5
				+ ", depth=" + depth + ", filterSuffix=" + filterSuffix
				+ ", directDomain=" + directDomain + "]";
	}

	private String title;
	private String text;
	private String time;
	private String author;

	private String md5;
	private int depth;
	private String filterSuffix;
	private String directDomain;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((md5 == null) ? 0 : md5.hashCode());
		return result;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		MD5 md5 = new MD5();
		setMd5(md5.MD5Encode(url));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getFilterSuffix() {
		return filterSuffix;
	}

	public void setFilterSuffix(String filterSuffix) {
		this.filterSuffix = filterSuffix;
	}

	public String getDirectDomain() {
		return directDomain;
	}

	public void setDirectDomain(String directDomain) {
		this.directDomain = directDomain;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seeds other = (Seeds) obj;
		if (md5 == null) {
			if (other.md5 != null)
				return false;
		} else if (!md5.equals(other.md5))
			return false;
		return true;
	}

}
