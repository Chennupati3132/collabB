/*package com.niit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@RestController

public class UserController {

@Autowired
private UserDAO usersDAO;

@PostMapping(value="/register")
public ResponseEntity<User> adduser( @RequestBody User users){
	System.out.println("hello");
	usersDAO.save(users);
	return new ResponseEntity<User>(users, HttpStatus.OK);
	
}
@GetMapping(value="/users")
public ResponseEntity<List<User>> listuser(){
	System.out.println("list of users");
	List<User> users1 =usersDAO.list();
	return new ResponseEntity<List<User>>(users1,HttpStatus.OK);
	
}

@GetMapping(value="/oneuser")
public ResponseEntity<User> oneuser(HttpSession session){
	String username=(String) session.getAttribute("username");
	User oneuser=usersDAO.profileof(username);
	return new ResponseEntity<User>(oneuser,HttpStatus.OK);
}
@PostMapping("/imageUpload")
public void ImageUpload(@RequestBody MultipartFile file,HttpSession session) throws IOException {
	
	String username = (String) session.getAttribute("username"); Get Logged in Username
	User users=usersDAO.profileof(username);					Get user object based on username
	System.out.println(file.getContentType()+'\n'+file.getName()+'\n'+file.getSize()+'\n'+file.getOriginalFilename());
	users.setImage(file.getBytes());
	usersDAO.save(users);
}

@GetMapping("/profileimage")
public ResponseEntity<User> profileimage(HttpSession session){
	String uid=(String) session.getAttribute("uid");
	User users=usersDAO.oneuser(uid);
	return new ResponseEntity<User>(users, HttpStatus.OK);
}
}*/


package com.niit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;


@PostMapping(value="/register")
public ResponseEntity<User> adduser(@RequestBody User user){
	System.out.println("hello");
	userDAO.saveOrUpdate(user);
	return new ResponseEntity<User>(user, HttpStatus.OK);
	
}
@GetMapping(value="/user")
public ResponseEntity<List<User>> listuser(){
	System.out.println("list of user");
	List<User> user1 =userDAO.list();
	return new ResponseEntity<List<User>>(user1,HttpStatus.OK);
	
	
}
@DeleteMapping(value="/deleteuser/{id}")
public ResponseEntity<User> deleteblog(User user,@PathVariable("id") int id){
	User user1=userDAO.get(id);
	userDAO.delete(user);
	return new ResponseEntity<User>(user,HttpStatus.OK);
}
@PostMapping("/imageUpload")
public void ImageUpload(@RequestBody MultipartFile file,HttpSession session) throws IOException {
	
	String username = (String) session.getAttribute("username"); /*Get Logged in Username*/
	User users=userDAO.profileof(username);					/*Get user object based on username*/
	System.out.println(file.getContentType()+'\n'+file.getName()+'\n'+file.getSize()+'\n'+file.getOriginalFilename());
	users.setImage(file.getBytes());
	userDAO.saveOrUpdate(users);
}

@GetMapping("/profileimage")
public ResponseEntity<User> profileimage(HttpSession session){
	int uid=(Integer) session.getAttribute("uid");
	User users=userDAO.get(uid);
	return new ResponseEntity<User>(users, HttpStatus.OK);
}

@GetMapping(value="/oneuser")
public ResponseEntity<User> oneuser(HttpSession session){
	String username=(String) session.getAttribute("username");
	User oneuser=userDAO.profileof(username);
	return new ResponseEntity<User>(oneuser,HttpStatus.OK);
}
}