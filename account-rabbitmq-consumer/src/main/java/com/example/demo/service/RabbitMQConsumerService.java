package com.example.demo.service;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.model.Account;

@Service
public class RabbitMQConsumerService {
	
	public AccountDAO accountDAO;
	
	@Autowired
	public RabbitMQConsumerService(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	private static final String QUEUE = "accounts-queue";

	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Account account) {

		System.out.println("Received Message from Items Queue >>" + account);
		accountDAO.save(account);
	}

	public Account getAccountById(int id) {
		// TODO Auto-generated method stub
		return accountDAO.findById(id).get();
	}

	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return (List<Account>) accountDAO.findAll();
	}
	
}
