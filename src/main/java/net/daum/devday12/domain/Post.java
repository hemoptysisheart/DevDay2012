package net.daum.devday12.domain;

import java.util.List;
import java.util.Map;

public class Post {
	private String	id;
	private String	nickname;
	private String	body;
	private List<Comment>	comments;
	private Map<String, List<Comment>>	commentMap;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Map<String, List<Comment>> getCommentMap() {
		return commentMap;
	}
	public void setCommentMap(Map<String, List<Comment>> commentMap) {
		this.commentMap = commentMap;
	}
}