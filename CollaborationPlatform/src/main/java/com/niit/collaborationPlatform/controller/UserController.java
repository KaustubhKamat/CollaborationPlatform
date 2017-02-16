package com.niit.collaborationPlatform.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationPlatform.DAO.UserDAO;
import com.niit.collaborationPlatform.model.User;

@RestController
public class UserController  {
	
	@Autowired
	public User user;
	
	@Autowired
	public UserDAO userDAO;
	
	@Autowired
	public HttpSession session;
	

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
			
			session.setAttribute("loggedInUserId", user.getEmailId());
			session.setAttribute("LoggedInUserRole", user.getRole());
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/validate")
	public ResponseEntity<User> validateCredentials(@RequestParam("emailid")String emailid, @RequestParam("password")
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
	
	@PostMapping("/createNewUser/")
	public ResponseEntity<User> createNewUser(@RequestBody User user)
	{
		if(userDAO.getById(user.getEmailId())==null){
			userDAO.SaveUser(user);
			user.setErrorCode("200");
			user.setErrorMessage("You have successfully registered");
		}
		else {
			user.setErrorCode("404");
			user.setErrorMessage("User exists with this id :" + user.getEmailId());
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	
	/*{
		"username" : "ali",
		"emailid" : "ali@gmail.com",
		"password" : "ali",
		"role" : "admin",
		"mobile" : "8978909787",
		"gender" : "Male",
		"status" : "valid",
		"reason" : "wrong details"
		"isonline" : "Yes"

		}*/
	
	
}
