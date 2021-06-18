package com.banking.db;

import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.jdbc.core.JdbcTemplate;

import com.banking.model.Account;
import com.banking.model.Transactions;

public class TransactionDaoImpl implements TransactionDao{
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insertAccount(Account account) {
		try {

			/*
			arr[0] = account.getAccId();
			arr[1] = account.getCustId();
			arr[2] = account.getAccType();
			arr[3] = account.getBalance();
			 */
			System.out.println(account + " => " + this.jdbcTemplate);
			int r;
			Object[] arr = new Object[4];
			arr[1] = account.getCustId();
			arr[2] = account.getAccType();
			arr[3] = account.getBalance();
	
			r = this.jdbcTemplate.update(INSERT_ACCOUNT_QRY, arr);
			if (r > 0) {
				return true;

			} else {
				return false;
			}

		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insertTransaction(Transactions transaction) {
		try {

			int r;
			Object[] arr = new Object[6];
			
			//arr[0] = t_id which is auto increment
			arr[1] = transaction.getCustId();
			
			Date utilDate = transaction.getDate();
			java.sql.Date sqlPackageDate
            = new java.sql.Date(utilDate.getTime());
			
			arr[2] = sqlPackageDate;
			arr[3] = transaction.getTransactionAmt();
			arr[4] = transaction.getBalance();
			arr[5] = transaction.getTransactionType();
	
			r = this.jdbcTemplate.update(INSERT_TRANSACTION_QRY, arr);
			if (r > 0) {
				return true;

			} else {
				return false;
			}

		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAccount(Account account) {
		try {
			Object[] arr = new Object[2];
			arr[0] = account.getBalance();
			arr[1] = account.getCustId();
			
			int r;
			r = this.jdbcTemplate.update(UPDATE_QRY, arr);
			if(r > 0) {
				return true;
			} else {
				return false;
			}
			
		}catch(Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account findAccountByCustId(int id) {
		Object[] arr = new Object[] { id };
		try {
			Account account = (Account) this.jdbcTemplate.queryForObject(FIND_ACCOUNT_QRY, arr, new AccountRowMapper());
			return account;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Transactions> findAllTransactions(int id) {
		Object[] arr = new Object[] { id };
		try {
			List<Transactions> transactionsList =  this.jdbcTemplate.query(FIND_ALL_TRANSACTION_QRY, arr, new TransactionsRowMapper());
			return transactionsList;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	@Override
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}

}
