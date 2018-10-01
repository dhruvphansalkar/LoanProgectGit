package com.cg.lms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.cg.lms.bean.ApprovedLoans;
import com.cg.lms.bean.CustomerDetails;
import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.exception.LoanException;
import com.cg.lms.util.DBUtil;

public class LoanManagementDaoImpl implements LoanManagementDao 
{

	//Logger daoLogger=null;
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	int data=0;

	@Override
<<<<<<< HEAD
	public int login(String username, String Password)throws LoanException
=======
	public int login(String username, String Password) //Tested and working
>>>>>>> d156ff251039a1d270323c49907a3ff6bfee0068
	{
		try {
			con=DBUtil.getConn();
			String selectQry="select Login_Id,Password from EndUsers where Login_id=? and Password=?";
			pst=con.prepareStatement(selectQry);
			pst.setString(1,username);
			pst.setString(2,Password);
			rs=pst.executeQuery();
			rs.next();
			if(rs!=null)
				return 1;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new LoanException(e.getMessage());
		}
		
		return -1;
	}

	@Override
<<<<<<< HEAD
	public int addLoanProgram(LoanProgramsOffered loanPrograms)
			throws LoanException {
		String insertQry="insert into LoanProgramsOffered values (?,?,?,?,?,?,?,?)";
		try {
			pst=con.prepareStatement(insertQry);
			pst.setString(1, loanPrograms.getProgramName());
			pst.setString(2, loanPrograms.getDescription());
			pst.setString(3, loanPrograms.getType());
			pst.setInt(4, loanPrograms.getDurationinyears());
			pst.setDouble(5, loanPrograms.getMinloanamount() );
			pst.setDouble(6, loanPrograms.getMaxloanamount());
			pst.setDouble(7, loanPrograms.getRateofinterest());
			pst.setString(8, loanPrograms.getProofs_required());
			data = pst.executeUpdate();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LoanException(e.getMessage());
		}
		return data;
=======
	public int addLoanProgram(LoanProgramsOffered loanPrograms) throws LoanException {
		// TODO Auto-generated method stub
		return 0;
>>>>>>> d156ff251039a1d270323c49907a3ff6bfee0068
	}

	@Override
	public int deleteLoanProgram(String programName) throws LoanException {
		int returnval=0;
		try 
		{			
			con=DBUtil.getConn();
			String selectQry="delete from LoanProgramsOffered where ProgramName=?";
			pst=con.prepareStatement(selectQry);
			pst.setString(1,programName);
			returnval=pst.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return returnval;
	}

	@Override
	public int updateLoanProgram(LoanProgramsOffered loanPrograms) throws LoanException {
		int returnval=0;
		try 
		{			
			con=DBUtil.getConn();
			String selectQry="update LoanProgramsOffered set description=?,type=?,durationinyears=?,minloanamount=?,maxloanamount=?,rateofinterest=?,proofs_required=? where ProgramName=?";
			pst=con.prepareStatement(selectQry);
			pst.setString(1,loanPrograms.getDescription());
			pst.setString(2,loanPrograms.getType());
			pst.setInt(3,loanPrograms.getDurationinyears());
			pst.setInt(4,loanPrograms.getMinloanamount());
			pst.setInt(5,loanPrograms.getMaxloanamount());
			pst.setInt(6,loanPrograms.getRateofinterest());
			pst.setString(7,loanPrograms.getProofs_required());
			pst.setString(8,loanPrograms.getProgramName());
			
			returnval=pst.executeUpdate();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return returnval;
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
	public int updateApplicationStatus(int appId, String newStatus,Timestamp date) throws LoanException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setStatusAfterInterview(int appId, String newStatus) throws LoanException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addCustomerDetails(CustomerDetails custDetails, LoanApplication loanApp) throws LoanException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LoanApplication viewApplicationStatusById(int id) throws LoanException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LoanProgramsOffered> viewLoanProgramOffered() throws LoanException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanProgramsOffered getLoanProgramByName(String loanName) throws LoanException {
		// TODO Auto-generated method stub
		return null;
	}

}
