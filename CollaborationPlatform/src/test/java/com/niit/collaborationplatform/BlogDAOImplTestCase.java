package com.niit.collaborationplatform;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationPlatform.DAO.BlogDAO;
import com.niit.collaborationPlatform.model.Blog;

import junit.framework.Assert;

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
	
	@SuppressWarnings("deprecation")
	//@Test
	public void CreateBlogTestCase()
	{
		blog.setId(11);
		blog.setEmailid("sneha@gmail.com");
		blog.setTitle("Blog5");
		blog.setDescription("This is the Sneha blog");
		blog.setReason("Valid");
		Date date=new Date();
		blog.setDate_time(date);
		blog.setStatus("Valid");

		Assert.assertEquals("createBlogTestCase", false, blogDAO.SaveBlog(blog));
	}

    @SuppressWarnings("deprecation")
	//@Test 
	public void DeleteBlogTestCase()
     {
    	 blog=blogDAO.getid(11);
    	 Assert.assertEquals("DeleteBlogTestCase", false, blogDAO.DeleteBlog(blog));
    	 
     }

    
    @SuppressWarnings("deprecation")
	//@Test
    public void UpdateBlogTestCase()
    {
   	 blog=blogDAO.getid(11);
   	 blog.setDescription("This is Blog no-5");
   	 Assert.assertEquals("DeleteBlogTestCase", false, blogDAO.UpdateBlog(blog));
   	 
    }

    
    @Test
    public void getByIDTestCase()
    {
    blog=blogDAO.getByid(11);
    System.out.println(blog.getEmailid());
    }
    
}
