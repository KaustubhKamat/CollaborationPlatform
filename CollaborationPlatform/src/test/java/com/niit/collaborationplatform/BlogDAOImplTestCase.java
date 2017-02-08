package com.niit.collaborationplatform;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationPlatform.DAO.BlogDAO;
import com.niit.collaborationPlatform.model.Blog;

public class BlogDAOImplTestCase {

	
	@Autowired
	static Blog blog;
	
	@Autowired
	static BlogDAO blogDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDAO=(BlogDAO) context.getBean("blogDAIOImpl");
		blog=(Blog) context.getBean("blog");
	}
	
	@Test
	public void CreateBlogTestCase()
	{
		blog.setId(1);
		blog.setEmailid("kaustubh235@gmail.com");
		blog.setTitle("Blog1");
		blog.setDescription("This is the blog");
		blog.setReason("Valid");
		Date date=new Date();
		blog.setDate(date);
		blog.setStatus("Yes");

		
	}

}
