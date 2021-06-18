package com.banking.db;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.banking.model.Transactions;

public class TransactionsRowMapper implements RowMapper<Transactions>  {
	
	public Transactions mapRow(ResultSet rs, int rn) throws SQLException {
		
		Transactions transactions = new Transactions();
		transactions.settId(rs.getInt(1));
		transactions.setCustId(rs.getInt(2));
		Date date = rs.getDate(3);
		java.util.Date utilDate = new java.util.Date(date.getTime());
		System.out.println("Util date is " + utilDate);
		transactions.setDate(utilDate);
		transactions.setTransactionAmt(rs.getDouble(4));
		transactions.setBalance(rs.getDouble(5));
		transactions.setTransactionType(rs.getString(6));
		
		return transactions;
	}

}
