package com.Website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Website.Dao.UserLogInDao;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		ServletContext userEmail=getServletContext();
		userEmail.setAttribute("userEmail", email);
		
		UserLogInDao uld= new UserLogInDao();
		
		if(uld.login(email,password)) {
			out.print("<html><body><body style =\"background-color:AliceBlue;\"/><center><br><br><br><br><h1>Welcome "+email+" </h1></center></body></html>");
			
			RequestDispatcher rd = req.getRequestDispatcher("jobSearch.html");
			rd.include(req, res);
			
		}else {
			out.print("<html><body><body style =\"background-color:AliceBlue;\"/><center><br><br><br><br><h1>LogIn Failed</h1><h2>Check With The Email And Password<h2><h3>Or Create an Account By Clicking Below Link<h3><a href='userSignUp.html'/>SignUp<br><br><a href='userLogin.html'/>LogIn</center></body></html>");
		}
		
	}

}
