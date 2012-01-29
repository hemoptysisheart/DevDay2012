package net.daum.devday12.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import net.daum.devday12.domain.SearchInfo;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Component
public class SearchParser 
{
	public ArrayList<SearchInfo> searchParser (String searchString) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException
	{
		ArrayList<SearchInfo> searchInfoList = new ArrayList<SearchInfo>();
		
		String url = "http://apis.daum.net/search/blog?q="+searchString+"&apikey=f210c610506e2c51c811bf86c16fc91c24fc6b23";
		
		URL request = new URL(url); 
		URLConnection connection = request.openConnection();  
		connection.connect();
		String xml_data = null ;

		InputStream is = connection.getInputStream();
		BufferedReader in =	new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		try {

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
		
		NodeList cols1 = (NodeList)xpath.evaluate("//item/title", document, XPathConstants.NODESET);
	    NodeList cols2 = (NodeList)xpath.evaluate("//item/description", document, XPathConstants.NODESET);
	    NodeList cols3 = (NodeList)xpath.evaluate("//item/link", document, XPathConstants.NODESET);
	   	    
	    for( int idx=0; idx<cols1.getLength(); idx++ )
	    {             
	    	SearchInfo searchInfo = new SearchInfo();
	    	searchInfo.title = cols1.item(idx).getTextContent();
	    	searchInfo.description = cols2.item(idx).getTextContent();
	    	searchInfo.link = cols3.item(idx).getTextContent();
	    	searchInfoList.add(searchInfo);
	    } 
	
		return searchInfoList;
	}
}
