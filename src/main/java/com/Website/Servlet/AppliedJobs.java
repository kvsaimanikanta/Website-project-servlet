package com.Website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Website.Pojo.ApplicationPojo;

/**
 * Servlet implementation class AppliedJobs
 */
@WebServlet("/AppliedJobs")
public class AppliedJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		ServletContext userEmail=getServletContext();
		String email=(String) userEmail.getAttribute("userEmail");
		
		Configuration cref = new Configuration();
		cref.configure("website.cfg.xml");
		
		SessionFactory sfref =cref.buildSessionFactory();
		
		Session sref = sfref.openSession();
		
		Query qref = sref.createQuery("from ApplicationPojo where ApliEmail=:em");
		qref.setParameter("em", email);
		List lref = qref.list();
		Iterator itr = lref.iterator();
		
		out.print("<table border='1' cellpadding='4' 	width='100%'>");
		out.print("<tr><td>ApliEmail</td><td>ApliName</td><td>ApliCtc</td><td>ApliExperience</td><td>ApliNotice</td><td>ApliNumber</td><td>ApliQualification</td><td>ApliSkills</td><td>ApliYop</td><td>InterviewDate</td></tr>");   
        out.print("</table>");
		
		while(itr.hasNext()) {
			ApplicationPojo ep = (ApplicationPojo)itr.next();
			out.print("<table border='1' cellpadding='4' 	width='100%'>");
			out.print("<tr><td>"+ep.getApliEmail()+"</td><td>"+ep.getApliName()+"</td><td>"+ep.getApliCtc()+"</td><td>"+ep.getApliExperience()+"</td><td>"+ep.getApliNotice()+"</td><td>"+ep.getApliNumber()+"</td><td>"+ep.getApliQualification()+"</td><td>"+ep.getApliSkills()+"</td><td>"+ep.getApliYop()+"</td><td>"+ep.getInterviewDate()+"</td></tr>");   
	        out.print("</table>");
		}
		
	}

}
