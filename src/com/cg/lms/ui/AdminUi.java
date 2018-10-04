package com.cg.lms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.lms.bean.ApprovedLoans;
import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.exception.LoanException;
import com.cg.lms.service.LoanManagementService;
import com.cg.lms.service.LoanManagementServiceImpl;

public class AdminUi {
	Scanner sc = new Scanner(System.in);
	LoanManagementService lService=null;
	public void adminUiMethod()
	{
		lService= new LoanManagementServiceImpl();
		System.out.println("********Admin Login Page*********");
		System.out.println();
		System.out.println();
		System.out.println("Enter your login id:");
		String username=sc.next();
		System.out.println("Enter your password:");
		String password=sc.next();
		try {
			int value=lService.login(username,password);
			if(value == 2)
			{
				System.out.println("Wrong Credentials.Please try again");
			}
			if(value == 1)
			{
				
				System.out.println("Welcome Admin");
				System.out.println("Select Operation to be performed:");
				System.out.println("1)View all loan Programs \n"
						+ "2)Add a new loan Program \n"
						+ "3)Delete an existing loan Program \n"
						+ "4)Update an existing loan Program \n"
						+ "5)View all acccepted loans \n"
						+ "6)View all rejected loans \n"
						+ "7)View all approved loans ");
				System.out.println("Enter your choice:");
				int c=sc.nextInt();
				do{///////////////////////
				switch(c)
					{
						case 1:displayAllLoans();
							break;
						case 2:insertLoan();
							break;
						case 3:deleteLoan();
							break;
						case 4:updateLoan();
							break;
						case 5:AcceptedLoans();
							break;
						case 6:RejectedLoans();
							break;
						case 7:ApprovedLoans();
							break;
						case 8:
							System.exit(0);
						default:
							System.out.println("Wrong Choice");
					}
				System.out.println("Welcome Admin");
				System.out.println("Select Operation to be performed:");
				System.out.println("1)View all loan Programs \n"
						+ "2)Add a new loan Program \n"
						+ "3)Delete an existing loan Program \n"
						+ "4)Update an existing loan Program \n"
						+ "5)View all acccepted loans \n"
						+ "6)View all rejected loans \n"
						+ "7)View all approved loans \n"
						+ "8)EXIT");
				System.out.println("Enter your choice:");
				c=sc.nextInt();
				}while(c!=8);
			}
		} 
		catch (LoanException e)
		{
			e.printStackTrace();
		}
	}
	
	//for viewing the Approved Loans  
	private void ApprovedLoans()
	{
		 ArrayList<ApprovedLoans> loanList;
		try {
			loanList= lService.viewApprovedLoans();
			System.out.println("\tApplication_Id \tCustomer_name \tAmountofloangranted()"
					+ " \tMonthlyinstallment \tYearstimeperiod \tDownpayment"
					+ " \tRateofinterest \tTotalamountpayable");
			for(ApprovedLoans l:loanList)
			{
				System.out.println("\t"+l.getApplication_Id()+
						"\t"+l.getCustomer_name()+"\t"+l.getAmountofloangranted()+
						"\t"+l.getMonthlyinstallment()+"\t"+l.getYearstimeperiod()+
						"\t"+l.getDownpayment()+"\t"+l.getRateofinterest()+
						"\t"+l.getTotalamountpayable());
			}
		} 
		catch (LoanException e) 
		{
			e.printStackTrace();
		}
		
		
	}

	//for viewing the Rejected Loans 
	private void RejectedLoans() 
	{
		ArrayList<LoanApplication> loanList;
		try {
			loanList= lService.viewRejectedLoans();
			System.out.println("\tApplication_Id \tApplication_date \tLoan_program()"
					+ " \tAmountofLoan \tAddressofProperty \tAnnualFamilyIncome"
					+ " \tDocumentProofsAvailable \tGuaranteeCover \tMarketValueofGuaranteeCover "
					+ "\tStatus \tDateOfInterview");
			for(LoanApplication l:loanList)
			{
				System.out.println("\t"+l.getApplication_Id()+
						"\t"+l.getApplication_date()+"\t"+l.getLoan_program()+
						"\t"+l.getAmountofLoan()+"\t"+l.getAddressofProperty()+
						"\t"+l.getAnnualFamilyIncome()+"\t"+l.getDocumentProofsAvailable()+
						"\t"+l.getGuaranteeCover()+"\t"+l.getMarketValueofGuaranteeCover()+
						"\t"+l.getStatus()+"\t"+l.getDateOfInterview());
			}
		} 
		catch (LoanException e) 
		{
			e.printStackTrace();
		}
		


		
	}

