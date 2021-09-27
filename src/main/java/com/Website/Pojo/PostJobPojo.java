package com.Website.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PostJob")
public class PostJobPojo {
	
	@Id @GeneratedValue 
	@Column
	private int jobId;
	
	@Column 
	private String JodTitle;
	
	@Column
	private String JobType;
	
	@Column
	private int yop;
	
	@Column
	private String Qualfication;
	
	@Column
	private String skills;
	
	@Column
	private int experience;
	
	@Column 
	private String date;
	
	@Column
	private String description;
	
	@Column
	private String emplerEmail;
	
	@Column
	private String organization;
	
	@Column 
	private boolean isActive = true;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJodTitle() {
		return JodTitle;
	}

	public void setJodTitle(String jodTitle) {
		JodTitle = jodTitle;
	}

	public String getJobType() {
		return JobType;
	}

	public void setJobType(String jobType) {
		JobType = jobType;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public String getQualfication() {
		return Qualfication;
	}

	public void setQualfication(String qualfication) {
		Qualfication = qualfication;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getEmplerEmail() {
		return emplerEmail;
	}

	public void setEmplerEmail(String emplerEmail) {
		this.emplerEmail = emplerEmail;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
		
}
