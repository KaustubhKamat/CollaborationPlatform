package com.niit.collaborationplatform;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationPlatform.DAO.FriendDAO;
import com.niit.collaborationPlatform.model.Friend;

import junit.framework.Assert;

public class FriendDAOImplTestCase {

	@Autowired
	static Friend friend;
	
	@Autowired
	static FriendDAO friendDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		friendDAO=(FriendDAO) context.getBean("friendDAOImpl");
		friend=(Friend) context.getBean("friend");
	}
	
	@SuppressWarnings("deprecation")
	//@Test
	public void CreateFriendTestCase()
	{
		friend.setId(3);
		friend.setEmailId("vijay@gmail.com");
		friend.setFriendEmailId("kaustubh235@gmail.com");;
		friend.setStatus('N');
		friend.setIsOnline('Y');
		
		Assert.assertEquals("createJobApplicationTestCase", false,friendDAO.SaveFriend(friend));
	}
	
	@SuppressWarnings("deprecation")
	//@Test 
	public void DeleteBlogTestCase()
     {
    	 //friend=friendDAO.ge
    	 Assert.assertEquals("DeletefriendTestCase", false, friendDAO.DeleteFriend(friend));
    	 
     }

    
    @SuppressWarnings("deprecation")
	//@Test
    public void UpdatefriendTestCase()
    {
   	 friend=friendDAO.getByid(1);
   	 friend.setFriendEmailId("sunny@gmail.com");
   	 Assert.assertEquals("DeletefriendTestCase", false, friendDAO.UpdateFriend(friend));
    }
    
    @Test
    public void getByIDTestCase()
    {
    friend=friendDAO.getByid(1);
    System.out.println(friend.getFriendEmailId());
    }
}
				