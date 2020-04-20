package org.example.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection
{
	public static Connection connect()
	{
	  Connection con = null; 
	  try {
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
	    System.out.println("Connected!");
	  }
	  catch (Exception e )
	  {
	    System.out.println(e+"");
	  }
	  return con; 
	}
}
