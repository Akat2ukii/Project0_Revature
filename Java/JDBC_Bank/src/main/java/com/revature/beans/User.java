package com.revature.beans;

public class User {
	
	//instance variables 
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int userTypeId;
	
	//constructors 
	public User() {
	}
	public User(int id, String firstName, String lastName, String username, String password, int userTypeId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userTypeId = userTypeId;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	//getters and setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	
	@Override
	public String toString() {
		return "User [userId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", userTypeId=" + userTypeId + "]";
	}
}
