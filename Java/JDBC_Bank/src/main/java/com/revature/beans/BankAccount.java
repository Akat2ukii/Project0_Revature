package com.revature.beans;

public class BankAccount {
	
	private int id;
	private int userId;
	private int accountTypeId;
	private double balance;
	
	public BankAccount() {
	}

	public BankAccount(int id, int userId, int accountTypeId, double balance) {
		super();
		this.id = id;
		this.userId = userId;
		this.accountTypeId = accountTypeId;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "BankAccount [AccountId=" + id + ", userId=" + userId + ", accountTypeId=" + accountTypeId + ", balance="
				+ balance + "]";
	}
	
	
	
	
}
