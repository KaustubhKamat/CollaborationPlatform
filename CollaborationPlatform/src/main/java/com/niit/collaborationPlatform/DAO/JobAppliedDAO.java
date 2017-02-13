package com.niit.collaborationPlatform.DAO;

import java.util.List;

import com.niit.collaborationPlatform.model.JobApplied;

public interface JobAppliedDAO {

	public JobApplied getJobApplication(String id);
	
	public JobApplied getJobApplication(String emailId, String JobId);
	
	public List<JobApplied> list();
	
	public boolean SaveJobApplication(JobApplied jobApplied);
	
	public boolean DeleteJobApplication(JobApplied jobApplied);
	
	public boolean UpdateJobApplication(JobApplied jobApplied);
	
	public List<JobApplied> list(String emailId);
	
}
