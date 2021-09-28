package com.Website.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserPojo {
	
	@Id @GeneratedValue
	@Column
	private int userId;

	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private int number;
	
	@Column
	private String skills;
	
	@Column
	private int yop;
	
	@Column
	private int experience;
	
	@Column
	private String organization;
	
	@Column
	private int ctc;
	
	@Column
	private String jobrole;
	
	@Column
	private String location;
	
	@Column
	private String gender;
	
	@Column
	private int notice;
	
	@Column
	private boolean isActive = true;
	
	@Column
	private String qualification;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public int getCtc() {
		return ctc;
	}

	public void setCtc(int ctc) {
		this.ctc = ctc;
	}

	public String getJobrole() {
		return jobrole;
	}

	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNotice() {
		return notice;
	}

	public void setNotice(int notice) {
		this.notice = notice;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", number=" + number + ", skills=" + skills + ", yop=" + yop + ", experience=" + experience
				+ ", organization=" + organization + ", ctc=" + ctc + ", jobrole=" + jobrole + ", location=" + location
				+ ", gender=" + gender + ", notice=" + notice + ", isActive=" + isActive + ", qualification="
				+ qualification + "]";
	}
	
}
