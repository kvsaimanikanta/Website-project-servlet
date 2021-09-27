package com.Website.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Application")
public class ApplicationPojo {
	
	@Id @GeneratedValue
	@Column
	private int ApliId;
	
	@Column
	private String ApliName;
	
	@Column
	private String ApliEmail;
	
	@Column
	private int ApliNumber;
	
	@Column
	private int ApliCtc;
	
	@Column
	private String ApliSkills;
	
	@Column
	private int ApliYop;
	
	@Column
	private String ApliQualification;
	
	@Column
	private int ApliExperience;
	
	@Column
	private int ApliNotice;
	
	@Column
	private int ApliUserId;
	
	@Column
	private String InterviewDate;
	
	@Column
	private String Orgnization;
	
	@Column
	private int JobId;

	public int getApliId() {
		return ApliId;
	}

	public void setApliId(int apliId) {
		ApliId = apliId;
	}

	public String getApliName() {
		return ApliName;
	}

	public void setApliName(String apliName) {
		ApliName = apliName;
	}

	public String getApliEmail() {
		return ApliEmail;
	}

	public void setApliEmail(String apliEmail) {
		ApliEmail = apliEmail;
	}

	public int getApliNumber() {
		return ApliNumber;
	}

	public void setApliNumber(int apliNumber) {
		ApliNumber = apliNumber;
	}

	public int getApliCtc() {
		return ApliCtc;
	}

	public void setApliCtc(int apliCtc) {
		ApliCtc = apliCtc;
	}

	public String getApliSkills() {
		return ApliSkills;
	}

	public void setApliSkills(String apliSkills) {
		ApliSkills = apliSkills;
	}

	public int getApliYop() {
		return ApliYop;
	}

	public void setApliYop(int apliYop) {
		ApliYop = apliYop;
	}

	public String getApliQualification() {
		return ApliQualification;
	}

	public void setApliQualification(String apliQualification) {
		ApliQualification = apliQualification;
	}

	public int getApliExperience() {
		return ApliExperience;
	}

	public void setApliExperience(int apliExperience) {
		ApliExperience = apliExperience;
	}

	public int getApliNotice() {
		return ApliNotice;
	}

	public void setApliNotice(int apliNotice) {
		ApliNotice = apliNotice;
	}

	public int getApliUserId() {
		return ApliUserId;
	}

	public void setApliUserId(int apliUserId) {
		ApliUserId = apliUserId;
	}

	public String getInterviewDate() {
		return InterviewDate;
	}

	public void setInterviewDate(String interviewDate) {
		InterviewDate = interviewDate;
	}

	public String getOrgnization() {
		return Orgnization;
	}

	public void setOrgnization(String orgnization) {
		Orgnization = orgnization;
	}

	public int getJobId() {
		return JobId;
	}

	public void setJobId(int jobId) {
		JobId = jobId;
	}

}

