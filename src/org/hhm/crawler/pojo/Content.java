package org.hhm.crawler.pojo;

public class Content {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Content [title=" + title + ", text=" + text + ", author="
				+ author + ", time=" + time + "]";
	}

	private String title;
	private String text;
	private String author;
	private String time;

}
