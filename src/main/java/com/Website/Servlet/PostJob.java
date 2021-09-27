package com.Website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Website.Dao.PostJobDao;

/**
 * Servlet implementation class PostJob
 */
@WebServlet("/PostJob")
public class PostJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String title = req.getParameter("jobtitle");
		String type = req.getParameter("jobtype");
		Integer yop = Integer.parseInt(req.getParameter("yop"));
		String qualification = req.getParameter("qualification");
		String org = req.getParameter("org");
		String skills = req.getParameter("skills");
		int exp = Integer.parseInt(req.getParameter("exp"));
		String date = req.getParameter("date");
		String jobdesc = req.getParameter("jobdesc");
		
		ServletContext sc=getServletContext();
		String email=(String) sc.getAttribute("emEmail");
		
		PostJobDao pjd = new PostJobDao();
		pjd.postjob(title, type, yop, qualification, skills, exp, date, jobdesc, email, org);
		
		out.print("<html><body><body style =\"background-color:AliceBlue;\"/><center><br><br><br><br><h1>Job Posted Successfully</h1></center></body></html>");

		
	}

}
