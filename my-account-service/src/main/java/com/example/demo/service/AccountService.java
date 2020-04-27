package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Account;

public interface AccountService {
	public List<Account> findAll();

	public Account findById(Integer id);
}
