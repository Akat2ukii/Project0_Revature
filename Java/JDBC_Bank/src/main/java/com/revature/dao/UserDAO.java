package com.revature.dao;

import java.util.List;

// import com.revature.beans.AllAccountDetails;
import com.revature.beans.BankAccount;
import com.revature.beans.User;

public interface UserDAO {
	
	//user methods 
	public List<User> getUser();
	public List<User> getUserbyID(int  userId); 
	public List<User> getUserByUserNamePassword(String userName, String password);
	public void createUser (String firstName, String lastName, String userName, String password, int userTypeId);
	//public void updateUser(User user);
		//public void deleteUser(User user);
	
	// related to accounts 
	public List<BankAccount> getAccountDetails(int userId);
	List<BankAccount> getAllAccountDetails();
	
	//superuser methods 
	public void superUpdateUser(String firstName, String lastName, String uName, String pWord, int uIdToUpdate); 
	public void superDeleteUser(int uIdToDelete);
	
}
