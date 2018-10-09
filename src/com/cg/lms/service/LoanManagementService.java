package com.cg.lms.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.cg.lms.bean.ApprovedLoans;
import com.cg.lms.bean.CustomerDetails;
import com.cg.lms.bean.EndUsers;
import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.exception.LoanException;


public interface LoanManagementService {
	
	
	//These are the methods accessible to the admin and lad
	public int login(String username, String password) throws LoanException;
	
	//These are the methods accessible to the admin
	public int addLoanProgram(LoanProgramsOffered loanPrograms) throws LoanException;
	public int deleteLoanProgram(String programName)throws LoanException;
	public int updateLoanProgram(LoanProgramsOffered loanPrograms) throws LoanException;
	public ArrayList<LoanApplication> viewAcceptedLoans() throws LoanException;
	public ArrayList<LoanApplication> viewRejectedLoans() throws LoanException;
	public ArrayList<ApprovedLoans> viewApprovedLoans() throws LoanException;
	
	//These are the methods accessible to the lad
	public ArrayList<LoanApplication> viewApplicationByLoanProgram(String programName) throws LoanException;
	public int updateApplicationStatus(int appId, String newStatus, Date date) throws LoanException;//change satus, add date
	public int setStatusAfterInterview(int appId, String newStatus) throws LoanException;
	public int addToApprovedLoan(ApprovedLoans ap) throws LoanException;
	//These methods are for the customer
	public int addCustomerDetails(LoanApplication loanApp, CustomerDetails custDetails) throws LoanException;
	
	
	//methods for everyone
	public ArrayList<LoanProgramsOffered> viewLoanProgramOffered() throws LoanException;
	
	//utilitymethod
	public LoanProgramsOffered getLoanProgramByName(String loanName) throws LoanException;
	public String getCustomerDetailsByAppId(int id) throws LoanException;
	public LoanApplication viewApplicationStatusById(int id) throws LoanException;
	 
	
	//Validation methods
	public boolean validateCustName(String ename) throws LoanException;
	public boolean validatePhoneNo(int pno) throws LoanException;
	public boolean validateMobileNo(int mno)throws LoanException;
	public boolean validateEmailId(String mailid) throws LoanException;

	public boolean validateLoanProgramName(String ename) throws LoanException;

	public boolean validateLoanAmount(double min, double max, int amount)throws LoanException;
	public boolean validateDateFormat(String date) throws LoanException;

	public boolean validateDocument(String docProof, String document)throws LoanException; 
}
