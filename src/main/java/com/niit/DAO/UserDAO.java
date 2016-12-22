package com.niit.DAO;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {

	public boolean saveOrUpdate(User user);
	public boolean delete(User user);
	public List<User>list();
	public User get(int id);
	public List<User> getuser(String id);
	public User logout(int id);
	public User authuser(String username,String password);
	public User profileof(String username);

}