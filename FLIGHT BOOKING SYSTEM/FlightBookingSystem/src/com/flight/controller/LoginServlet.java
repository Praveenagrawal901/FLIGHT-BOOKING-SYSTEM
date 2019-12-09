package com.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flight.entity.User_Details;
import com.flight.repository.User_DetailsDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String email = request.getParameter("login_email");
		String password = request.getParameter("login_password");
		
		User_Details u = new User_Details();
		
		u.setEmail(email);
		u.setPassword(password);
		
		ResultSet rs=null;
		try {
			rs = User_DetailsDao.validate(u);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			int id = u.getId();
			
			HttpSession session=request.getSession();  
			
	        session.setAttribute("id",id);
	        
	        String name= u.getFirst_name();
	        
	        session.setAttribute("name", name);
		
		if(rs != null) {
			out.println("<script> alert('welcome') </script>");
			response.sendRedirect("customer.jsp");
		}else {
			out.println("<script> alert('Sorry! Email and Password is Invalid') </script>");
			request.getRequestDispatcher("login.html").include(request, response);

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
