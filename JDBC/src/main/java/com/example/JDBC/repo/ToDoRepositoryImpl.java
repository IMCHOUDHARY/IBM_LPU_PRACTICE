package com.example.JDBC.repo;

import com.example.JDBC.bean.ToDo;
import com.example.JDBC.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.sql.DataSource;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ToDoRepositoryImpl implements ToDoRepository {
	//property level injection
	
//	private DataSource dataSource;
//	@Autowired
//	public ToDoRepositoryImpl(DataSource dataSource) {
//		super();
//		this.dataSource = dataSource;
//	}

	//private Connection connection=null;
	
	//private static Logger logger=Logger.getLogger("ToDoRepositoryImpl");

	public ToDo createToDo(ToDo todo) {
		Connection connection=DbConnection.connect();
		
		Logger logger=Logger.getLogger("ToDoRepositoryImpl");

		try {
			logger.log(Level.INFO, "connecting to database");
			//connection=dataSource.getConnection();
			//connection=DbConnection.connect();
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
		Connection connection=DbConnection.connect();
		Logger logger=Logger.getLogger("ToDoRepositoryImpl");

		try {
			logger.log(Level.INFO, "connecting to database");
			//connection=dataSource.getConnection();
			//connection=DbConnection.connect();
			logger.log(Level.INFO, "connected");
			PreparedStatement pStatement=connection.prepareStatement("select * from todo");
			//pStatement.setString(1, todo.getTodoID());
			//pStatement.setString(2, todo.getTodoName());
			ResultSet rs = pStatement.executeQuery();
			//pStatement.execute();
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
