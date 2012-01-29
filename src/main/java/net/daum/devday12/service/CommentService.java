package net.daum.devday12.service;

import java.util.List;

import net.daum.devday12.domain.Comment;

public interface CommentService {
	
	List<Comment> findAll(String postId);
}
