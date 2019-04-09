package com.revature.dao;

import java.util.List;

import com.revature.beans.User;

public interface BankAccountDAO {
	//user methods 
	public List<User> getBAccount();
	public User getBAccountById(int id);
	public void createBAccount (int UserId, int accountTypeID, double balance);
	public void updateBAccount(User user);
	public void deleteBAccount(User user);
	
}
