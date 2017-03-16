package com.niit.collaborationPlatform.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationPlatform.DAO.JobApplicationDAO;
import com.niit.collaborationPlatform.model.JobApplication;

import ch.qos.logback.classic.Logger;

@RestController
public class JobApplicationController {
	
	@Autowired
	public JobApplication  jobApplication;
	
	@Autowired
	public JobApplicationDAO jobApplicationDAO;
	
	@Autowired
	HttpSession session;
		
	
	@RequestMapping("/getAllJobApplications")
	public ResponseEntity<JobApplication> getAllJobApplications()
	{
		List<JobApplication> jobApplications=jobApplicationDAO.list();
		if(jobApplications.isEmpty())
		{
			jobApplication.setErrorCode("404");
			jobApplication.setErrorCode("Job applications were not found");
			jobApplications.addAll(jobApplications);
		}
		
		else {
			jobApplication.setErrorCode("202");
			jobApplication.setErrorMessage("Job applications retrieved successfully");
		}
		return new ResponseEntity<JobApplication>(jobApplication, HttpStatus.OK);		
	}
	
	
	
	
	public ResponseEntity<JobApplication> applyForJob(@PathVariable("jobId")String jobId, HttpSession session)
	{
		String username=(String) session.getAttribute("loggedInUserId");
		System.out.println(username);
		
		//If user has not logged in
		if(username==null)
		{
			jobApplication.setErrorCode("404");
			jobApplication.setErrorMessage("Please Login to Continue");
			
		}
		
		return null;
		
	}

}
