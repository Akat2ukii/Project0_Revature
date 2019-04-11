package com.revature.beans;

public class AllAccountDetails {

	//instance variables 
	int bankAccountId;
	int accountTypeId;
	double balance; 
	int userId; 
	String firstName; 
	String lastName; 
	String userName; 
	String passWord; 
	int userTypeId;
	
	//constructors 
	public AllAccountDetails() {
		super();
	}
	public AllAccountDetails(int bankAccountId, int accountTypeId, double balance, int userId, String firstName,
			String lastName, String userName, String passWord, int userTypeId) {
		super();
		this.bankAccountId = bankAccountId;
		this.accountTypeId = accountTypeId;
		this.balance = balance;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.userTypeId = userTypeId;
	}
	
	//setters and getters 
	public int getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	
	//toString
	@Override
	public String toString() {
		return "AllAccountDetails [bankAccountId=" + bankAccountId + ", accountTypeId=" + accountTypeId + ", balance="
				+ balance + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", passWord=" + passWord + ", userTypeId=" + userTypeId + "]";
	} 
	
	
}
