package com.Website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Website.Pojo.EmployerPojo;

/**
 * Servlet implementation class EmployersList
 */
@WebServlet("/EmployersList")
public class EmployersList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		Configuration cref = new Configuration();
		cref.configure("website.cfg.xml");
		
		SessionFactory sfref =cref.buildSessionFactory();
		
		Session sref = sfref.openSession();
		
		Query qref = sref.createQuery("from EmployerPojo");
		List lref = qref.list();
		Iterator itr = lref.iterator();
		
		while(itr.hasNext()) {
			EmployerPojo ep = (EmployerPojo)itr.next();
			out.print("<table border='1' cellpadding='4' 	width='80%'>");
			out.print("<tr><td>"+ep.getName()+"</td><td>"+ep.getEmail()+"</td><td>"+ep.getPassword()+"</td><td>"+ep.getLocation()+"</td><td>"+ep.getOrgName()+"</td><td>"+ep.getWebsite()+"</td></tr>");   
	        out.print("</table>");
		}
		
	}

}
