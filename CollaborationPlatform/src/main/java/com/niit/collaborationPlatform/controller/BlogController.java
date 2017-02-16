package com.niit.collaborationPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationPlatform.DAO.BlogDAO;
import com.niit.collaborationPlatform.model.Blog;

@RestController
public class BlogController {

	@Autowired
	public BlogDAO blogDAO;

	@Autowired
	public Blog blog;

	@GetMapping("/Hello")
	public String Hello() {
		return "Hello from Collaboration platform";

	}

	@GetMapping("/getAllBlogs")
	public ResponseEntity<List<Blog>> getAllBlogs() {
		List<Blog> blogs = blogDAO.list();
		if (blogs.isEmpty()) {
			blog.setErrorCode("100");
			blog.setErrorMessage("No Blog is available yet");
			blogs.add(blog);
			return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
		} else {
			blog.setErrorCode("200");
			blog.setErrorMessage("Successfully fetched the list of the blogs");
		}
		return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
	}

	@PutMapping("/approveBlog/{blogID}")
	public Blog approveBlog(@PathVariable("blogID") int id) {
		blog = blogDAO.getByid(id);
		
		//if the blog id is not present in th DB
		if(blog==null)
		{
			blog=new Blog();
			blog.setErrorCode("404");
			blog.setErrorMessage("No blog exits with this id :" +id);
			return blog;
		}
		
		//if the blog is already approved
		if(blog.getStatus().equals("Approved"))	
		{
			blog.setErrorCode("404");
			blog.setErrorCode("This blog is already approved :"  +id);
			return blog;
		}
		
		blog.setStatus("Approved");
		if (blogDAO.UpdateBlog(blog)) {
			blog.setErrorCode("200");
			blog.setErrorMessage("Successfully Approved the Blog");
		}

		else {
			blog.setErrorCode("404");
			blog.setErrorMessage("Not able to update the blog");
		}

		return blog;

	}

}
