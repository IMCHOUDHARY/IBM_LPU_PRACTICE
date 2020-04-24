package com.example.demo.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.util.MultiValueMap;

import com.example.demo.data.Account;

//import org.springframework.http.ResponseEntity;

//import com.example.demo.data.Account;
import com.example.demo.dto.AccountDTO;

public interface AccountService {
	/*public ResponseEntity<Iterable<Account>> getAccounts();

	Optional<Account> findById(int id);*/
	
	 public AccountDTO getAccount(Integer id);

	 public List<AccountDTO> getAllAccounts();
	 
	 public AccountDTO saveAccount(AccountDTO dto);

	public Account updateAccount(Account account);

	public Iterable<Account> findByAccountType(String accountType);

	public void removeByAccountNumber(int id);

	public void updateByAccountNumber(Account account);
}
