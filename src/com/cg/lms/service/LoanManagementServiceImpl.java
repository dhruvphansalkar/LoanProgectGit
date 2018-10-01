package com.cg.lms.service;

import java.sql.Timestamp;
import java.util.ArrayList;

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
		return null;
	}

	@Override
	public ArrayList<LoanApplication> viewRejectedLoans() throws LoanException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ApprovedLoans> viewApprovedLoans() throws LoanException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LoanApplication> viewApplicationByLoanProgram(
			String programName) throws LoanException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateApplicationStatus(int appId, String newStatus,
			Timestamp date) throws LoanException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setStatusAfterInterview(int appId, String newStatus)
			throws LoanException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addCustomerDetails(CustomerDetails custDetails,
			LoanApplication loanApp) throws LoanException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LoanApplication viewApplicationStatusById(int id)
			throws LoanException {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

}
