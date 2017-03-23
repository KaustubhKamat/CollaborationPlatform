package com.niit.collaborationPlatform.DAO;

import java.util.List;

import com.niit.collaborationPlatform.model.Friend;

public interface FriendDAO {

	public Friend getByid(int id);
	
	public boolean SaveFriend(Friend friend);
	
	public boolean DeleteFriend(Friend friend);
	
	public boolean UpdateFriend(Friend friend);
	
	public List<Friend> getMyFriends(String username);
	
	public List<Friend> getMyFriendRequests(String emailId);
	
	public Friend get(String username, String friendUserName);
	
	public void setOnline(String username);
	
	public void setOffline(String username);
	
	public List<Friend> getMySentFriendRequests(String emailId);
	
	public Integer maxID();
	
	
	
	
	
	
}
