package com.flight.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flight.entity.User_Details;
import com.flight.repository.User_DetailsDao;


/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		
		String first_name= request.getParameter("first_name");
		String last_name= request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = request.getParameter("signup_password");
	
		User_Details u = new User_Details();
		
		u.setFirst_name(first_name);
		u.setLast_name(last_name);
		u.setEmail(email);
		u.setPassword(password);
		
		int status=0;
		
		try {
			status = User_DetailsDao.insert(u);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status>0) {
			out.println("<script> alert('Record Save Successfully') </script>");
			request.getRequestDispatcher("login.html").include(request, response);
		}else {
			out.println("<script> alert('Sorry Unable to Save Record. Email Is Already Exist') </script>");
			request.getRequestDispatcher("signup.html").include(request, response);

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
