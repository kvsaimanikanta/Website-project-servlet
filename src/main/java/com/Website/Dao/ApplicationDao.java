package com.Website.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Website.Pojo.ApplicationPojo;
import com.Website.Pojo.UserPojo;

public class ApplicationDao {

	public boolean application(String date,String email,String org,String skills,int exp,int yop,String quali,int jobid) {
		// TODO Auto-generated method stub
		
		Configuration cref = new Configuration();
		cref.configure("website.cfg.xml");
		
		SessionFactory sfref =cref.buildSessionFactory();
		
		Session sref = sfref.openSession();
		
		Transaction tref = sref.beginTransaction();
		
//		ServletContext sc = getServletContext();
//		String org = (String) sc.getAttribute("org");
		//String date = (String)sc.getAttribute("date");
		
		Query qref1 = sref.createQuery("from ApplicationPojo where ApliEmail=:em and JobId=:ji");
		qref1.setParameter("em", email);
		qref1.setParameter("ji", jobid);
		List lref1 = qref1.list();
		Iterator itr = lref1.iterator();
		if(itr.hasNext() == false) {
			
			Query qref = sref.createQuery("from UserPojo where email=:em");
			qref.setParameter("em",email);
			List lref = qref.list();
			Iterator itr1 = lref.iterator();
			String name = null;
			int ctc = 0,number = 0,notice = 0,userId=0;
			while(itr1.hasNext()) {
				UserPojo up = (UserPojo)itr1.next();
				 name = up.getName();
				 number = up.getNumber();
				 ctc = up.getCtc();
				 notice = up.getNotice();
				 userId = up.getUserId();
//				 yop = up.getYop();
//				 exp = up.getExperience();
//				 skills = up.getSkills();
//				 qualification = up.getQualification();
			}
			
			ApplicationPojo ap = new ApplicationPojo();
			ap.setApliName(name);
			ap.setApliEmail(email);
			ap.setApliNumber(number);
			ap.setApliCtc(ctc);
			ap.setApliSkills(skills);
			ap.setApliYop(yop);
			ap.setApliQualification(quali);
			ap.setApliExperience(exp);
			ap.setApliNotice(notice);
			ap.setApliUserId(userId);
			ap.setInterviewDate(date);
			ap.setOrgnization(org);
			ap.setJobId(jobid);
			sref.save(ap);
			
			tref.commit();
			sref.close();
			sfref.close();
			
			return true;
		}
		else {
			return false;
		}
		
	}

}
