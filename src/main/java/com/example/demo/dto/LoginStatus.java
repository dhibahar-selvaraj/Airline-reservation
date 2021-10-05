package com.example.demo.dto;

import com.example.demo.model.AirUser;

public class LoginStatus extends Status{
	
	private String firstName;
	private String lastName;
	private AirUser user;
	public AirUser getUser() {
		return user;
	}
	public void setUser(AirUser user) {
		this.user = user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
