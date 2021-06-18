package com.banking.ui;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.banking.db.TransactionDao;
import com.banking.db.TransactionDaoImpl;
import com.banking.model.Account;
import com.banking.model.Transactions;

public class ClientTransactions {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

	TransactionDao dao =
			//new TransactionDaoImpl();
			(TransactionDao) ctx.getBean("daoTransactionsBean");
	
	public void insertAccountTest() {
		Account account = new Account();
		account.setCustId(3);
		account.setAccType("saving");
		account.setBalance(6000.0);
		
		System.out.println(dao.insertAccount(account));

	}
	
	public void insertTransactionsTest() {
		Transactions tr = new Transactions();
		tr.setCustId(1);
		tr.setDate(new Date(System.currentTimeMillis()));
		tr.setTransactionAmt(400);
		tr.setBalance(800);
		tr.setTransactionType("deposit");
		
		System.out.println(dao.insertTransaction(tr));
		
	}
	
	public void updateAccountTest() {
		Account account = new Account();
		account.setCustId(1);
		account.setAccType("saving");
		account.setBalance(15000.0);
		
		System.out.println(dao.updateAccount(account));
		
	}
	
	public void findAccountByCustIdTest() {
		int id = 5;
		System.out.println(dao.findAccountByCustId(id));
		
	}
	public void findAllTransactionsTest() {
		int id = 1;
		System.out.println(dao.findAllTransactions(id));
		
	}

	
	public void setJdbcTemplate() {
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		dao.setJdbcTemplate(jdbcTemplate);
	}

	public static void main(String[] args) {
		ClientTransactions app = new ClientTransactions();
		app.setJdbcTemplate();
		
//		app.insertAccountTest();
//		app.updateAccountTest();
//		app.findAccountByCustIdTest();
//		app.insertTransactionsTest();
		app.findAllTransactionsTest();
		
	}

}