	//for viewing the Accepted Loans 
	private void AcceptedLoans() 
	{
		
		ArrayList<LoanApplication> loanList;
		try {
			loanList= lService.viewAcceptedLoans();
			System.out.println("\tApplication_Id \tApplication_date \tLoan_program()"
					+ " \tAmountofLoan \tAddressofProperty \tAnnualFamilyIncome"
					+ " \tDocumentProofsAvailable \tGuaranteeCover \tMarketValueofGuaranteeCover "
					+ "\tStatus \tDateOfInterview");
			for(LoanApplication l:loanList)
			{
				System.out.println("\t"+l.getApplication_Id()+
						"\t"+l.getApplication_date()+"\t"+l.getLoan_program()+
						"\t"+l.getAmountofLoan()+"\t"+l.getAddressofProperty()+
						"\t"+l.getAnnualFamilyIncome()+"\t"+l.getDocumentProofsAvailable()+
						"\t"+l.getGuaranteeCover()+"\t"+l.getMarketValueofGuaranteeCover()+
						"\t"+l.getStatus()+"\t"+l.getDateOfInterview());
			}
		} 
		catch (LoanException e)
		{
			e.printStackTrace();
		}
		

		
	}

//for viewing all the Loan Programs offered
	private void displayAllLoans() 
	{
		
		ArrayList<LoanProgramsOffered> loanList;
		try {
			loanList=lService.viewLoanProgramOffered();
			System.out.println("\tProgramName \tdescription \ttype \tdurationinyears \tminloanamount \tmaxloanamount \trateofinterest \tproofs_required");
			for(LoanProgramsOffered l:loanList)
			{
				System.out.println("\t"+l.getProgramName()+"\t"+l.getDescription()+"\t"+l.getType()+"\t"+l.getDurationinyears()+"\t"+l.getMinloanamount()+"\t"+l.getMaxloanamount()+"\t"+l.getRateofinterest()+"\t"+l.getProofs_required());
			}
		} 
		catch (LoanException e) 
		{
			e.printStackTrace();
		}
	}
	//Updating the Loan program details
	private void updateLoan()
	{
		
		System.out.println("Enter Loan Program you want to update:");
		String loanProg=sc.next();
		
		System.out.println("Enter new Description:");
		String desc=sc.next();
		System.out.println("Enter new Type:");
		String type=sc.next();
		System.out.println("Enter new duration in years:");
		int duration=sc.nextInt();
		System.out.println("Enter new minimum loan amount:");
		double min=sc.nextDouble();
		System.out.println("Enter new maximum loan amount:");
		double max=sc.nextDouble();
		System.out.println("Enter new interest rate:");
		double rate=sc.nextDouble();
		System.out.println("Enter new Proofs Required:");
		String proof=sc.next();
		
		LoanProgramsOffered obj=new LoanProgramsOffered(loanProg,desc,type,duration,min,max,rate,proof);
		
		int dataUpdated;
		try {
			dataUpdated = lService.updateLoanProgram(obj);
			if(dataUpdated==0)
				System.out.println("Sorry,data not Updated");
			if(dataUpdated==1)
				System.out.println("data updated");
		} 
		catch (LoanException e) 
		{
			e.printStackTrace();
		}
		
	}
	//Adding the new Loan program details
	private void insertLoan()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Loan Program:");
		String loanProg=sc.next();
		System.out.println("Enter Description:");
		String desc=sc.next();
		System.out.println("Enter Type:");
		String type=sc.next();
		System.out.println("Enter duration in years:");
		int duration=sc.nextInt();
		System.out.println("Enter minimum loan amount:");
		double min=sc.nextDouble();
		System.out.println("Enter maximum loan amount:");
		double max=sc.nextDouble();
		System.out.println("Enter interest rate:");
		double rate=sc.nextDouble();
		System.out.println("Enter Proofs Required:");
		String proof=sc.next();
		LoanProgramsOffered obj=new LoanProgramsOffered(loanProg,desc,type,duration,min,max,rate,proof);
		int dataInserted;
		try {
			dataInserted = lService.addLoanProgram(obj);
			if(dataInserted==0)
				System.out.println("Sorry,data not inserted");
			if(dataInserted==1)
				System.out.println("data inserted");
		} 
		catch (LoanException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	//Deleting Loan Program
	private void deleteLoan()
	{
		
		System.out.println("Enter the Loan Name which you want to delete");
		String loanName=sc.next();
		int tupleDeleted;
		try
		{
			tupleDeleted= lService.deleteLoanProgram(loanName);
			System.out.println("The desired program has been removed");
		}
		catch (LoanException e) 
		{
			e.printStackTrace();
		}
	}

}
