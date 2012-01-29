package net.daum.devday12.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import net.daum.devday12.domain.Post;
import net.daum.devday12.domain.SearchInfo;
import net.daum.devday12.service.PostService;
import net.daum.devday12.service.SearchParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private SearchParser searchParser;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "post";
	}
	
	@RequestMapping(value = "/postId/{postId}", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody Post findAll(@PathVariable String postId, Model model) {
		Post	post = postService.findPost(postId);
		
		return post;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody List<SearchInfo> search(@RequestParam String q, Model model) throws XPathExpressionException, IOException, SAXException, ParserConfigurationException {
		return searchParser.searchParser(q);
	}
	
}
