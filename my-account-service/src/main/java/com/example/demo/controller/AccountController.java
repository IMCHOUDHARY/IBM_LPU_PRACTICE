package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@RequestMapping("/test")
	public String test()
	{
		return "test!!!!";
	}
	
	@GetMapping("/accounts")
	public List<Account> findAll()
	{
		return accountService.findAll();
	}
	
	@GetMapping("/accounts/{id}")
	public Account findById(@PathVariable Integer id)
	{
		return accountService.findById(id);
	}
}
