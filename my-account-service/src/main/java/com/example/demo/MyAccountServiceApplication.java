package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.dao.AccountDAO;
import com.example.demo.model.Account;

@SpringBootApplication
@EnableEurekaClient
public class MyAccountServiceApplication implements CommandLineRunner{

	private AccountDAO accountDAO;
	
	@Autowired
	public MyAccountServiceApplication(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyAccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountDAO.save(new Account(1,11,UUID.randomUUID().toString()));
		accountDAO.save(new Account(2,12,UUID.randomUUID().toString()));
		accountDAO.save(new Account(3,13,UUID.randomUUID().toString()));
	}

}
