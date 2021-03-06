package com.niit.collaborationplatform;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationPlatform.DAO.JobApplicationDAO;
import com.niit.collaborationPlatform.model.JobApplication;

import junit.framework.Assert;

public class JobApplicationDAOImplTestCase {

	@Autowired
	static JobApplication jobApplication;

	@Autowired
	static JobApplicationDAO jobApplicationDAO;

	@Autowired
	static AnnotationConfigApplicationContext context;

	/*@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobApplicationDAO = (JobApplicationDAO) context.getBean("jobApplicationDAOImpl");
		jobApplication = (JobApplication) context.getBean("jobApplication");
	}*/
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobApplicationDAO=(JobApplicationDAO) context.getBean("jobApplicationDAOImpl");
		jobApplication=(JobApplication) context.getBean("jobApplication");
	}
	

	@SuppressWarnings("deprecation")
	//@Test
	public void CreateJobApplicationTestCase() {
		jobApplication.setId(2);
		jobApplication.setJobId("2");
		jobApplication.setUsername("Vijay");
		Date date_applied = new Date();
		jobApplication.setDate_applied(date_applied);
		jobApplication.setRemarks("Y");
		jobApplication.setStatus('Y');

		Assert.assertEquals("createJobApplicationTestCase", true,
				jobApplicationDAO.SaveJobApplication(jobApplication));

	}

	@SuppressWarnings("deprecation")
	//@Test 
	public void DeleteJobApplicationTestCase()
     {
		jobApplication=jobApplicationDAO.getJobApplication(2);
    	 Assert.assertEquals("DeleteBlogTestCase", false,jobApplicationDAO.DeleteJobApplication(jobApplication));
    	 
     }
	
	//@Test
    @SuppressWarnings("deprecation")
	public void UpdateJobApplicationTestCase()
    {
    jobApplication=jobApplicationDAO.getJobApplication(2);
    jobApplication.setUsername("Virat");
   	 
   	 Assert.assertEquals("DeleteBlogTestCase", false, jobApplicationDAO.UpdateJobApplication(jobApplication));
    }
	
	@Test
    public void getJobApplicationById()
    {
	jobApplication=jobApplicationDAO.getJobApplication(2);	
    System.out.println(jobApplication.getUsername());
    }
	
}
