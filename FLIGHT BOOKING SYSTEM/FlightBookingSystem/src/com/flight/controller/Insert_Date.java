package com.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight.entity.Flight_details;
import com.flight.repository.FlightDao;

/**
 * Servlet implementation class Insert_Date
 */
public class Insert_Date extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_Date() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out= response.getWriter();
		
		String fid= request.getParameter("did");
		int id=Integer.parseInt(fid);
		String date= request.getParameter("ddate");
		
		Flight_details f = new Flight_details();
		
		f.setId(id);
		f.setDate(date);
		
		int status=0;
		
		try {
			status = FlightDao.insertDate(f);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status!=0) {
			out.println("<script> alert('Insert Date Successfully') </script>");
			request.getRequestDispatcher("admin.jsp").include(request, response);
		}else {
			out.println("<script> alert('Sorry Flight Id Is Invalid') </script>");
			request.getRequestDispatcher("add_dates.jsp").include(request, response);

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
