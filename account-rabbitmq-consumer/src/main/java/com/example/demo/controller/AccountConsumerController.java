package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecwid.consul.v1.Response;
import com.example.demo.model.Account;
import com.example.demo.service.RabbitMQConsumerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value="Account Management System", description="Operations pertaining to customer in Account Management System")
public class AccountConsumerController {

	private RabbitMQConsumerService rabbitMQConsumerService;

	@Autowired
	public AccountConsumerController(RabbitMQConsumerService rabbitMQConsumerService) {
		super();
		this.rabbitMQConsumerService = rabbitMQConsumerService;
	}
	
	@ApiOperation(value = "Get an customer by Id")
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccountById(
			@ApiParam(value = "Account id from which account object will retrieve", required = true)
			@PathVariable int id)
	{
		return new ResponseEntity<Account>(rabbitMQConsumerService.getAccountById(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all customer")
	@GetMapping("/account/all")
	public ResponseEntity<List<Account>> getAllAccount( )
	{
		//return rabbitMQConsumerService.getAccountById(id);
		return new ResponseEntity<List<Account>>(rabbitMQConsumerService.getAllAccount(), HttpStatus.OK);
	}
}
