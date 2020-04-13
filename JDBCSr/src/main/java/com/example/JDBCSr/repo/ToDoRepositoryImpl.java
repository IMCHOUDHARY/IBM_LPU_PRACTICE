package com.example.JDBCSr.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.example.JDBC.DbConnection;
//import com.example.JDBC.repo.ToDoRepository;
import com.example.JDBCSr.bean.ToDo;

@Repository
public class ToDoRepositoryImpl implements ToDoRepository {
	
	@Autowired
	private DataSource dataSource;

	public ToDo createToDo(ToDo todo) {
		//Connection connection=DbConnection.connect();
		Connection connection=null;
		Logger logger=Logger.getLogger("ToDoRepositoryImpl");

		try {
			logger.log(Level.INFO, "connecting to database");
			connection=dataSource.getConnection();
			logger.log(Level.INFO, "connected");
			PreparedStatement pStatement=connection.prepareStatement("insert into todo(todoId,todoName) values(?,?)");
			pStatement.setString(1, todo.getTodoID());
			pStatement.setString(2, todo.getTodoName());
			pStatement.execute();
			logger.log(Level.INFO, "todo creation completed");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "unable to connect db");
			e.printStackTrace();
			
		}
			return todo;
		}

	public void displayAll()
	{
		Connection connection=null;
		Logger logger=Logger.getLogger("ToDoRepositoryImpl");

		try {
			logger.log(Level.INFO, "connecting to database");
			connection=dataSource.getConnection();
			logger.log(Level.INFO, "connected");
			PreparedStatement pStatement=connection.prepareStatement("select * from todo");
			ResultSet rs = pStatement.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
			logger.log(Level.INFO, "todo creation completed");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "unable to connect db");
			e.printStackTrace();
			
		}
	}
	}
