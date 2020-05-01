package com.example.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;

@Service
public class RabbitMqService {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private String EXCHANGE="otp-exchange";

    private String ROUTING_KEY="items";

    public void sendMessage(Account account) {
        amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, account);
    }
}