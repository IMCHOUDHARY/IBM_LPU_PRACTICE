package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountDAO;
import com.example.demo.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;
	
	@Autowired
	public AccountServiceImpl(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return (List<Account>) accountDAO.findAll();
	}

	@Override
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return accountDAO.findById(id).get();
	}

}
