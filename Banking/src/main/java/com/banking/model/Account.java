package com.banking.model;

public class Account {
	
	int accId;
	int custId;
	String accType;
	double balance;
	
	public Account() {
		super();
	}
	public Account(int custId, String accType, double balance) {
		super();
		this.custId = custId;
		this.accType = accType;
		this.balance = balance;
	}
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accId=" + accId + ", custId=" + custId + ", accType=" + accType + ", balance=" + balance + "]";
	}
	

}
