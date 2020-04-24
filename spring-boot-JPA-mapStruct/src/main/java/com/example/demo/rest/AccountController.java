package com.example.demo.rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Account;
import com.example.demo.dto.AccountDTO;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {

	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}



	/*@GetMapping("/accounts")
	public ResponseEntity<Iterable<Account>> getAllAccounts()
	{
		return accountService.getAccounts();
	}
	
	@GetMapping("/accounts/{id}")
	public Optional<Account> findById(@PathVariable int id)
	{
		return accountService.findById(id);
	}*/
	
	@GetMapping("/accounts")
	 public ResponseEntity<Object> getAllAccounts() {
	  return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
	 }

	 @GetMapping("/accounts/{id}")
	 public ResponseEntity<AccountDTO> getProjectById(@PathVariable("id") Integer id){
	  return new ResponseEntity(accountService.getAccount(id),HttpStatus.OK);
	 }
	 
	 @PostMapping("/accounts/add")
	 public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO dto){
		  return new ResponseEntity(accountService.saveAccount(dto),HttpStatus.OK);
	 }
	 
	 @PutMapping("/accounts/update")
	 public ResponseEntity<Account> updateAccount(@RequestBody Account account)
	 {
		 return new ResponseEntity(accountService.updateAccount(account),HttpStatus.OK);
	 }
	 
	 @GetMapping("/accounts_get/{accountType}")
	 public ResponseEntity<Iterable<Account>> findByAccountType(@PathVariable String accountType)
	 {
		 return ResponseEntity.ok().body(accountService.findByAccountType(accountType));
	 }
	 
	 @DeleteMapping("/accounts/delete/{id}")
	 public void removeByAccountNumber(@PathVariable int id)
	 {
		 accountService.removeByAccountNumber(id);
	 }
	 
}
