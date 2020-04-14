package com.mycompany.customer_management.service;

import java.util.List;

import com.mycompany.customer_management.dao.CustomerDAO;
import com.mycompany.customer_management.dao.CustomerDAOImpl;
import com.mycompany.customer_management.domain.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO dao;
	
	{
		dao=new CustomerDAOImpl();
	}
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.createCustomer(customer);
	}

	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return dao.getAllCustomer();
	}

	public Customer getCustomerByID(String customerID) {
		// TODO Auto-generated method stub
		return dao.getCustomerByID(customerID);
	}

}
