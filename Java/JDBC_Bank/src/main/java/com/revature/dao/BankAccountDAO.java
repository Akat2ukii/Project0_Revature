package com.revature.dao;

import java.util.List;

import com.revature.beans.Activity;
import com.revature.beans.BankAccount;
import com.revature.beans.User;

public interface BankAccountDAO {
	
	//user methods 
	public List<BankAccount> getBAccount();
	public BankAccount getBAccountById(int id);
	public void createBAccount (int UserId, int accountTypeID, double balance);
	public void updateBAccount(double balanceOfUser, int idOfUser);
	public void deleteBAccount(User user);
	
	//methods for adding transactions to activity table and user tx history 
	public int getMaxActivity(); 
	public void updateActivity(int bankAccountId, int activityIndx, int activityTypeId, String txDescription, double currentBalance);
	public List<Activity> getActivity(int bankAccountId); 
	
}
