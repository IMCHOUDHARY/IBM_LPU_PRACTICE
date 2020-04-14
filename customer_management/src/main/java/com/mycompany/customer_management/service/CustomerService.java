package com.mycompany.customer_management.service;

import java.util.List;

import com.mycompany.customer_management.domain.Customer;

public interface CustomerService 
{
	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomer();
	public Customer getCustomerByID(String customerID);
}
