package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.entity.Customer;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication implements CommandLineRunner{

	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceApplication(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		customerDAO.save(new Customer(1,"ankit","delhi"));
		customerDAO.save(new Customer(2,"parag","mumbai"));
	}

}
