package com.flight.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flight.entity.User_Details;
import com.flight.utility.DbConnection;

public class User_DetailsDao {
	
	public static int insert(User_Details u) throws ClassNotFoundException, SQLException {
		
		Connection con= DbConnection.getConnection();
		
		PreparedStatement stmt= con.prepareStatement(" insert into user_details(first_name, last_name, email, password) values(?,?,?,?)");
		
		stmt.setString(1, u.getFirst_name());
		stmt.setString(2, u.getLast_name());
		stmt.setString(3, u.getEmail());
		stmt.setString(4, u.getPassword());
		
		int status = stmt.executeUpdate();
		return status;
	} 
	
	public static ResultSet validate(User_Details u) throws ClassNotFoundException, SQLException{
		
		Connection con= DbConnection.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select * from user_details where email=? and password=?");  
				ps.setString(1,u.getEmail());  
				ps.setString(2,u.getPassword());  
				      
				ResultSet rs=ps.executeQuery();  
				while(rs.next()){
					u.setId(rs.getInt(1));
					u.setFirst_name(rs.getString(2));
					u.setLast_name(rs.getString(3));
					u.setEmail(rs.getString(4));
					u.setPassword(rs.getString(5));
				}
				 
		
		return rs;
		
	}
		
	public static void validateE(User_Details u) throws ClassNotFoundException, SQLException{
		
		Connection con= DbConnection.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select id from user_details where email=?");  
				ps.setString(1,u.getEmail());    
				      
				ResultSet rs=ps.executeQuery();  
				
				while(rs.next()) {
	
					u.setId(rs.getInt(1));
				}
	}	
	
		public static int updatePass(int id, User_Details u) throws ClassNotFoundException, SQLException{
		
		Connection con= DbConnection.getConnection();
		
		PreparedStatement ps=con.prepareStatement("update user_details set password=? where id=?");  
		
			ps.setString(1, u.getPassword());	
			ps.setInt(2,id);
			
			int status = ps.executeUpdate();

			return status;
				
		}
		
		public static ResultSet getUserDetails() throws ClassNotFoundException, SQLException {
			
			Connection con= DbConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user_details");
			ResultSet rs= ps.executeQuery();
			return rs;
		}
		
		public static int user() throws ClassNotFoundException, SQLException {
			
			Connection con= DbConnection.getConnection();
			PreparedStatement ps= con.prepareStatement("select count(*) from user_details");
			ResultSet rs= ps.executeQuery();
			int count=0;
			while(rs.next()) {
				count= rs.getInt(1);
			}
			return count;
		}
}
	
	


