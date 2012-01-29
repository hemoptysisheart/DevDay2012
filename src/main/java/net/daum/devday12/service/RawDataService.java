package net.daum.devday12.service;

import java.util.List;

import net.daum.devday12.domain.Comment;
import net.daum.devday12.domain.Post;

public interface RawDataService {
	public Post loadPost(String postId);
	
	public List<Comment> loadComments(String id, String postId);
}