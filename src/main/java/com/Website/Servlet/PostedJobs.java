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

import com.Website.Pojo.EmployerPojo;
import com.Website.Pojo.PostJobPojo;

/**
 * Servlet implementation class PostedJobs
 */
@WebServlet("/PostedJobs")
public class PostedJobs extends HttpServlet {
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
		
		ServletContext emplo=getServletContext();
		String emEmail = (String) emplo.getAttribute("emEmail");
		//System.out.println(emEmail);
		
		Query qref = sref.createQuery("from PostJobPojo where emplerEmail=:ei");
		qref.setParameter("ei", emEmail);
		List lref = qref.list();
		Iterator itr= lref.iterator();
		
		out.print("<table border='1' cellpadding='4' 	width='100%'>");
		out.print("<tr><td>JobType</td><td>JodTitle</td><td>Qualfication</td><td>Date</td><td>Description</td><td>Experience</td><td>Organization</td><td>Skills</td><td>Yop</td></tr>");   
        out.print("</table>");

        int jobid = 0;
		while(itr.hasNext()) {
			
			PostJobPojo ep = (PostJobPojo)itr.next();
			
			ServletContext sc = getServletContext();
			jobid = ep.getJobId();
			sc.setAttribute("job1", jobid);
			
			System.out.println(jobid);
			
			out.print("<table border='1' cellpadding='4' 	width='100%'>");
			out.print("<tr><td>"+ep.getJobType()+"</td><td>"+ep.getJodTitle()+"</td><td>"+ep.getQualfication()+"</td><td>"+ep.getDate()+"</td><td>"+ep.getDescription()+"</td><td>"+ep.getExperience()+"</td><td>"+ep.getOrganization()+"</td><td>"+ep.getSkills()+"</td><td>"+ep.getYop()+"</td><td><a href = 'NoOfApplication'>Applications</a></td></tr>");   
	        out.print("</table>");
	     
		}
		
		
	}

}
