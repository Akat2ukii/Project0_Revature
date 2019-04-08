package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface UserDAO {
	
	public List<User> getUser();
	public User getUserById(int id);
	public void createUser (String firstName, String lastName, String userName, String password, int userTypeId);
	public void updateUser(User user);
	public void deleteUser(User user);
}
