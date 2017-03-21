package com.niit.collaborationPlatform.DAO;

import java.util.List;

import com.niit.collaborationPlatform.model.Friend;

public interface FriendDAO {

	public boolean SaveFriend(Friend friend);
	
	public boolean DeleteFriend(Friend friend);
	
	public boolean UpdateFriend(Friend friend);
	
	public List<Friend> getMyFriends(String friendEmailId);
	
	public List<Friend> getMyFriendRequests(String emailId);
	
	public Friend get(String emailId, String friendEmailId);
	
	public void setOnline(String emailId);
	
	public void setOffline(String emailId);
	
	//public List<Friend> getMyFriendRequests(String emailId);
	
	public Integer maxID();
	
	
	
	
	
	
}
