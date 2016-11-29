package com.niit.DAO;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDAO {

	public boolean saveOrUpdate(Blog blog);
	public boolean delete(Blog blog);
	public Blog get(int id);
	public List<Blog> list();
	
}