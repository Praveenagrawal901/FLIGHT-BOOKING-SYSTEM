package com.flight.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flight.entity.Flight_details;
import com.flight.utility.DbConnection;

public class FlightDao {
	
	public static ResultSet getFlightDetails() throws ClassNotFoundException, SQLException {
	
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps= con.prepareStatement("select * from Flight_Details");
		
		ResultSet rs= ps.executeQuery();
		
		return rs; 
	
	}

	public static int insert(Flight_details f) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps= con.prepareStatement("insert into Flight_Details(flight_number, flight_name, from_city, to_city, fare, time) values (?,?,?,?,?,?)");
		
		ps.setString(1, f.getNumber());
		ps.setString(2, f.getName());
		ps.setString(3, f.getFrom());
		ps.setString(4, f.getTo());
		ps.setInt(5, f.getFare());
		ps.setString(6, f.getTime());
		
		int status = ps.executeUpdate();
		
		return status;
	}
	
	
	public static Flight_details getFlightById(int id) throws ClassNotFoundException, SQLException {
		
		Flight_details f= new Flight_details();
		
		Connection con = DbConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("select * from Flight_Details where flight_id=?");
		
		ps.setInt(1, id);
		
		ResultSet rs= ps.executeQuery();
		
		while(rs.next()) {
			f.setId(rs.getInt(1));
			f.setNumber(rs.getString(2));
			f.setName(rs.getString(3));
			f.setFrom(rs.getString(4));
			f.setTo(rs.getString(5));
			f.setFare(rs.getInt(6));
			f.setTime(rs.getString(7));
		}
		return f;
	}

	public static int updateFlightById(Flight_details fd) throws ClassNotFoundException, SQLException {
		
		Flight_details f= new Flight_details();
		
		Connection con = DbConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("update Flight_Details set flight_number='"+fd.getNumber()+"', flight_name='"+fd.getName()+"', from_city='"+fd.getFrom()+"', to_city='"+fd.getTo()+"', fare="+fd.getFare()+", time='"+fd.getTime()+"' where flight_id=?");
		
		ps.setInt(1, fd.getId());
		
		int status= ps.executeUpdate();
		return status;
	}

	public static int delete(int id) throws ClassNotFoundException, SQLException {
		
		Connection con= DbConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("delete from Flight_Details where Flight_Id=?");
		ps.setInt(1, id);
		int status= ps.executeUpdate();
		return status;
	}
	
	public static int total() throws ClassNotFoundException, SQLException {
		
		Connection con= DbConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("select count(Flight_id) from Flight_Details");
		ResultSet rs= ps.executeQuery();
		int count=0;
		while(rs.next()) {
			count= rs.getInt(1);
		}
		return count;
	}
	
	public static int insertDate(Flight_details f) throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps= con.prepareStatement("insert into Flight_Date(flight_id, date) values (?,?)");
		
		ps.setInt(1, f.getId());
		ps.setString(2, f.getDate());
		
		int status = ps.executeUpdate();
		
		return status;
	}
	
	public static ResultSet getFlightDateDetails() throws ClassNotFoundException, SQLException {
		
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps= con.prepareStatement("select f.flight_id, f.flight_number, f.flight_name , f1.date from flight_details f join flight_date f1 on f.flight_id=f1.flight_id order by f.flight_id;");
		
		ResultSet rs= ps.executeQuery();
		
		return rs; 
	
	}
	
	public static int deleteDate(int id, String date) throws ClassNotFoundException, SQLException {
		
		Connection con= DbConnection.getConnection();
		PreparedStatement ps= con.prepareStatement("delete from Flight_Date where Flight_Id=? and date=?");
		ps.setInt(1, id);
		ps.setString(2, date);
		int status= ps.executeUpdate();
		return status;
	}
	
	public static Flight_details flightSearch(Flight_details fd) throws SQLException, ClassNotFoundException {
		
		Connection con = DbConnection.getConnection();
		
		PreparedStatement ps= con.prepareStatement("select f.flight_id, f.flight_number, f.flight_name ,f.from_city, f.to_city, f.time, f1.date, f.fare from flight_details f join flight_date f1 on f.flight_id=f1.flight_id where f1.date=? and f.from_city=? and f.to_city=?");
		ps.setString(1, fd.getDate());
		ps.setString(2, fd.getFrom());
		ps.setString(3, fd.getTo());
		
		ResultSet rs= ps.executeQuery();
		
		// System.out.println(ps);
		while(rs.next()) {
			fd.setId(rs.getInt(1));
			fd.setNumber(rs.getString(2));
			fd.setName(rs.getString(3));
			fd.setFrom(rs.getString(4));
			fd.setTo(rs.getString(5));
			fd.setTime(rs.getString(6));
			fd.setDate(rs.getString(7));
			fd.setFare(rs.getInt(8));
		}
		
//		System.out.println(ps);
		
		return fd; 
		
	}
}
