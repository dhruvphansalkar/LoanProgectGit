package com.cg.lms.bean;

import java.sql.Date;
import java.sql.Timestamp;


public class CustomerDetails {
	int Application_Id; 
	String Applicant_name;
	Date date_of_birth;
	String marital_status; 
	int phone_number;
	int mobile_number;
	int CountofDependents; 
	String email_id;
	public int getApplication_Id() {
		return Application_Id;
	}
	public void setApplication_Id(int application_Id) {
		Application_Id = application_Id;
	}
	public String getApplicant_name() {
		return Applicant_name;
	}
	public void setApplicant_name(String applicant_name) {
		Applicant_name = applicant_name;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public int getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(int mobile_number) {
		this.mobile_number = mobile_number;
	}
	public int getCountofDependents() {
		return CountofDependents;
	}
	public void setCountofDependents(int countofDependents) {
		CountofDependents = countofDependents;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	@Override
	public String toString() {
		return "CustomerDetails [Application_Id=" + Application_Id
				+ ", Applicant_name=" + Applicant_name + ", date_of_birth="
				+ date_of_birth + ", marital_status=" + marital_status
				+ ", phone_number=" + phone_number + ", mobile_number="
				+ mobile_number + ", CountofDependents=" + CountofDependents
				+ ", email_id=" + email_id + "]";
	}
	public CustomerDetails(int application_Id, String applicant_name,
			Date date_of_birth, String marital_status, int phone_number,
			int mobile_number, int countofDependents, String email_id) {
		super();
		Application_Id = application_Id;
		Applicant_name = applicant_name;
		this.date_of_birth = date_of_birth;
		this.marital_status = marital_status;
		this.phone_number = phone_number;
		this.mobile_number = mobile_number;
		CountofDependents = countofDependents;
		this.email_id = email_id;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public CustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
