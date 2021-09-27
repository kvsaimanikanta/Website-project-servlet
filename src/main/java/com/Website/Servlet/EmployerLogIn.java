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

import com.Website.Dao.EmployerLogInDao;

/**
 * Servlet implementation class EmployerLogIn
 */
@WebServlet("/EmployerLogIn")
public class EmployerLogIn extends HttpServlet {
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
		
		ServletContext emplo=getServletContext();
		emplo.setAttribute("emEmail", email);
		
		EmployerLogInDao eld= new EmployerLogInDao();
		
		if(eld.login(email,password)) {
			out.print("<html><body><body style =\"background-color:AliceBlue;\"/><center><br><br><br><br><h1>Welcome "+email+" </h1></center></body></html>");
			
			RequestDispatcher rd = req.getRequestDispatcher("postjob.html");
			rd.include(req, res);
			
		}else {
			out.print("<html><body><body style =\"background-color:AliceBlue;\"/><center><br><br><br><br><h1>LogIn Failed</h1><h2>Check With The Email And Password<h2><h3>Or Create an Account By Clicking Below Link<h3><a href='employerSignUp.html'/>SignUp</center></body></html>");
		}
		
	}

	

}
