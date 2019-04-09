package com.revature.beans;

public class Account {
	
	//instance variables 
	private int bankAccountId; 
	private int userId; 
	private String accountTypeId; 
	private double balance;
	
	
	//constructors 
	public Account() {
		super();
	}
	public Account(int bankAccountId, int userId, String accountTypeId, double balance) {
		super();
		this.bankAccountId = bankAccountId;
		this.userId = userId;
		this.accountTypeId = accountTypeId;
		this.balance = balance;
	}


	//getters and setters 
	public int getBankAccountId() {
		return bankAccountId;
	}
	public void setBankAccountId(int bankAccountId) {
		this.bankAccountId = bankAccountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//toString method 
	@Override
	public String toString() {
		return "Account [bankAccountId=" + bankAccountId + ", userId=" + userId + ", accountTypeId=" + accountTypeId
				+ ", balance=" + balance + "]";
	} 
	
	
	

}
