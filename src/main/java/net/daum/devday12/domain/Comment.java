package net.daum.devday12.domain;

import java.util.Date;
import java.util.List;

public class Comment {
	
	String author;
	String body;
	Date pubDate;
	List<String> mention;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public List<String> getMention() {
		return mention;
	}
	public void setMention(List<String> mention) {
		this.mention = mention;
	}
	
	@Override
	public String toString() {
		return "Comment [author=" + author + ", body=" + body + ", pubDate="
				+ pubDate + ", mention=" + mention + "]";
	}
	
	
}
