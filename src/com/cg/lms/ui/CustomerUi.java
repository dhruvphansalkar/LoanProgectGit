package com.cg.lms.ui;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import oracle.sql.DATE;

import com.cg.lms.bean.CustomerDetails;
import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.exception.LoanException;
import com.cg.lms.service.LoanManagementService;
import com.cg.lms.service.LoanManagementServiceImpl;

public class CustomerUi 
{
	Scanner sc=new Scanner(System.in);
	LoanManagementService lService=null;
	LoanApplication loanApp = null;
	CustomerDetails cd = null;
	public void customerUiMethod()
	{
		
		System.out.println("**********Welcome Customer**********");
		System.out.println("Select Operation to be performed:");
		System.out.println("1)View all loan Programs \n"
				+ "2)Apply for a loan Program \n"
				+ "3)Exit");
				
		System.out.println("Enter your choice:");
		int c=sc.nextInt();
		do{///////////////////////
		switch(c)
			{
				case 1:displayAllLoans();
					break;
				case 2:addLoan();
					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("Wrong Choice");
			}
		System.out.println("********Welcome Customer********");
		System.out.println("Select Operation to be performed:");
		System.out.println("1)View all loan Programs \n"
				+ "2)Apply for a loan Program \n"
				+ "3)Exit");
				
		System.out.println("Enter your choice:");
		c=sc.nextInt();
		}while(c!=8);
	}
	
	private void displayAllLoans() 
	{
		
		ArrayList<LoanProgramsOffered> loanList;
		// TODO Auto-generated method stub
		try {
			lService = new LoanManagementServiceImpl();
			loanList=lService.viewLoanProgramOffered();
			System.out.println("\tProgramName \tdescription \ttype \tdurationinyears \tminloanamount \tmaxloanamount \trateofinterest \tproofs_required");
			for(LoanProgramsOffered l:loanList)
			{
				System.out.println("\t"+l.getProgramName()+"\t"+l.getDescription()+"\t"+l.getType()+"\t"+l.getDurationinyears()+"\t"+l.getMinloanamount()+"\t"+l.getMaxloanamount()+"\t"+l.getRateofinterest()+"\t"+l.getProofs_required());
			}
		} catch (LoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addLoan()
	{
		try
		{
			
		Timestamp t =null;
		lService = new LoanManagementServiceImpl();
		System.out.println("Enter the Loan Program you want to avail");
		String prog = sc.next();
		System.out.println("Enter your address");
		String address = sc.next();
		System.out.println("Enter your annual family Income");
		int income = sc.nextInt();
		System.out.println("Document proofs available");
		String docProof = sc.next();
		System.out.println("Enter the collateral against the loan");
		String guarentee = sc.next();
		System.out.println("Enter the value of the collateral");
		int guarenteeValue = sc.nextInt();
		System.out.println("Enter the amount of loan you wish to apply for");
		int amtLoan = sc.nextInt();
		loanApp = new LoanApplication(1, t, prog, amtLoan, address, income, docProof, guarentee, guarenteeValue, "abc", t);
		
		System.out.println("Enter your name");
		String name = sc.next();
		System.out.println("Enter your date of birth");
		String date = sc.next();
		java.util.Date utilDate = new SimpleDateFormat("dd-MMM-yy").parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("Enter your marital status");
		String maritalStatus = sc.next();
		System.out.println("Enter your phone number");
		int phNo = sc.nextInt();
		System.out.println("Enter your Mobile number");
		int mobNo = sc.nextInt();
		System.out.println("Enter the count of dependents");
		int dependents = sc.nextInt();
		System.out.println("Enter your email address");
		String email = sc.next();
		cd = new CustomerDetails(1,name, sqlDate,maritalStatus,phNo,mobNo,dependents,email);
		
		int data = lService.addCustomerDetails(loanApp, cd);
		if(data==1)
		{
			System.out.println("Application succesfully created");
		}
		{
			System.out.println("error in application creation");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
