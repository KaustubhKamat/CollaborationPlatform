package com.niit.collaborationplatform;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationPlatform.DAO.ChatDAO;
import com.niit.collaborationPlatform.model.Chat;

import junit.framework.Assert;

public class ChatDAOImplTestCase {

	@Autowired
	static Chat chat ;
	
	@Autowired
	static ChatDAO chatDAO;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		chatDAO=(ChatDAO) context.getBean("chatDAOImpl");
		chat=(Chat) context.getBean("chat");	
	}
	
	
	@SuppressWarnings("deprecation")
	//@Test
	public void CreateChatTestCase()
	{
		chat.setId(2);
		chat.setEmailid("abcd235@gmail.com");
		chat.setFriendemailid("efgh@gmail.com");
		chat.setMessage("Welcome to Chat");
		Date date_time=new Date();
		chat.setDate_time(date_time);
		Assert.assertEquals("createChatTestCase", false, chatDAO.SaveChat(chat));
	}

    @SuppressWarnings("deprecation")
	//@Test 
	public void DeleteChatTestCase()
     {
    	chat=chatDAO.getid(2);
    	 Assert.assertEquals("DeleteChatTestCase", false, chatDAO.DeleteChat(chat));
       
     }

    
    @SuppressWarnings("deprecation")
	//@Test
    public void UpdateChatTestCase()
    {
   	 chat=chatDAO.getById(1);
   	 chat.setMessage("This is second message");
	
    Assert.assertEquals("DeleteChatTestCase", false, chatDAO.UpdateChat(chat));
   	 
    }

    
    @Test
    public void getByIDTestCase()
    {
    chat=chatDAO.getById(1);	
    System.out.println(chat.getEmailid());
    }
    
}


