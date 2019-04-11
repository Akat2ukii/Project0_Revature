package com.revature.beans;

import java.time.LocalDate;

public class Activity {
	
	//bean instance variables 
	private int actId; 
	private int bankAccoutId; 
	private int actTypeId; 
	private LocalDate txDate; 
	private String txDescribe; 
	private Double currentBalance;
	public int getActId() {
		return actId;
	}
	
	//constructors
	public Activity() {
		super();
	}
	public Activity(int actId, int bankAccoutId, int actTypeId, LocalDate txDate, String txDescribe,
			Double currentBalance) {
		super();
		this.actId = actId;
		this.bankAccoutId = bankAccoutId;
		this.actTypeId = actTypeId;
		this.txDate = txDate;
		this.txDescribe = txDescribe;
		this.currentBalance = currentBalance;
	}
	
	//getters and setters 
	public void setActId(int actId) {
		this.actId = actId;
	}
	public int getBankAccoutId() {
		return bankAccoutId;
	}
	public void setBankAccoutId(int bankAccoutId) {
		this.bankAccoutId = bankAccoutId;
	}
	public int getActTypeId() {
		return actTypeId;
	}
	public void setActTypeId(int actTypeId) {
		this.actTypeId = actTypeId;
	}
	public LocalDate getTxDate() {
		return txDate;
	}
	public void setTxDate(LocalDate txDate) {
		this.txDate = txDate;
	}
	public String getTxDescribe() {
		return txDescribe;
	}
	public void setTxDescribe(String txDescribe) {
		this.txDescribe = txDescribe;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "Activity [id=" + actId + ", Account=" + bankAccoutId + ", Type ID=" + actTypeId + ", Date="
				+ txDate + ", Note=" + txDescribe + ", Balance=" + currentBalance + "]";
	} 
	
}
