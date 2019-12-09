package com.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flight.entity.User_Details;
import com.flight.repository.User_DetailsDao;

/**
 * Servlet implementation class Forget_PasswordServlet
 */
public class Forget_PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forget_PasswordServlet() {
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
		
		String email = request.getParameter("forget_password_email");
		
		User_Details u = new User_Details();
		u.setEmail(email);
		
		
		try {
			User_DetailsDao.validateE(u);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int id = u.getId();
		
	   //System.out.println(id);
		
		HttpSession session=request.getSession();  
		
        session.setAttribute("uid",id);
        
        if(id != 0) {
        	
        request.getRequestDispatcher("setpassword.html").include(request, response);
        }
        
        else {
        	out.println("<script> alert('Please Enter valid Email') </script>");
        request.getRequestDispatcher("forget_password.html").include(request, response);	
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
