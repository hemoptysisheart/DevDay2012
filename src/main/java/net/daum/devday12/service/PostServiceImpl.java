package net.daum.devday12.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
		post.setId("origin");
		post.setNickname("작성자");
		post.setBody("'그거 뭐야? 좀 줘봐봐.'");
		post.setCommentMap(this.dummyCommentMap());
		
		return post;
	}
	
	private Map<String, List<Comment>> dummyCommentMap() {
		Map<String, List<Comment>>	commentMap =	new HashMap<String, List<Comment>>();
		List<Comment>	l1 =	new ArrayList<Comment>();
		List<Comment>	l2 =	new ArrayList<Comment>();
		List<Comment>	l3 =	new ArrayList<Comment>();
		List<Comment>	l4 =	new ArrayList<Comment>();
		
		commentMap.put("id1", l1);
		commentMap.put("id2", l2);
		commentMap.put("id3", l3);
		commentMap.put("id4", l4);
		
		Comment	c1 =	new Comment();
		c1.setAuthor("id1");
		c1.setBody("아싸 1등!");
		c1.setMention(new ArrayList<String>());
		c1.setPubDate(new Date());
		l1.add(c1);
		
		try {
			Thread.sleep(10 +new Random().nextInt(1000));
		} catch (InterruptedException e) { }
		
		Comment	c2 =	new Comment();
		c2.setAuthor("id2");
		c2.setBody("아싸 2등!");
		c2.setMention(new ArrayList<String>());
		c2.setPubDate(new Date());
		l2.add(c2);
		
		try {
			Thread.sleep(10 +new Random().nextInt(1000));
		} catch (InterruptedException e) { }
		
		Comment	c3 =	new Comment();
		c3.setAuthor("id3");
		c3.setBody("내가 1등!");
		c3.setPubDate(new Date());
		l3.add(c3);
		
		try {
			Thread.sleep(100 +new Random().nextInt(500));
		} catch (InterruptedException e) { }
		
		Comment	c4 =	new Comment();
		c4.setAuthor("id3");
		c4.setBody("<a href='http://me2day.net/id1'>ID1</a> 아니잖아!");
		List<String>	m4 =	new ArrayList<String>();
		m4.add("id1");
		c4.setMention(m4);
		c4.setPubDate(new Date());
		l3.add(c4);
		l1.add(c4);
		
		try {
			Thread.sleep(100 +new Random().nextInt(1000));
		} catch (InterruptedException e) { }
		
		Comment c5 =	new Comment();
		c5.setAuthor("origin");
		c5.setBody("<a href='http://me2day.net/id1'>ID1</a>, <a href='http://me2day.net/id2'>ID2</a>, <a href='http://me2day.net/id3'>ID3</a> 이게 뭐하는 짓이야?");
		List<String>	m5 =	new ArrayList<String>();
		m5.add("id1");
		m5.add("id2");
		m5.add("id3");
		c5.setMention(m5);
		c5.setPubDate(new Date());
		l1.add(c5);
		l2.add(c5);
		l3.add(c5);
		
		try {
			Thread.sleep(100 +new Random().nextInt(500));
		} catch (InterruptedException e) { }
		
		Comment	c6 =	new Comment();
		c6.setAuthor("id2");
		c6.setBody("<a href='http://me2day.net/origin'>작성자</a> 놀아요!");
		List<String>	m6 =	new ArrayList<String>();
		m6.add("origin");
		c6.setMention(m6);
		c6.setPubDate(new Date());
		l2.add(c6);
		
		try {
			Thread.sleep(100 +new Random().nextInt(100));
		} catch (InterruptedException e) { }
		
		Comment	c7 =	new Comment();
		c7.setAuthor("id3");
		c7.setBody("<a href='http://me2day.net/id4'>ID4</a> 뭐하냐?");
		List<String>	m7 =	new ArrayList<String>();
		m7.add("id4");
		c7.setMention(m7);
		c7.setPubDate(new Date());
		l3.add(c7);
		l4.add(c7);
		
		try {
			Thread.sleep(100 +new Random().nextInt(500));
		} catch (InterruptedException e) { }
		
		Comment	c8 =	new Comment();
		c8.setAuthor("id4");
		c8.setBody("<a href='http://me2day.net/id3'>ID3</a> 잤다!");
		List<String>	m8 =	new ArrayList<String>();
		m8.add("id3");
		c8.setMention(m8);
		c8.setPubDate(new Date());
		l4.add(c8);
		l3.add(c8);
		
		return commentMap;
	}
}
