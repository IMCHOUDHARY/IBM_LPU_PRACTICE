package com.example.demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemDAO;
import com.example.demo.model.Item;

@Service
public class RabbitMQConsumerService {
	
	public ItemDAO itemDAO;
	
	@Autowired
	public RabbitMQConsumerService(ItemDAO itemDAO) {
		super();
		this.itemDAO = itemDAO;
	}

	private static final String QUEUE = "items-queue";

	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Item item) {

		System.out.println("Received Message from Items Queue >>" + item);
		itemDAO.save(item);
	}
}
