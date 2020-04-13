package com.example.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection
{
	public static Connection connect()
	{
	  Connection con = null; 
	  try {
	    Class.forName("org.sqlite.JDBC");
	    con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\hp\\Desktop\\DB\\abc.db");
	    System.out.println("Connected!");
	  }
	  catch (Exception e )
	  {
	    System.out.println(e+"");
	  }
	  return con; 
	}
}
