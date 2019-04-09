package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface BankAccountDAO {
	//user methods 
	public List<User> getBAccount();
	public User getBAccountById(int id);
	public void createBAccount (String firstName, String lastName, String userName, String password, int userTypeId);
	public void updateBAccount(User user);
	public void deleteBAccount(User user);
	
}
