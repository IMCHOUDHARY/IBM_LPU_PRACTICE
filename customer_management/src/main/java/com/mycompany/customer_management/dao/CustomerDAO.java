package com.mycompany.customer_management.dao;

import java.util.List;

import com.mycompany.customer_management.domain.Customer;

public interface CustomerDAO 
{
	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public Customer getCustomerByID(String customerID);
}
