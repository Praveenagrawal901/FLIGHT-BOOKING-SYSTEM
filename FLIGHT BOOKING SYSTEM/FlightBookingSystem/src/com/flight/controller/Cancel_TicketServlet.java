package com.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flight.entity.Flight_details;
import com.flight.repository.Book_FlightDao;

/**
 * Servlet implementation class Cancel_TicketServlet
 */
public class Cancel_TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cancel_TicketServlet() {
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
		
		String b= request.getParameter("book_id");
		int book_id=Integer.parseInt(b);
		String uname= request.getParameter("user_name");
		String number= request.getParameter("flight_number");
		String fname= request.getParameter("flight_name");
		String from=  request.getParameter("from");
		String to=  request.getParameter("to");
		String date=  request.getParameter("date");
		String time=  request.getParameter("time");
		String fare=  request.getParameter("fare");
		
//		out.println(time);
		
		HttpSession session1=request.getSession(false);

		
		int id=(int)session1.getAttribute("id");
		
		Flight_details fd= new Flight_details();
		int status=0;
		try {
			status = Book_FlightDao.cancel(book_id,uname,number,fname,from,to,date,time,fare,id );
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status!=0) {
			out.println("delete");
			request.getRequestDispatcher("Delete_TicketServlet").forward(request, response);
		}else {
			out.println("not delete");
			response.sendRedirect("upcoming.jsp");
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
