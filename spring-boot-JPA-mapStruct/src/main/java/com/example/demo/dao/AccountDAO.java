package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.Account;

@Repository(value ="accountDAO")
public interface AccountDAO extends CrudRepository<Account, Integer>{

	@Query
	public Iterable<Account> findByAccountType(String accountType);
	//updateBy
	//removeBy
	public void removeByAccountNumber(int accountNumber);
	public void updateByAccountNumber(Account account);
}
