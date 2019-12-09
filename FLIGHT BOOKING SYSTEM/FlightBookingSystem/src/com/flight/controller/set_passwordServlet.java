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
 * Servlet implementation class set_passwordServlet
 */
public class set_passwordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public set_passwordServlet() {
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
		
		String password = request.getParameter("setpassword");
		//System.out.println(password);
		
		User_Details u = new User_Details();
		u.setPassword(password);
		
		//System.out.println(u.getPassword());
		
		HttpSession session=request.getSession(false);  
		
        int id= (int)session.getAttribute("uid");
        
       
		
       int status=0;
		try {
			status = User_DetailsDao.updatePass(id , u);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status !=0) {
			out.println("<script> alert('Password Save Successfully') </script>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		session.invalidate();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
