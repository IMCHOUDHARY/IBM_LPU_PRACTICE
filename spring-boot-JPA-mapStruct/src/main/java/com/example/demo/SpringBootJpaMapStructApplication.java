package com.example.demo;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.AccountDAO;
import com.example.demo.data.Account;

@SpringBootApplication
public class SpringBootJpaMapStructApplication implements CommandLineRunner{
	
	private AccountDAO accountDAO;
	
	public SpringBootJpaMapStructApplication(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMapStructApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountDAO.save(new Account(UUID.randomUUID().toString(), "Savings", 5000));
		accountDAO.save(new Account(UUID.randomUUID().toString(), "Credit Card", 4000));
		accountDAO.save(new Account(UUID.randomUUID().toString(), "Loan", 20000));
		accountDAO.save(new Account(UUID.randomUUID().toString(), "Savings", 10000));
	}

}
