package com.niit.DAO;

import java.util.List;

import com.niit.model.Friend;



public interface FriendDAO

{

	public boolean save(Friend friend);
	public boolean update(Friend friend);
	public List<Friend> getmyfriends(String uid);
	public Friend newrequest(String uid,String fid);
	public List<Friend> getrequestlist(String uid);
	public Friend acceptfriend(String uid,String fid);
	public List<Friend> acceptedfriends(String uid,String fid);
	public boolean unfriend(Friend friend);
	
}