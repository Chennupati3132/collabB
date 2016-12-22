package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.FriendDAO;
import com.niit.DAO.UserDAO;
import com.niit.model.Friend;
import com.niit.model.User;



@RestController
public class FriendController {
	
	/*private static final Logger logger = LoggerFactory.getlogger(FriendController.class);*/
	

@Autowired

private FriendDAO friendDAO;

@Autowired

private UserDAO usersDAO;

@Autowired

private User users;

@Autowired

HttpSession session;

@Autowired

private Friend friend; 

private List<Friend> Users;

@RequestMapping(value="/sendrequest/{fid}",method=RequestMethod.POST)

public ResponseEntity<Friend> sendrequest(@PathVariable("fid") String fid,HttpSession session)
{
	String userid=(String) session.getAttribute("username");

	
	/*String username=(String) session.getAttribute("username");*/
	friend.setUserid(userid);
	friend.setFriendid(fid);
	friend.setStatus('n');
	friendDAO.save(friend);
	return new ResponseEntity<Friend>(friend,HttpStatus.OK); 
}

@RequestMapping(value="/myfriends" ,method=RequestMethod.GET)

public ResponseEntity<List<Friend>> myfriends(HttpSession session)
{
	String uid=(String)session.getAttribute("username");
	List<Friend> myfriends=friendDAO.getmyfriends(uid);
	return new ResponseEntity<List<Friend>>(myfriends , HttpStatus.OK);
	
	
	
}

@RequestMapping(value="/acceptfriend/{fid}", method=RequestMethod.POST)

public ResponseEntity<Friend> acceptfriend(@PathVariable("fid") String fid,HttpSession session)
{
	String uid=(String)session.getAttribute("username");
	Friend friend=friendDAO.acceptfriend(fid, uid);
	friend.setStatus('a');
	friendDAO.update(friend);
	Friend friend1=new Friend();
	friend1.setUserid(uid);
	friend1.setFriendid(fid);
	friend1.setStatus('a');
	friendDAO.save(friend1);
	
	
	return new ResponseEntity<Friend> (friend,HttpStatus.OK);
}

@RequestMapping(value="/rejectfriend/{fid}",method=RequestMethod.POST)

public ResponseEntity<Friend> rejectfriend(@PathVariable("fid") String fid,HttpSession session)

	{

	String uid=(String) session.getAttribute("username");
	Friend friend=friendDAO.acceptfriend(fid, uid);
	//Friend friend1=friendDAO.acceptfriend(id, fid);
	friend.setStatus('r');	//friend.setStatus('r');
	friendDAO.update(friend);
	//friendDAO.update(friend1);
	return new ResponseEntity<Friend>(HttpStatus.OK);

	
	}

@RequestMapping(value="/unfriend/{fid}",method=RequestMethod.POST)

public void unfriend(@PathVariable("fid") String fid,HttpSession session)
{
	String uid=(String)session.getAttribute(fid);
	Friend friend=friendDAO.acceptfriend(uid, fid);
	friend.setStatus('u');
	friendDAO.update(friend);
	Friend friend1=friendDAO.acceptfriend(uid, fid);
	friend1.setStatus('u');
	friendDAO.update(friend1);
	
}
@GetMapping
(value="/newrequests")
public ResponseEntity<List<Friend>> newrequests(HttpSession session){
	String uid=(String) session.getAttribute("username");
	List<Friend> list=friendDAO.getrequestlist(uid);
	return new ResponseEntity<List<Friend>>(list,HttpStatus.OK);
}


/*@RequestMapping(value="/acceptrequest/{fid}")
public ResponseEntity<Friend> acceptFriendFriendRequest(@PathVariable("fid")String fid, HttpSession session) {

	String uid=(String)session.getAttribute("username");
	Friend friend=friendDAO.acceptfriend(uid, fid);
	saveOrUpdate(fid,"A");
	friend.setStatus('a');
	friendDAO.update(friend);
	Friend friend1=new Friend();
	friend1.setUserid(uid);
	friend1.setFriendid(fid);
	friend1.setStatus('a');
	friendDAO.save(friend1);

	return new ResponseEntity<Friend>(friend, HttpStatus.OK);
	
}
*/






























/*@PostMapping(value="/sendrequest/{fid}")
public ResponseEntity<Friend> newfriend(Friend friend,@PathVariable("fid") int fid,HttpSession session){
	//String uid=(String)session.getAttribute("username");
	friend.setFriendid(fid);
	int uid = (Integer) session.getAttribute("uid");
	friend.setUserid(uid);
	friend.setStatus('n');
	friendDAO.saveOrUpdate(friend);
	return new ResponseEntity<Friend>(friend,HttpStatus.OK);
}

@GetMapping(value="/myfriends")
public ResponseEntity<List<Friend>> myfriends(HttpSession session){
	//int uid =(Integer) session.getAttribute("uid");
	//List<Users> u1 = null;
	List<Friend> list=friendDAO.getfriendlist(users.getId());
	System.out.println(list.size());
	for(int i=0;i < list.size();i++){
		System.out.println(i);
		Friend friends = list.get(i);
		System.out.println("friend");
		 int f = friends.getFriendid();
		u1= usersDAO.getuser(f);
	    
		//System.out.println(u1);
	}
	return new ResponseEntity<List<Friend>>(list,HttpStatus.OK);

}
@PostMapping(value="/acceptrequest/{fid}")
public ResponseEntity<Friend> acceptFriendFriendRequest(@PathVariable("fid")String fid) {
  
	String loggedInuid=(String)session.getAttribute("userLogged");
	saveOrUpdateRequest(fid,"A");
	return new ResponseEntity<Friend>(friend, HttpStatus.OK);

//public ResponseEntity<Friend> acceptfriend(HttpSession session){
	int fid = (Integer) session.getAttribute("uid");
	Friend friend =friendDAO.newrequest(fid);
	friend.setStatus('a');
	friendDAO.saveOrUpdate(friend);
	return new ResponseEntity<Friend>(friend,HttpStatus.OK);
}
private void saveOrUpdateRequest(String fid, String string) {
	// TODO Auto-generated method stub
	
}

private void saveOrUpdateRequest(String fid, String string) {
	// TODO Auto-generated method stub
	
}

@PostMapping(value="/rejectrequest")
public ResponseEntity<Friend> rejectfriend(HttpSession session){
	int fid = (Integer) session.getAttribute("uid");
	Friend friend =friendDAO.newrequest(fid);
	friend.setStatus('r');
	friendDAO.saveOrUpdate(friend);
	return new ResponseEntity<Friend>(HttpStatus.OK);
}*/
}