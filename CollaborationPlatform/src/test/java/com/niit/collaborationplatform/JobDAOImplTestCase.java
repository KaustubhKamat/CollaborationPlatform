package com.niit.collaborationplatform;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationPlatform.DAO.JobDAO;
import com.niit.collaborationPlatform.model.Job;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class JobDAOImplTestCase {

	@Autowired
	static Job job;

	@Autowired
	static JobDAO jobDAO;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		jobDAO = (JobDAO) context.getBean("jobDAOImpl");
		job = (Job) context.getBean("job");
	}

	@Test
	public void CreateJobTestCase() {
		job.setId(1);
		job.setTitle("Title 1");
		job.setQualification("BE IT");
		job.setStatus("Valid");
		Date date_time = new Date();
		job.setDate_time(date_time);
		job.setDescription("Only Mechanical candicates are allowed");
		Assert.assertEquals("createJobTestCase", false, jobDAO.SaveJob(job));
	}

	// @Test
	public void DeleteJobTestCase() {
		job = jobDAO.getByid(2);
		Assert.assertEquals("DeleteJobTestCase", false, jobDAO.DeleteJob(job));

	}

	@SuppressWarnings("deprecation")
	@Test
	public void UpdateJobTestCase() {
		job=jobDAO.getByid(1);
		job.setDescription("Only Mechanical candidatas are allowed");

		Assert.assertEquals("DeleteJobTestCase", false,jobDAO.UpdateJob(job) );

	}

	/*
	 * @Test public void getByIDTestCase() { chat=chatDAO.getById(1);
	 * System.out.println(chat.getEmailid()); }
	 */

}
