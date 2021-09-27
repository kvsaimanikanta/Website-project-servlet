package com.Website.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.Website.Pojo.ApplicationPojo;

/**
 * Servlet implementation class DashBord
 */
@WebServlet("/DashBord")
public class DashBord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
//		Configuration cref = new Configuration();
//		cref.configure("website.cfg.xml");
//		
//		SessionFactory sfref =cref.buildSessionFactory();
//		
//		Session sref = sfref.openSession();
//		
//		Query qref = sref.createQuery("select count(*) from ApplicationPojo");
//		List lref = qref.list();
//		Iterator itr = lref.iterator();
//		while (itr.hasNext()) {	
//			ApplicationPojo ap = (ApplicationPojo) itr.next();
//			ap.getIndex(0);
//		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/website","root","sai123");
			
			PreparedStatement pstmt = con.prepareStatement("select count(*) from application");
			ResultSet rs = pstmt.executeQuery();
			rs.getInt(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
