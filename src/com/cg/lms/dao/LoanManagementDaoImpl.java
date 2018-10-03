package com.cg.lms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
	PreparedStatement pst2=null;
	ResultSet rs=null;
	int data=0;
	int data2=0;

	@Override
	public int login(String username, String Password)throws LoanException //Tested and working
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
			pst.setDouble(4,loanPrograms.getMinloanamount());
			pst.setDouble(5,loanPrograms.getMaxloanamount());
			pst.setDouble(6,loanPrograms.getRateofinterest());
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
		ArrayList<LoanApplication> Llist=null;
		try {
			con=DBUtil.getConn();
			String selectQry="select * from LoanApplication where Status='accepted'";
			st=con.createStatement();
			rs=st.executeQuery(selectQry);
			while(rs.next())
			{
				Llist.add(new LoanApplication(rs.getInt("Application_Id"),
						rs.getTimestamp("application_date"),rs.getString("Loan_program"),rs.getInt("AmountofLoan")
						,rs.getString("AddressofProperty"),rs.getInt("AnnualFamilyIncome")
						,rs.getString("DocumentProofsAvailable"),rs.getString("GuaranteeCover")
						,rs.getInt("MarketValueofGuaranteeCover"),rs.getString("Status"),rs.getTimestamp("DateOfInterview")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LoanException(e.getMessage());
		}
		
		return Llist;
	}
	
	
	
	
	

	@Override
	public ArrayList<LoanApplication> viewRejectedLoans() throws LoanException {
		ArrayList<LoanApplication> Llist=null;
		try {
			con=DBUtil.getConn();
			String selectQry="select * from LoanApplication where Status='rejected'";
			st=con.createStatement();
			rs=st.executeQuery(selectQry);
			while(rs.next())
			{
				Llist.add(new LoanApplication(rs.getInt("Application_Id"),
						rs.getTimestamp("application_date"),rs.getString("Loan_program"),rs.getInt("AmountofLoan")
						,rs.getString("AddressofProperty"),rs.getInt("AnnualFamilyIncome")
						,rs.getString("DocumentProofsAvailable"),rs.getString("GuaranteeCover")
						,rs.getInt("MarketValueofGuaranteeCover"),rs.getString("Status"),rs.getTimestamp("DateOfInterview")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LoanException(e.getMessage());
		}
		
		return Llist;
	}
	
	
	
	

	@Override
	public ArrayList<ApprovedLoans> viewApprovedLoans() throws LoanException
	{
		ArrayList<ApprovedLoans> Llist=null;
		try {
			con=DBUtil.getConn();
			String selectQry="select * from ApprovedLoans";
			st=con.createStatement();
			rs=st.executeQuery(selectQry);
			while(rs.next())
			{
				Llist.add(new ApprovedLoans(rs.getInt("Application_Id"),
						rs.getString("Customer_name"),rs.getInt("amountofloangranted")
						,rs.getInt("monthlyinstallment"),rs.getInt("yearstimeperiod"),
						rs.getInt("downpayment"),
						rs.getInt("rateofinterest"),rs.getInt("totalamountpayable")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LoanException(e.getMessage());
		}
		
		return Llist;
	}
	
	
	
	

	@Override
	public ArrayList<LoanApplication> viewApplicationByLoanProgram(
			String programName) throws LoanException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

	@Override
	public int updateApplicationStatus(int appId, String newStatus,Date date) throws LoanException {
		try
		{
			con=DBUtil.getConn();
			String updateQry="update LoanApplication set status = ?, DateOfInterview = ? where Application_Id = ?";
			pst=con.prepareStatement(updateQry);
			pst.setString(1, newStatus);
			pst.setDate(2, date);
			pst.setInt(3, appId);
			data = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}

	
	
	
	@Override
	public int setStatusAfterInterview(int appId, String newStatus) throws LoanException {
		try
		{
			con=DBUtil.getConn();
			String updateQry="update LoanApplication set status = ? where Application_Id = ?";
			pst=con.prepareStatement(updateQry);
			pst.setString(1, newStatus);
			pst.setInt(2, appId);
			data = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
		
	}
	
	
	
	

	@Override
	public int addCustomerDetails(LoanApplication loanApp, CustomerDetails custDetails) throws LoanException 
	{
		try 
		{
			 long millis=System.currentTimeMillis();  
			 java.sql.Date date=new java.sql.Date(millis); 
			con=DBUtil.getConn();
			String insertQry2="insert into LoanApplication(Application_Id,Loan_Program,AddressOfProperty,"
					+ "AnnualFamilyIncome,DocumentProofsAvailable,GuaranteeCover,MarketValueOfGuaranteeCover,"
					+ "AmountofLoan,Application_Date) values(sequence_app_id.nextval,?,?,?,?,?,?,?,?)";
			pst2=con.prepareStatement(insertQry2);
			
			pst2.setString(1, loanApp.getLoan_program());
			pst2.setString(2, loanApp.getAddressofProperty());
			pst2.setInt(3, loanApp.getAnnualFamilyIncome());
			pst2.setString(4, loanApp.getDocumentProofsAvailable());
			pst2.setString(5, loanApp.getGuaranteeCover());
			pst2.setInt(6, loanApp.getMarketValueofGuaranteeCover());
			pst2.setInt(7, loanApp.getAmountofLoan());
			pst2.setDate(8, date);
			
			data2 = pst2.executeUpdate();
			
			
			
			String insertQry1="insert into CustomerDetails values (sequence_app_id.currval,?,?,?,?,?,?,?)";
			pst=con.prepareStatement(insertQry1);
			pst.setString(1, custDetails.getApplicant_name());
			pst.setDate(2, custDetails.getDate_of_birth());
			pst.setString(3, custDetails.getMarital_status());
			pst.setInt(4, custDetails.getPhone_number());
			pst.setInt(5, custDetails.getMobile_number());
			pst.setInt(6,custDetails.getCountofDependents());
			pst.setString(7, custDetails.getEmail_id());
			data = pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	
	

	@Override
	public LoanApplication viewApplicationStatusById(int id) throws LoanException
	{
		LoanApplication obj=null;
		try {
			con=DBUtil.getConn();
			String selectQry="select * from LoanApplication where Application_Id=?";
			pst=con.prepareStatement(selectQry);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				obj=new LoanApplication(rs.getInt("Application_Id"),
						rs.getTimestamp("application_date"),rs.getString("Loan_program"),rs.getInt("AmountofLoan")
						,rs.getString("AddressofProperty"),rs.getInt("AnnualFamilyIncome")
						,rs.getString("DocumentProofsAvailable"),rs.getString("GuaranteeCover")
						,rs.getInt("MarketValueofGuaranteeCover"),rs.getString("Status"),rs.getTimestamp("DateOfInterview"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LoanException(e.getMessage());
		}
		
		return obj;
	}
	
	
	

	@Override
	public ArrayList<LoanProgramsOffered> viewLoanProgramOffered() throws LoanException 
	{
		ArrayList<LoanProgramsOffered> loanList=null;
		try
		{
			loanList=new ArrayList<LoanProgramsOffered>();
			con=DBUtil.getConn();
			String selectQry="select * from LoanProgramsOffered";
			st=con.createStatement();
			rs=st.executeQuery(selectQry);
			
			while(rs.next())
			{
				//dao.info(new Employee(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getFloat("emp_sal")));
				loanList.add(new LoanProgramsOffered(rs.getString("ProgramName"),rs.getString("description"),rs.getString("type"),rs.getInt("durationinyears"),rs.getDouble("minloanamount"),rs.getDouble("maxloanamount"),rs.getDouble("rateofinterest"),rs.getString("proofs_required")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new LoanException(e.getMessage());
		}
		finally
		{
			try
			{
				st.close();
				rs.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				//daoLogger.error(e.getMessage());
				throw new LoanException(e.getMessage());
			}
		}
		//daoLogger.info("All data retrieved \n"+empList);
		return loanList;
		
	}
	
	
	
	

	@Override
	public LoanProgramsOffered getLoanProgramByName(String loanName) throws LoanException {
		LoanProgramsOffered lpo = null;
		try
		{
			con=DBUtil.getConn();
			String updateQry="select * from LoanProgramsOffered where ProgramName=?";
			pst=con.prepareStatement(updateQry);
			pst.setString(1, loanName);
			rs = pst.executeQuery();
			lpo= (LoanProgramsOffered)rs.getObject(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lpo;
		
	}

}
