package com.flight.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.flight.utility.DbConnection;

public class Book_FlightDao {
	
	public static int insert(int id, String name, int fid, String date) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps= con.prepareStatement("insert into Book_Ticket(user_id, user_name, flight_id, date) values(?,?,?,?)");
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, fid);
		ps.setString(4, date);
		int status= ps.executeUpdate();
		
		return status;
		
	}

	public static ResultSet select(int id) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getConnection();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = new Date();  
	    SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
	    Date date1 = new Date(); 
	    // System.out.println(formatter.format(date));
		
		PreparedStatement ps= con.prepareStatement("select b.book_id, b.user_name, f.flight_number, f.flight_name, f.from_city, f.to_city, b.date, f.time, f.fare from book_ticket b join flight_details f on b.flight_id=f.flight_id where b.user_id=? and b.date>=?");
		
		ps.setInt(1, id);
		ps.setString(2, formatter.format(date));
		
		ResultSet rs= ps.executeQuery();
		
		return rs;
	}

	public static int cancel(int book_id, String uname, String number, String fname, String from, String to,String time, String date, String fare, int id) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps= con.prepareStatement("insert into cancel_ticket values(?,?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, book_id);
		ps.setString(2, uname);
		ps.setString(3, number);
		ps.setString(4, fname);
		ps.setString(5, from);
		ps.setString(6, to);
		ps.setString(7, time);
		ps.setString(8, date);
		ps.setString(9, fare);
		ps.setInt(10, id);
		
		int status= ps.executeUpdate();
		
		return status;
	}

	public static int delete(int book_id) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps= con.prepareStatement("delete from book_ticket where book_id=?");
		
		ps.setInt(1, book_id);
		
		int status= ps.executeUpdate();
		
		return status;
	}
	
	public static ResultSet selectCancel(int id) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps= con.prepareStatement("select book_id, user_name, flight_number, flight_name, from_city, to_city, date, time, fare from cancel_ticket where user_id=? ");
		
		ps.setInt(1, id);
		
		ResultSet rs= ps.executeQuery();
		
		return rs;
	
	
	}
	
/*public static ResultSet pastJourey(int id) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getConnection();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = new Date();  
	    SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
	    Date date1 = new Date();
	    // System.out.println(formatter.format(date));
		
		PreparedStatement ps= con.prepareStatement("select b.book_id, b.user_name, f.flight_number, f.flight_name, f.from_city, f.to_city, b.date, f.time, f.fare from book_ticket b join flight_details f on b.flight_id=f.flight_id where b.user_id=? and b.date<=? and f.time<=?");
		
		ps.setInt(1, id);
		ps.setString(2, formatter.format(date));
		ps.setString(3, formatter1.format(date1));
		ResultSet rs= ps.executeQuery();
		
		return rs;
	}*/
}
