package com.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight.entity.Flight_details;
import com.flight.repository.FlightDao;

/**
 * Servlet implementation class Edit_flight
 */
public class Edit_flight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_flight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        response.setContentType("text/html");  
		        PrintWriter out=response.getWriter();  
		          
		        String fid=request.getParameter("id");  
		        int id=Integer.parseInt(fid); 
		        String fnumber=request.getParameter("number");
		        String fname=request.getParameter("name");
		        String ffrom=request.getParameter("from");
		        String fto=request.getParameter("to");
		        String fare=request.getParameter("fare");
		        int ffare= Integer.parseInt(fare);
		        String ftime=request.getParameter("time");
		        
		        Flight_details fd= new Flight_details();
		        fd.setId(id);
		        fd.setNumber(fnumber);
		        fd.setName(fname);
		        fd.setFrom(ffrom);
		        fd.setTo(fto);
		        fd.setFare(ffare);
		        fd.setTime(ftime);
		        
		        int status=0;
		        try {
					 status= FlightDao.updateFlightById(fd);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        if(status!=0) {
					out.println("<script> alert('Record Edit Successfully') </script>");
					request.getRequestDispatcher("admin.jsp").include(request, response);
				}else {
					out.println("<script> alert('Sorry Unable to Edit Record') </script>");
					request.getRequestDispatcher("edit_flight.jsp").include(request, response);

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
