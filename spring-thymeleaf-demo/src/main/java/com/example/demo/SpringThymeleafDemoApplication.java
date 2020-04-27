package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;

@SpringBootApplication
public class SpringThymeleafDemoApplication implements CommandLineRunner{

	private ProductDAO productDAO;
	
	@Autowired
	public SpringThymeleafDemoApplication(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringThymeleafDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		productDAO.save(new Product("hello", 100.12, "abc.com"));
		productDAO.save(new Product("hi", 900, "xyz.com"));
		productDAO.save(new Product("hey", 1000, "pqr.com"));
	}

}
