package com.example.JDBCSr.repo;

import com.example.JDBCSr.bean.ToDo;

public interface ToDoRepository {
	public ToDo createToDo(ToDo todo);
	public void displayAll();
}
