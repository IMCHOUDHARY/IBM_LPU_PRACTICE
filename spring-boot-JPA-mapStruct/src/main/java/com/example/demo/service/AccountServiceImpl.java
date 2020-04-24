/**
 * 
 */
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AccountDAO;
import com.example.demo.data.Account;
import com.example.demo.dto.AccountDTO;

/**
 * @author hp
 *
 */

@Service(value = "accountService")
@EnableTransactionManagement
public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;
	
	public AccountServiceImpl(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}


	/*@Override
	@Transactional
	public ResponseEntity<Iterable<Account>> getAccounts() {
		Iterable<Account> accounts=accountDAO.findAll();
		return ResponseEntity.ok().body(accounts);
	}
	
	@Override
	public Optional<Account> findById(int id)
	{
		return accountDAO.findById(id);
	}*/


	@Override
	public AccountDTO getAccount(Integer id) {
		// TODO Auto-generated method stub
		if(accountDAO.findById(id).isPresent())
		{
			Account fetchAccount = accountDAO.findById(id).get();
			AccountDTO dto = new AccountDTO(fetchAccount.getAccountID(), fetchAccount.getAccountType(), fetchAccount.getBalance());
			return dto;
		}
		else
		{
			return null;
		}
	}


	@Override
	public List<AccountDTO> getAllAccounts() {
		List<AccountDTO> accountList = new ArrayList<>();
		accountDAO.findAll().forEach(account -> {
			accountList.add(new AccountDTO(account.getAccountID(), account.getAccountType(), account.getBalance()));
		});
		
		return accountList;
	}


	@Override
	@Transactional
	public AccountDTO saveAccount(AccountDTO dto) {
		Account acc = new Account(dto.getAccountID(), dto.getAccountType(), dto.getBalance());
		accountDAO.save(acc);
		return dto;
	}


	@Override
	@Transactional
	public Account updateAccount(Account account) 
	{
		if (accountDAO.findById(account.getAccountNumber()).isPresent()) {
			accountDAO.save(account);
			return account;
		} else
		{
			System.out.println("NOT FOUND!!!!!");
			return null;
		}
	}


	@Override
	public Iterable<Account> findByAccountType(String accountType) {
		return accountDAO.findByAccountType(accountType);
	}


	@Override
	@Transactional
	public void removeByAccountNumber(int id) {
		accountDAO.removeByAccountNumber(id);
	}


	@Override
	@Transactional
	public void updateByAccountNumber(Account account) {
		// TODO Auto-generated method stub
		accountDAO.updateByAccountNumber(account);
	}
	

}
