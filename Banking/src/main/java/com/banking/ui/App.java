package com.banking.ui;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.banking.db.CustomerDao;
import com.banking.model.Customer;

public class App {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

	CustomerDao dao = (CustomerDao) ctx.getBean("daoBean");
	
	
	
	private final Logger logger = Logger.getLogger(this.getClass());
	 
	public void insertTest() {
		Customer customer = new Customer();
		customer.setCustName("Abhi");
		customer.setPhoneNumber("1111111");
		customer.setPassword("password");
		
		System.out.println(dao.insert(customer));

	}

	public void findByIdTest() {
		int id = 1;
		System.out.println(dao.findUserById(id));
	}

	public void findByIdPhone() {
		System.out.println(dao.findUserByPhone("1111111"));
	}

	public void loginTest() {
		Customer customer = new Customer();

		customer.setCustName("Abhi");
		customer.setPhoneNumber("1111111");
		customer.setPassword("password");
		System.out.println(dao.login(customer));
	}
	
	public void setJdbcTemplate() {
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		dao.setJdbcTemplate(jdbcTemplate);
	}

	public static void main(String[] args) {
//		App app = new App();
//		app.setJdbcTemplate();
//		app.insertTest();
//		app.findByIdTest();
//		app.findByIdPhone();
//		app.loginTest();
		testArr();
	}

	private static void testArr() {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(8);
		
		System.out.println(list.indexOf(4));
	}

}
