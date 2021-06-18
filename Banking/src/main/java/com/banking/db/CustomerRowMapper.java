package com.banking.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.banking.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer>  {
	
	public Customer mapRow(ResultSet rs, int rn) throws SQLException {
		Customer customer = new Customer();
		customer.setCustId(rs.getInt(1));
		customer.setCustName(rs.getString(2));
		customer.setPhoneNumber(rs.getString(3));
		customer.setPassword(rs.getString(4));
		
		return customer;
	}

}
