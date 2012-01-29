package net.daum.devday12.service;

import net.daum.devday12.domain.Post;

public interface PostService {
	public Post findPost(String postId);
	
	public Post	dummyPost(String postId);
}
