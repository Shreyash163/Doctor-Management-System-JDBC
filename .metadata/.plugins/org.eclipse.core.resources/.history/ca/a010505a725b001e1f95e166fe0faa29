package com.amdocs.DBConnection;

import java.sql.*;

public class DbConnection 
{
	private static  Connection con;
	
	public DbConnection()
	{		try {
			System.out.println("Inside Make Connection2");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger");
			System.out.println(con);
			
			System.out.println("connection estanblished");
			
			
	}
	catch(Exception e)
	{
		System.out.println(e);
	}	
	}
	 public Connection getConnection() {
	        return con;
	    }

}
