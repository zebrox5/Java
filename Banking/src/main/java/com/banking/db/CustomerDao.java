package com.banking.db;

import org.springframework.jdbc.core.JdbcTemplate;

import com.banking.model.Customer;

public interface CustomerDao {
	
	boolean insert(Customer customer);
	boolean update(Customer customer);
	boolean delete(Customer customer);
	Customer login(Customer customer);
	Customer findUserById(int id);
	Customer findUserByPhone(String phone);
	
	void setJdbcTemplate(JdbcTemplate template);
	
	String INSERT_QRY="INSERT INTO CUSTOMERS VALUES(?,?,?,?)";
	String UPDATE_QRY="UPDATE EMP1 SET CUST_ID=?";
	String DELETE_QRY="DELETE FROM CUSTOMERS  WHERE CUST_ID=?";
	String FIND_QRY_BY_ID="SELECT * FROM CUSTOMERS WHERE CUST_ID=?";
	String FIND_QRY_BY_PHONE="SELECT * FROM CUSTOMERS WHERE PHONE=?";
	String LOGIN_QRY = "SELECT * FROM CUSTOMERS WHERE PHONE=? AND PASSWORD=?";

}
