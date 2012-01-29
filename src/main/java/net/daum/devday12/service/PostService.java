package net.daum.devday12.service;

import java.util.List;

import net.daum.devday12.domain.Comment;
import net.daum.devday12.domain.Post;

public interface PostService {
	public Post findPost(String postId);
}
