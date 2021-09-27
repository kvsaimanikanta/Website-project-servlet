package com.Website.Dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Website.Pojo.EmployerPojo;
import com.Website.Pojo.PostJobPojo;

public class PostJobDao {
	
	public void postjob(String title,String type,int yop,String qualification,String skills,int exp,String date,String jobdesc,String email,String org) {
		
		Configuration cref = new Configuration();
		cref.configure("website.cfg.xml");
		
		SessionFactory sfref =cref.buildSessionFactory();
		
		Session sref = sfref.openSession();
		
		Transaction tref = sref.beginTransaction();
		
		
		PostJobPojo pjp = new PostJobPojo();
		pjp.setJodTitle(title);
		pjp.setJobType(type);
		pjp.setYop(yop);
		pjp.setQualfication(qualification);
		pjp.setSkills(skills);
		pjp.setExperience(exp);
		pjp.setDate(date);
		pjp.setOrganization(org);
		pjp.setDescription(jobdesc);
		pjp.setEmplerEmail(email);
		sref.save(pjp);
		
		tref.commit();
		sref.close();
		sfref.close();
		
	}

}
