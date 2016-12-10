package com.niit.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Table
@Entity
@Component



public class Event 


{
	
@Id
@GeneratedValue

private int id;
private String tittle;
private String description;
private Date eventdate;
private int userid;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTittle() {
	return tittle;
}
public void setTittle(String tittle) {
	this.tittle = tittle;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getEventdate() {
	return eventdate;
}
public void setEventdate(Date eventdate) {
	this.eventdate = eventdate;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}


	
}