package com.example.JDBC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JDBC.bean.ToDo;
import com.example.JDBC.repo.ToDoRepository;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoRepository objRepo;
	
	public ToDo createToDoService(ToDo todo) 
	{
		return objRepo.createToDo(todo);
	}

	public void displayAllService() {
		objRepo.displayAll();
	}

}
