package com.niit.collaborationPlatform.DAO;

import java.util.List;

import com.niit.collaborationPlatform.model.JobApplication;

public interface JobApplicationDAO {

	public JobApplication getJobApplication(int id);
	
	public JobApplication getJobApplication(String emailId, String JobId);
	
	public List<JobApplication> list();
	
	public boolean SaveJobApplication(JobApplication jobApplication);
	
	public boolean DeleteJobApplication(JobApplication jobApplication);
	
	public boolean UpdateJobApplication(JobApplication jobApplication);
	
	public List<JobApplication> myAppliedJob(String username);
	
}
