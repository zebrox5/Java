package com.banking.db;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.banking.model.Account;
import com.banking.model.Transactions;

public interface TransactionDao {
	
	boolean insertAccount(Account account);
	boolean insertTransaction(Transactions transactions);
	boolean updateAccount(Account account);
	boolean deleteAccount(Account account);
	Account findAccountByCustId(int id);
	List<Transactions> findAllTransactions(int id);
	
	void setJdbcTemplate(JdbcTemplate template);
		
	String INSERT_ACCOUNT_QRY="INSERT INTO ACCOUNTS VALUES (?,?,?,?)";
//	String INSERT_ACCOUNT_QRY="INSERT INTO ACCOUNTS (CUST_ID, ACC_TYPE, BALANCE) VALUES (?,?,?,?)";
	String INSERT_TRANSACTION_QRY="INSERT INTO TRANSACTIONS VALUES(?,?,?,?,?,?)";
	String UPDATE_QRY="UPDATE ACCOUNTS SET BALANCE=? WHERE CUST_ID=?";
	String DELETE_QRY="DELETE FROM ACCOUNTS WHERE CUST_ID=?";
	String FIND_ACCOUNT_QRY="SELECT * FROM ACCOUNTS WHERE CUST_ID=?";
	String FIND_ALL_TRANSACTION_QRY="SELECT * FROM TRANSACTIONS WHERE CUST_ID=?";

}
