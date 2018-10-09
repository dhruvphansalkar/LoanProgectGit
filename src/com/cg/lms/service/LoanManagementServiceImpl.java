package com.cg.lms.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.lms.bean.ApprovedLoans;
import com.cg.lms.bean.CustomerDetails;
import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.dao.LoanManagementDao;
import com.cg.lms.dao.LoanManagementDaoImpl;
import com.cg.lms.exception.LoanException;


public class LoanManagementServiceImpl implements LoanManagementService
{
	LoanManagementDao ldao=null;
	public LoanManagementServiceImpl()
	{
		ldao=new LoanManagementDaoImpl();
	}
	@Override
	public int login(String username, String password) throws LoanException {
		// TODO Auto-generated method stub
		return ldao.login(username, password);
	}

	@Override
	public int addLoanProgram(LoanProgramsOffered loanPrograms)
			throws LoanException
	{
		return ldao.addLoanProgram(loanPrograms);
	}

	@Override
	public int deleteLoanProgram(String programName)throws LoanException {
		// TODO Auto-generated method stub
		return ldao.deleteLoanProgram(programName);
	}

	@Override
	public int updateLoanProgram(LoanProgramsOffered loanPrograms)
			throws LoanException {
		// TODO Auto-generated method stub
		return ldao.updateLoanProgram(loanPrograms);
	}

	@Override
	public ArrayList<LoanApplication> viewAcceptedLoans() throws LoanException {
		// TODO Auto-generated method stub
		return ldao.viewAcceptedLoans();
	}

	@Override
	public ArrayList<LoanApplication> viewRejectedLoans() throws LoanException {
		// TODO Auto-generated method stub
		return ldao.viewRejectedLoans();
	}

	@Override
	public ArrayList<ApprovedLoans> viewApprovedLoans() throws LoanException {
		// TODO Auto-generated method stub
		return ldao.viewApprovedLoans();
	}

	@Override
	public ArrayList<LoanApplication> viewApplicationByLoanProgram(
			String programName) throws LoanException {
		// TODO Auto-generated method stub
		return ldao.viewApplicationByLoanProgram(programName);
	}

	@Override
	public int updateApplicationStatus(int appId, String newStatus,
			Date date) throws LoanException {
		// TODO Auto-generated method stub
		return ldao.updateApplicationStatus(appId, newStatus, date);
	}

	@Override
	public int setStatusAfterInterview(int appId, String newStatus)
			throws LoanException {
		// TODO Auto-generated method stub
		return ldao.setStatusAfterInterview(appId, newStatus);
	}

	@Override
	public int addCustomerDetails(LoanApplication loanApp, CustomerDetails custDetails) throws LoanException {
		// TODO Auto-generated method stu

		return ldao.addCustomerDetails(loanApp, custDetails);
	}

	@Override
	public LoanApplication viewApplicationStatusById(int id)
			throws LoanException {
		// TODO Auto-generated method stub
		return ldao.viewApplicationStatusById(id);
	}

	@Override
	public ArrayList<LoanProgramsOffered> viewLoanProgramOffered()
			throws LoanException {
		// TODO Auto-generated method stub
		return ldao.viewLoanProgramOffered();
	}

	@Override
	public LoanProgramsOffered getLoanProgramByName(String loanName)
			throws LoanException {
		// TODO Auto-generated method stub
		return ldao.getLoanProgramByName(loanName);
	}
	@Override
	public String getCustomerDetailsByAppId(int id)throws LoanException 
	{
		return ldao.getCustomerDetailsByAppId(id);
	}
	@Override
	public int addToApprovedLoan(ApprovedLoans ap) throws LoanException {
		return ldao.addToApprovedLoan(ap);
	}
	@Override
	public boolean validateCustName(String ename) throws LoanException 
	{
		String namePattern="[A-Z][a-z]{1,20}";
		if(Pattern.matches(namePattern, ename))
			return true;
		else
		{
			throw new LoanException("\nMaximum 20 characters allowed and start with capital letter only");
		}
	}
	@Override
	public boolean validatePhoneNo(int pno) throws LoanException {
		String PhNo= Integer.toString(pno);
		String numberPattern="[0-9]{8}";
		if(Pattern.matches(numberPattern, PhNo))
			return true;
		else
		{
			throw new LoanException("\nPhone number should contain exactly 8 digits.");
		}
	}
	@Override
	public boolean validateMobileNo(int mno) throws LoanException 
	{
		String mNo= Integer.toString(mno);
		String numberPattern="[0-9]{10}";
		if(Pattern.matches(numberPattern, mNo))
			return true;
		else
		{
			throw new LoanException("\nMobile number should contain exactly 10 digits.");
		}
	}
	@Override
	public boolean validateEmailId(String mailid) throws LoanException
	{
		String namePattern="[a-z0-9_.]+@[a-z]+.[a-z]+";
		if(Pattern.matches(namePattern, mailid))
			return true;
		else
		{
			throw new LoanException("\nEmail id is invalid.");
		}
	}
	@Override
	public boolean validateLoanProgramName(String ename) throws LoanException 
	{
		String namePattern="Program_[A-Z]{1}";
		if(Pattern.matches(namePattern, ename))
			return true;
		else
		{
			throw new LoanException("\nLoan Program Name should of patterm Program_X");
		}
	}
	
	@Override
	public boolean validateLoanAmount(double min,double max, int amount ) throws LoanException 
	{
		
		if(amount>=min && amount<=max)
			return true;
		else
		{
			throw new LoanException("\n Loan Amount should be within a valid range .");
		}
	}
	@Override
	public boolean validateDateFormat(String date) throws LoanException 
	{
		
		String regex = "^[0-3]{1}[0-9]{1}-[A-Z]{3}-[0-9]{2}$"; 
		if(Pattern.matches(regex, date))
			return true;
		else
		{
			throw new LoanException("\n Date should be in DD-MMM-YY format.");
		}
	}
	@Override
	public boolean validateDocument(String docProof, String document) throws LoanException {
		if(docProof.equals(document))
			return true;
		else
		{
			throw new LoanException("\n"+document+"is required.");
		}
	}
	

	
}
