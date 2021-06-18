package com.banking.model;

public class Customer {
	
	int custId;
	 
	String custName;
	String phoneNumber;
	String password;
	
	public Customer() {
		super();
	}
	public Customer(String custName, String phoneNumber, String password) {
		super();
		this.custName = custName;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", phoneNumber=" + phoneNumber + ", password="
				+ password + "]";
	}

}
