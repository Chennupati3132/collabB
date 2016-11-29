package com.niit.DAO;

import java.util.List;

import com.niit.model.Forum;

public interface ForumDAO {
	
	public boolean saveOrUpdate(Forum forum);
	public boolean delete(Forum forum);
	public List<Forum> list();
	public Forum get(int id);

}