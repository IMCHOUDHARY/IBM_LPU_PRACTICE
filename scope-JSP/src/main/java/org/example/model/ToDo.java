package org.example.model;

public class ToDo 
{
	private String todoName;
	private int todoId;
	private String completedBy;
	
	public ToDo() {
		// TODO Auto-generated constructor stub
	}
	
	public ToDo(String todoName, int todoId, String completedBy) {
		super();
		this.todoName = todoName;
		this.todoId = todoId;
		this.completedBy = completedBy;
	}
	public String getTodoName() {
		return todoName;
	}
	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}
	public int getTodoId() {
		return todoId;
	}
	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}
	public String getCompletedBy() {
		return completedBy;
	}
	public void setCompletedBy(String completedBy) {
		this.completedBy = completedBy;
	}
	
	
}
