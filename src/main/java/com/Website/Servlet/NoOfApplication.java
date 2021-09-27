package com.Website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoOfApplication
 */
@WebServlet("/NoOfApplication")
public class NoOfApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
//		ServletContext sc= getServletContext();
//		String skills = (String) sc.getAttribute("skills");
//		ServletContext sc1 = getServletContext();
//		int exp = (int) sc1.getAttribute("exp1");
//		ServletContext sc2 = getServletContext();
//        int yop =(int) sc2.getAttribute("yop");
//        ServletContext sc3 = getServletContext();
//        String qua = (String) sc3.getAttribute("qualification");
        ServletContext sc4 = getServletContext();
        int jobid = (int)sc4.getAttribute("job1");
//        where JobId="+jobid+"
		
		//System.out.println(jobid);
		
		ServletContext emplo=getServletContext();
		String email = (String) emplo.getAttribute("emEmail");
        
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/website","root","sai123");
			
//			PreparedStatement pstmt1 = con.prepareStatement("select jobId from postjob where emplerEmail =?");
//			pstmt1.setString(1,email);
//			//pstmt1.setString(2, skills);
//			ResultSet rs1 = pstmt1.executeQuery();
//			while(rs1.next()) {
//				jobid = rs1.getInt(1);
//				System.out.println(jobid);
//			}
			
			PreparedStatement pstmt = con.prepareStatement("select ApliEmail,ApliName,ApliCtc,ApliExperience,ApliNotice,ApliNumber,ApliQualification,ApliSkills,ApliYop,InterviewDate from application where JobId=?");
			pstmt.setInt(1,jobid);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				out.print("<table border='1' cellpadding='4' 	width='100%'>");
				out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getInt(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getInt(9)+"</td><td>"+rs.getString(10)+"</td></tr>");   
		        out.print("</table>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
