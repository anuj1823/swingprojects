package com.swingprojects.databaseoperation;

import java.sql.*;

public class DatabaseConnection 
{
	private static final String url="jdbc:mysql://localhost:3306/demo";
	private static final String userid="root";
	private static final String password="123456";
	/*---- Method to establish connection ------*/
	public static Connection establishConnection()
	{
		try
		{
		return DriverManager.getConnection(url,userid,password);
		}
		catch(SQLException sqe)
		{
			System.out.println("Unable to establish Connection ");
			return null;
		}
	}
}
