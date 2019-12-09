package com.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight.entity.Flight_details;
import com.flight.entity.User_Details;
import com.flight.repository.FlightDao;
import com.flight.repository.User_DetailsDao;

/**
 * Servlet implementation class Insert_Flight
 */
public class Insert_Flight extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Insert_Flight() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out= response.getWriter();
		String number=request.getParameter("number");
		String name=request.getParameter("name");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String f1=request.getParameter("fare");
		int fare= Integer.parseInt(f1);
		String time=request.getParameter("time");
		
		Flight_details f = new Flight_details();
		
		f.setNumber(number);
		f.setName(name);
		f.setFrom(from);
		f.setTo(to);
		f.setFare(fare);
		f.setTime(time);
		
		int status=0;
		
		try {
			status = FlightDao.insert(f);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status!=0) {
			out.println("<script> alert('Record Save Successfully') </script>");
			request.getRequestDispatcher("admin.jsp").include(request, response);
		}else {
			out.println("<script> alert('Sorry Unable to Save Record') </script>");
			request.getRequestDispatcher("add_flight.jsp").include(request, response);

		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
