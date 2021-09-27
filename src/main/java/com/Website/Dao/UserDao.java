package com.Website.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Website.Pojo.UserPojo;



public class UserDao {

	public boolean userSignUp(String name, String email, String password, int number, String skills, int exp,
			String organization, int ctc, String jobrole, String location, String gender, int notice,int yop,String qualification) {
		
		Configuration cref = new Configuration();
		cref.configure("website.cfg.xml");
		
		SessionFactory sfref =cref.buildSessionFactory();
		
		Session sref = sfref.openSession();
		
		Transaction tref = sref.beginTransaction();
		
		Query<?> qref=sref.createQuery("from UserPojo where email=:em");
		qref.setParameter("em", email);
		
		List<?> lref = qref.list();
		Iterator<?> itr = lref.iterator();
		
		if(itr.hasNext() == false) {
		
		UserPojo up = new UserPojo();
		up.setName(name);
		up.setEmail(email);
		up.setPassword(password);
		up.setNumber(number);
		up.setSkills(skills);
		up.setExperience(exp);
		up.setYop(yop);
		up.setOrganization(organization);
		up.setCtc(ctc);
		up.setQualification(qualification);
		up.setJobrole(jobrole);
		up.setLocation(location);
		up.setGender(gender);
		up.setNotice(notice);
		sref.save(up);
		
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
