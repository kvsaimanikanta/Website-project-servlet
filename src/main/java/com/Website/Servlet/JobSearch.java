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

import com.Website.Pojo.PostJobPojo;


/**
 * Servlet implementation class JobSearch
 */
@WebServlet("/JobSearch")
public class JobSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String title = req.getParameter("jobtitle");
		String type = req.getParameter("jobtype");
		int yop = Integer.parseInt(req.getParameter("yop"));
		String qualification = req.getParameter("qualification");
		String skills = req.getParameter("skills");
		int exp = Integer.parseInt(req.getParameter("exp"));
		
		Configuration cref = new Configuration();
		cref.configure("website.cfg.xml");
		
		SessionFactory sfref =cref.buildSessionFactory();
		
		Session sref = sfref.openSession();
		
		Query qref1 = sref.createQuery("from PostJobPojo where JobType=:jt and JodTitle=:jti and yop=:yop and Qualfication=:qual and skills=:sk and experience=:ex");
		qref1.setParameter("jt", type);
		qref1.setParameter("jti", title);
		qref1.setParameter("yop", yop);
		qref1.setParameter("qual", qualification);
		qref1.setParameter("sk", skills);
		qref1.setParameter("ex", exp);
		
		List lref1 = qref1.list();
		Iterator itr = lref1.iterator();
		
		String date =null;
		int jobid1 = 0,exp1=0,yop1=0;
		
		out.print("<table border='1' cellpadding='4' 	width='80%'>"); 
		out.print("<tr><th>JobType</th><th>JodTitle</th><th>Skills</th><th>Qualfication</th><th>Yop</th><th>Date</th><th>Description</th><th>Organization</th><tr>");
		while(itr.hasNext()) {
			
			PostJobPojo pj = (PostJobPojo)itr.next();
			//System.out.print(pj.getJobId());
			
			ServletContext jobid=getServletContext();
			jobid.setAttribute("jobid",pj.getJobId());
			
			date = pj.getDate();
			ServletContext sc = getServletContext(); 
			sc.setAttribute("date", date);
			
			//System.out.println("........"+date);
			      
	        out.print("<tr><td>"+pj.getJobType()+"</td><td>"+pj.getJodTitle()+"</td><td>"+pj.getSkills()+"</td><td>"+pj.getQualfication()+"</td><td>"+pj.getYop()+"</td><td>"+pj.getDate()+"</td><td>"+pj.getDescription()+"</td><td>"+pj.getOrganization()+"</td><td><a href='Apply'>Apply</td></tr>");   
	        out.print("</table>");
	        
	        ServletContext sc4 = getServletContext();
	        sc4.setAttribute("skills", pj.getSkills());
	        exp1 = pj.getExperience();
	        ServletContext sc1 = getServletContext();
	        sc1.setAttribute("exp1", exp1);
	        yop1 =  pj.getYop();
	        ServletContext sc2 = getServletContext();
	        sc2.setAttribute("yop1",yop1);
	        ServletContext sc3 = getServletContext();
	        sc3.setAttribute("qualification", pj.getQualfication());
	        ServletContext sc5 = getServletContext();
	        sc5.setAttribute("org", pj.getOrganization());
	        
	        jobid1 = pj.getJobId();
	        ServletContext sc6 = getServletContext();
	        sc6.setAttribute("jobid1", jobid1);
		}
		
        
        
		out.print("<a href='ShowApplications'>Show My Applications</a>");
		
//		ApplicationDao ad = new ApplicationDao();
//		ad.application(name,email,number,ctc,skills,yop,qualification,exp,notice,userId,date);

		
//		RequestDispatcher rd = req.getRequestDispatcher("GetUser");
//		rd.include(req, res);
		
	}

}
