package com.example.JDBC.repo;

import java.util.List;

import com.example.JDBC.bean.ToDo;

public interface ToDoRepository {
	public ToDo createToDo(ToDo todo);
	public void displayAll();
}
