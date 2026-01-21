package com.hospital.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBConnection
{
public static Connection getDBConnection()
{
	Connection con=null;
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS_zensar","root","Password");
	} 
	catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	} catch (SQLException e) 
	{
		e.printStackTrace();
	}
	return con;
}
}
