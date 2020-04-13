package com.example.JDBCTemplate.Repo;

import java.util.List;

import com.example.JDBCTemplate.bean.Account;

public interface AccountDAO {
	public Account createAccount(Account account);
	public List<Account> getAllAccountDetails();
	public Account findByAccountNumber(String accountNumber);
	public void deleteById(String accountNumber);
	public void updateById(String accountNumber);
	public void deleteAll();
}
