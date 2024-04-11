package com.swingprojects.servicesImpl;

import com.swingprojects.databaseoperation.DatabaseConnection;
import com.swingprojects.services.DatabaseService;
import java.sql.*;
public class DatabaseServiceImpl implements DatabaseService {

	@Override
	public String loginCheck(String userid, String password)
	{
		try
		{
			Connection con=DatabaseConnection.establishConnection();
			if(con == null)
			{
				return null;
			}
			else
			{
				PreparedStatement stmt=con.prepareStatement("Select userid from Userdetails where userid=? and password =?");
				stmt.setString(1, userid);
				stmt.setString(2, password);
				ResultSet rs=stmt.executeQuery();
				String str="";
				while(rs.next())
				{
					str=rs.getString(1);
				}
				if(str.equals(""))
				{
					return "Userid or password incorrect";
				}
				else
				{
					return "Login Successfull";
				}
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Unable to establish connection"+e);
			return null;
		}
		
	}

}
