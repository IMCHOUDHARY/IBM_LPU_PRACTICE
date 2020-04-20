package org.example.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.factory.DbConnection;
import org.example.model.ToDo;

public class MyController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> errors;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException 
	{
		errors = new ArrayList<String>();
		
		String name = request.getParameter("name");
		int id=0;
		if(name.length()<8)
		{
			errors.add("The name have less than 8 characters!!!!!");
		}
		
		
		try
		{
			id = Integer.parseInt(request.getParameter("id"));
		}
		catch(Exception e)
		{
			errors.add("Invalid number entered!!!!!");
		}
		
		String c_by = request.getParameter("c_by");
		if(c_by.length()<=0)
		{
			errors.add("Entered some name in the field!!!!");
		}
		
		if(errors.size()==0)
		{
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/SuccessServlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
			ToDo todo = new ToDo(name,id,c_by);
			
			Connection connection = DbConnection.connect();
			PreparedStatement pStatement=connection.prepareStatement("insert into todo(todoId,todoName,completedBy) values(?,?,?)");
			pStatement.setInt(1, todo.getTodoId());
			pStatement.setString(2, todo.getTodoName());
			pStatement.setString(3, todo.getCompletedBy());
			pStatement.execute();
			
			request.setAttribute("todo", todo);
			dispatcher.forward(request, response);
		}
		else
		{
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/Errors");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/errors.jsp");
			request.setAttribute("Errors", errors);
			dispatcher.forward(request, response);
		}
	}
}
