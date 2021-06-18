package com.banking.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.banking.model.Account;
import com.banking.model.Customer;

public class AccountRowMapper implements RowMapper<Account>  {
	
	public Account mapRow(ResultSet rs, int rn) throws SQLException {
		Account account = new Account();
		account.setAccId(rs.getInt(1));
		account.setCustId(rs.getInt(2));
		account.setAccType(rs.getString(3));
		account.setBalance(rs.getDouble(4));
		
		return account;
	}

}
