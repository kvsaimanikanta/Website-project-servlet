package com.Website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Website.Dao.ApplicationDao;


/**
 * Servlet implementation class Apply
 */
@WebServlet("/Apply")
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		ServletContext sc=getServletContext();
		String email = (String) sc.getAttribute("userEmail");
		ServletContext sc1 = getServletContext(); 
		String date= (String) sc1.getAttribute("date");
		ServletContext sc2 = getServletContext();
		String org = (String) sc2.getAttribute("org");
		ServletContext sc4 = getServletContext();
        String skills = (String) sc4.getAttribute("skills");
        ServletContext sc3 = getServletContext();
        int exp = (int) sc3.getAttribute("exp1");
        ServletContext sc5 = getServletContext();
        int yop = (int) sc5.getAttribute("yop1");
        ServletContext sc6 = getServletContext();
        String quali = (String) sc3.getAttribute("qualification");
        ServletContext sc7 = getServletContext();
        int jobid = (int) sc7.getAttribute("jobid");
		
		System.out.println(date);
		
		ApplicationDao ad = new ApplicationDao();
    	if(ad.application(date,email,org,skills,exp,yop,quali,jobid)) {
			out.print("<html><body><body style =\"background-color:AliceBlue;\"/><center><br><br><br><br><h1> Applyed Successfully </h1></center></body></html>");
    	}else {
			out.print("<html><body><body style =\"background-color:AliceBlue;\"/><center><br><br><br><br><h1> You are Alredy Applyed </h1></center></body></html>");

    	}
	}

}
