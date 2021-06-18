package com.banking.service;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banking.db.TransactionDao;
import com.banking.model.Account;
import com.banking.model.Transactions;

public class TransactionService {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	
	//check whether the customer is already present or not
	
	private TransactionDao dao =
			//new TransactionDaoImpl();
			(TransactionDao) ctx.getBean("daoTransactionsBean");
	
	public boolean createAccount(Account account) {
		account.setAccType("saving");
		account.setBalance(0);
		boolean result = dao.insertAccount(account);
		return result;
	}
	
	public boolean isAccountExists(int custId) {
		Account findAccountByCustId = dao.findAccountByCustId(custId);
		if(findAccountByCustId == null) {
			return false;
		} else {
			return true; //account exist
		}
	}
	
	public double getAccountBalance(int custId) {
		
		Account account = dao.findAccountByCustId(custId);
		if(account == null) {
			return 0.0;
		}
		return account.getBalance();
	}
	
//	public void updateAccountBalance(int custId, double withdrawAmout) {
	public boolean updateAccountBalance(Account account) {
		//it needs only custId and new amount
		boolean updateResult = dao.updateAccount(account);
		return updateResult;
	}
	
	public boolean updateTransactions(int custId, Date date, double withdrawAmount, double newBalance, String transactionType) {
		Transactions transactions = new Transactions(custId, date, withdrawAmount, newBalance, transactionType);
		boolean isTransactionInserted = dao.insertTransaction(transactions);
		return isTransactionInserted;
	}
	
	public List<Transactions> getAllTransactions(int custId) {
		return dao.findAllTransactions(custId);
	}

}
