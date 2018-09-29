package com.cg.lms.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.cg.lms.bean.ApprovedLoans;
import com.cg.lms.bean.CustomerDetails;
import com.cg.lms.bean.EndUser;
import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;

public interface LoanManagementService {
	
	
	//These are the methods accessible to the admin and lad
	public int login(String username, String password);
	
	//These are the methods accessible to the admin
	public int addLoanProgram(LoanProgramsOffered loanPrograms);
	public int deleteLoanProgram(String programName);
	public int updateLoanProgram(LoanProgramsOffered loanPrograms);
	public ArrayList<LoanApplication> viewAcceptedLoans();
	public ArrayList<LoanApplication> viewRejectedLoans();
	public ArrayList<ApprovedLoans> viewApprovedLoans();
	
	//These are the methods accessible to the lad
	public ArrayList<LoanApplication> viewApplicationByLoanProgram(String programName);
	public int updateApplicationStatus(int appId, String newStatus, Timestamp date);//change satus, add date
	public int setStatusAfterInterview(int appId, String newStatus);
	
	//These methods are for the customer
	public int addCustomerDetails(CustomerDetails custDetails, LoanApplication loanApp);
	public LoanApplication viewApplicationStatusById(int id);
	
	//methods for everyone
	public ArrayList<LoanProgramsOffered> viewLoanProgramOffered();
	
	//utilitymethod
	public LoanProgramsOffered getLoanProgramByName(String loanName);
	
	
}
