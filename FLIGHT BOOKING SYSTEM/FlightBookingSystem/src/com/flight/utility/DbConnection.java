package com.flight.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Connection con;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flight","root","password@123");
		
		return con;
		
	}

}
