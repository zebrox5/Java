package com.banking.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banking.db.CustomerDao;
import com.banking.model.Customer;

public class AuthService {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	
	//check whether the customer is already present or not
	
	CustomerDao dao = (CustomerDao) ctx.getBean("daoBean");
	
	public boolean registerCustomer(Customer customer) {

		boolean result = dao.insert(customer);
		return result;
	}
	
	public Customer findCustomer(String phoneNumber) {

		return dao.findUserByPhone(phoneNumber);
		
	}
	public Customer findCustomerById(int custId) {
		
		return dao.findUserById(custId);
		
	}

	public boolean authenticate(String phone, String password) {
		Customer customer  = new Customer(null, phone, password);
		
		Customer find = dao.login(customer);
		if(find == null) {
			return false;
		} else {
			return true;
		}
		
		
	}


}
