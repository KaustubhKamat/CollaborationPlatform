package com.niit.collaborationPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationPlatform.DAO.UserDAO;
import com.niit.collaborationPlatform.model.User;

@RestController
public class UserController  {
	
	@Autowired
	public User user;
	
	@Autowired
	public UserDAO userDAO;
	

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userDAO.list();
		if(users.isEmpty())
		{
			user.setErrorCode("100");
			user.setErrorMessage("No User is available yet");
			users.add(user);
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);			
		}
		else {
			user.setErrorCode("200");
			user.setErrorMessage("Successfully Fetched the list of the users");
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/validate/{emailid}/{password}")
	public ResponseEntity<User> validateCredentials(@PathVariable("emailid")String emailid, @PathVariable("password")
	String password)
	{
		user=userDAO.isValidUser(emailid, password);
		
		if (user==null) {
			user=new User();
			user.setErrorCode("404");
			user.setErrorMessage("Invalid credentials found");			
			
		}
		
		else {
			user.setErrorCode("200");
			user.setErrorMessage("Successfully logged in as a User");
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	
}
