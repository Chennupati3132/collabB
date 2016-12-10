package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.EventDAO;
import com.niit.model.Event;


@RestController

public class EventController 

{

@Autowired

EventDAO eventDAO;

/*@Autowired
Event event;
*/
@RequestMapping(value="/CreateEvent" , method=RequestMethod.POST)

public ResponseEntity<Event> addevent(@RequestBody Event event)
{
	System.out.println("Hello Event");
	
	eventDAO.save(event);
	
	
	return new ResponseEntity<Event>(event,HttpStatus.OK);
	
}

@RequestMapping(value="/updateEvent" ,method=RequestMethod.PUT)


public ResponseEntity<Event> updateevent(@RequestBody Event event)
{
	System.out.println("Event Update");
	eventDAO.update(event);
	return new ResponseEntity<Event>(event,HttpStatus.OK);
	
	
	
}


@RequestMapping(value="/Event", method=RequestMethod.GET)

public ResponseEntity<List<Event>>listEvent()
{
System.out.println("List The Events");
List<Event> event=eventDAO.list();

	
	return new ResponseEntity<List<Event>>(event,HttpStatus.OK);
	
}

@RequestMapping(value="/deleteevent/{id}" ,method=RequestMethod.DELETE)
	public ResponseEntity<Event> deleteevent(@RequestBody Event event)
	
	{
	
		
		System.out.println("Delete Event");
		eventDAO.delete(event);
		return new ResponseEntity<Event>(event,HttpStatus.OK);
		
	
	
	
	
	}
}