package net.daum.devday12.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.daum.devday12.domain.Comment;
import net.daum.devday12.domain.Post;

import org.springframework.stereotype.Component;

@Component
public class PostServiceImpl implements PostService {
	@Autowired
	private RawDataService	rawDataService;
	
	public Post findPost(String postId) {
		Post			post =	rawDataService.loadPost(postId);
		List<Comment>	rawComments =	rawDataService.loadComments(post.getId(), postId);
		
		Map<String, List<Comment>>	commentMap =	new HashMap<String, List<Comment>>();
		for(Comment c : rawComments) {
			List<String>	keys =	this.findKeys(c);
			for(String key : keys) {
				
			}
		}
		post.setCommentMap(commentMap);
		
		return post;
	}
	
	/**
	 * 코멘트 정보에서 코멘트 리스트를 담을 {@link List}를 결정하기 위한 키를 찾는다.
	 * 
	 * @param comment
	 * @return
	 */
	private List<String> findKeys(Comment comment) {
		return null;
	}

	@Override
	public Post dummyPost(String postId) {
		Post	post =	new Post();
		post.setId("purplekat");
		post.setNickname("호란");
		post.setBody("'그거 뭐야? 좀 줘봐봐.'");
		post.setCommentMap(this.dummyCommentMap());
		
		return post;
	}
	
	private Map<String, List<Comment>> dummyCommentMap() {
		Map<String, List<Comment>>	commentMap =	new HashMap<String, List<Comment>>();
		
		Comment	c =	new Comment();
		c.setAuthor("green0721kr");
		c.setBody("으잌ㅋㅋㅋ");
		
		
		return commentMap;
	}
}
