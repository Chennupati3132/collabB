package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="USERDETAILS")
@Component
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String role;
	private String email;
	private String password;
	private String confirmpassword;
	private int  phone;
	private String address;
	private Date dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMail() {
		return email;
	}
	public void setMail(String mail) {
		this.email = mail;
	}
	public String getPassword() {
		return password;
	}
	
	public String confirmPassword() {
		return confirmpassword;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobile() {
		return phone;
	}
	public void setMobile(int mobile) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	private String gender;
	private char status;
	
	
	
	
}