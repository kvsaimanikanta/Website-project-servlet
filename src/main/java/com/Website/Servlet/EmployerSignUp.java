package com.Website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Website.Dao.EmployerDao;

/**
 * Servlet implementation class EmployerLogin
 */
@WebServlet("/EmployerSignUp")
public class EmployerSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String orgName = req.getParameter("orgName");
		String location = req.getParameter("location");
		String website = req.getParameter("website");
		
		EmployerDao ed = new EmployerDao();
		if(ed.signUp(name, email, password, orgName, location, website)) {
			out.print("<html><body><body style =\"background-color:AliceBlue;\"/><center><br><br><br><br><h1>Account Created Successfully </h1></center></body></html>");
			
			RequestDispatcher rd = req.getRequestDispatcher("employerLogin.html");
			rd.include(req, res);
		
		}else {
			out.print("<html><body><body style =\"background-color:AliceBlue;\"/><center><br><br><br><br><h1>You have Alredy Account With this Email "+email+"</h1></center></body></html>");
		}
		
	}

}
