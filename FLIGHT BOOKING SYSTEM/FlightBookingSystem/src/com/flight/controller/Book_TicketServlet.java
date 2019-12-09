package com.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flight.repository.Book_FlightDao;

/**
 * Servlet implementation class Book_TicketServlet
 */
public class Book_TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book_TicketServlet() {
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
//		String number= request.getParameter("flight_number");
//		String fname= request.getParameter("flight_name");
//		String from=  request.getParameter("from");
//		String to=  request.getParameter("to");
//		String time=  request.getParameter("time");
		String date=  request.getParameter("date");
		String fare=  request.getParameter("fare");
		String fid=  request.getParameter("fid");
		int f= Integer.parseInt(fid);
		
//		out.println(date);
		
		HttpSession session1=request.getSession(false);

		String name=(String)session1.getAttribute("name");
		int id=(int)session1.getAttribute("id");
//		out.println(name);
		
		int status=0;
		try {
			status= Book_FlightDao.insert(id, name, f, date);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status!=0) {
			
			out.println("<script> alert('Ticket Booked Successully') </script>");
			response.sendRedirect("https://p-y.tm/G-NIKwa");
			
		}else {
			out.println("<script> alert('Ticket is not Book') </script>");
			request.getRequestDispatcher("show_ticket.jsp").include(request, response);
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
