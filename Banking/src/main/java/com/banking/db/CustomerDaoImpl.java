package com.banking.db;

import org.springframework.jdbc.core.JdbcTemplate;

import com.banking.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean insert(Customer user) {
		try {

			int r;
			Object[] arr = new Object[4];
			arr[0] = user.getCustId();
			arr[1] = user.getCustName();
			arr[2] = user.getPhoneNumber();
			arr[3] = user.getPassword();
	

			r = this.jdbcTemplate.update(INSERT_QRY, arr);
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
	public boolean update(Customer user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findUserById(int id) {
		Object[] arr = new Object[] { id };
		try {
			Customer emp = this.jdbcTemplate.queryForObject(FIND_QRY_BY_ID, arr, new CustomerRowMapper());

			return emp;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Customer findUserByPhone(String number) {
		Object[] arr = new Object[] { number };
		try {
			Customer emp = this.jdbcTemplate.queryForObject(FIND_QRY_BY_PHONE, arr, new CustomerRowMapper());
			
			return emp;
		} catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Customer login(Customer customer) {
		Object[] arr = new Object[] { customer.getPhoneNumber(), customer.getPassword() };
		try {
			Customer cust = this.jdbcTemplate.queryForObject(LOGIN_QRY, arr, new CustomerRowMapper());
			
			return cust;
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
