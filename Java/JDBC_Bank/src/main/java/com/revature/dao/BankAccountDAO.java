package com.revature.dao;

import java.util.List;

import com.revature.beans.BankAccount;
import com.revature.beans.User;

public interface BankAccountDAO {
	//user methods 
	public List<BankAccount> getBAccount();
	public BankAccount getBAccountById(int id);
	public void createBAccount (int UserId, int accountTypeID, double balance);
	public void updateBAccount(double balanceOfUser,int bankAccId, int idOfUser);
	public void deleteBAccount(User user);
	
}
