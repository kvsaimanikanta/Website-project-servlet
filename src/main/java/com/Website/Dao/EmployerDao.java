package com.Website.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Website.Pojo.EmployerPojo;

public class EmployerDao {

	public boolean signUp(String name,String email,String password,String orgName,String location,String website)
	{
		
		Configuration cref = new Configuration();
		cref.configure("website.cfg.xml");
		
		SessionFactory sfref =cref.buildSessionFactory();
		
		Session sref = sfref.openSession();
		
		Transaction tref = sref.beginTransaction();
		
		Query<?> qref=sref.createQuery("from EmployerPojo where email=:em");
		qref.setParameter("em", email);
		
		List<?> lref = qref.list();
		Iterator<?> itr = lref.iterator();
		
		if(itr.hasNext() == false) {
		
		EmployerPojo ep = new EmployerPojo();
		ep.setName(name);
		ep.setEmail(email);
		ep.setPassword(password);
		ep.setOrgName(orgName);
		ep.setLocation(location);
		ep.setWebsite(website);
		sref.save(ep);
		
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
