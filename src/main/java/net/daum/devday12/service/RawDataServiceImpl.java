package net.daum.devday12.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import net.daum.devday12.domain.Comment;
import net.daum.devday12.domain.Post;

@Component
public class RawDataServiceImpl implements RawDataService {

	@Override
	public Post loadPost(String postId) {
		try {
			ArrayList<Post> postInfoList = new ArrayList<Post>();
			Post postInfo = new Post();
			String temp = null;
			
			String	url =	"http://me2day.net/api/get_posts.xml?post_id="+postId;
			URL request = new URL(url); 
			URLConnection connection = request.openConnection();  
			connection.connect();
			String xml_data = null ;
			
			InputStream is = connection.getInputStream();
			BufferedReader in =	new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			try {
				
				byte[] buf = new byte[1024];
				
				String nread = null;
				nread = in.readLine();
				StringBuffer sb = new StringBuffer();
				
				while (nread != null) 
				{
					sb.append(nread.trim());
					nread=in.readLine();
				}
				
				xml_data=sb.toString();
				
				System.out.flush();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			finally 
			{
				is.close();
			}
			
			InputSource inputsource = new InputSource(new StringReader(xml_data));         
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputsource); 
			
			// xpath ��         
			XPath xpath = XPathFactory.newInstance().newXPath();  
			
			NodeList cols1 = (NodeList)xpath.evaluate("//post/body", document, XPathConstants.NODESET);
			NodeList cols2 = (NodeList)xpath.evaluate("//post/pubDate", document, XPathConstants.NODESET);
			NodeList cols3 = (NodeList)xpath.evaluate("//post/author/id", document, XPathConstants.NODESET);
			
			for( int idx=0; idx<cols1.getLength(); idx++ )
			{             
				postInfo.setBody(cols1.item(idx).getTextContent());
//	  		  	postInfo.pubDate = cols2.item(idx).getTextContent();	// 본문 날짜는 안본다.
				postInfo.setId(cols3.item(idx).getTextContent());
				postInfoList.add(postInfo);
			} 
			
			return postInfoList.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Comment> loadComments(String id, String postId) {
		try {
			ArrayList<Comment> commentInfoList = new ArrayList<Comment>();
			String temp = null;
			
			String	url =	"http://me2day.net/api/get_comments/"+id+".xml?post_id="+postId;
			URL request = new URL(url); 
			URLConnection connection = request.openConnection();  
			connection.connect();
			String xml_data = null ;
			
			InputStream is = connection.getInputStream();
			BufferedReader in =	new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			try {
				
				byte[] buf = new byte[1024];
				
				String nread = null;
				nread = in.readLine();
				StringBuffer sb = new StringBuffer();
				
				while (nread != null) 
				{
					sb.append(nread.trim());
					nread=in.readLine();
				}
				
				xml_data=sb.toString();
				
				System.out.flush();
			} catch(Exception e) {
				e.printStackTrace();
			} finally{
				is.close();
			}
			
			InputSource inputsource = new InputSource(new StringReader(xml_data));         
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputsource); 
			
			// xpath ��         
			XPath xpath = XPathFactory.newInstance().newXPath();           
			
			// NodeList �������� : row �Ʒ��� �ִ� ��� col1 �� ����        
			NodeList cols1 = (NodeList)xpath.evaluate("//comment/body", document, XPathConstants.NODESET);
//			NodeList cols2 = (NodeList)xpath.evaluate("//comment/pubDate", document, XPathConstants.NODESET);
			NodeList cols3 = (NodeList)xpath.evaluate("//comment/author/id", document, XPathConstants.NODESET);
			NodeList cols4 = (NodeList)xpath.evaluate("//comment/author/nickname", document, XPathConstants.NODESET);
			
			for( int idx=0; idx<cols1.getLength(); idx++ ) {
				Comment commentInfo = new Comment();
				commentInfo.setBody(cols1.item(idx).getTextContent().trim());
				// TODO cols2.item(idx).getTextContent()는 String임.
				commentInfo.setPubDate(new Date());
				commentInfo.setAuthor(cols3.item(idx).getTextContent().trim());
				commentInfo.setNickname(cols4.item(idx).getTextContent().trim());
				commentInfoList.add(commentInfo);
			} 
			
			return commentInfoList;
		} catch (Exception e) {
			return new ArrayList<Comment>();
		}
	}

}
