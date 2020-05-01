package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Account;
import com.example.demo.service.RabbitMqService;

@RestController
public class RabbitMqController {
    @Autowired
    RabbitMqService rabbitMqService;
    
    @GetMapping("/test")
    public String test()
    {
    	return "test";
    }

    @PostMapping("/accounts")
    public ResponseEntity<String> postMessage(@RequestBody Account account){
        rabbitMqService.sendMessage(account);
        return new ResponseEntity<String>("Item pushed to RabbitMQ",HttpStatus.CREATED);
    }
}
