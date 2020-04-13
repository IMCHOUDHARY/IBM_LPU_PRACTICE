package com.example.JDBCTemplate.service;

import java.util.List;

import com.example.JDBCTemplate.bean.Account;

public interface AccountService {
	public Account createAccount(Account account);
	public List<Account> getAllAccountDetails();
	public Account findByAccountNumber(String accountNumber);
}
