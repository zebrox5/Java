package com.banking.model;

import java.util.Date;

public class Transactions {
	
	int tId;
	int custId;
	Date date;
	double transactionAmt;
	double balance;
	String transactionType;
	
	public Transactions() {
		super();
	}

	public Transactions(int custId, Date date, double transactionAmt, double balance, String transactionType) {
		super();
		this.custId = custId;
		this.date = date;
		this.transactionAmt = transactionAmt;
		this.balance = balance;
		this.transactionType = transactionType;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transactions [tId=" + tId + ", custId=" + custId + ", date=" + date + ", transactionAmt="
				+ transactionAmt + ", balance=" + balance + ", transactionType=" + transactionType + "]";
	}
	
	
	
	
	

}
