package com.niit.DAO;

import java.util.List;

import com.niit.model.Event;

public interface EventDAO 

{

	public boolean save(Event event);
	
	public boolean update(Event event);
	
	public boolean delete(Event event);

	public List<Event> list();
	
	
	
}