package com.cg.lms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.exception.LoanException;
import com.cg.lms.service.LoanManagementService;
import com.cg.lms.service.LoanManagementServiceImpl;


public class Client {
	static LoanManagementService lService=null;
	static Scanner sc=null;
	public static void main(String[] args) 
	{
		lService= new LoanManagementServiceImpl();
		sc=new Scanner(System.in);
		int choice=0;
		System.out.println("*********Welcome to Loan Management System**********");
		while(true)
		{
			System.out.println("Select User Type:");
			System.out.println("1)Customer \n 2)Admin \n 3)LAD  \n 4)Exit");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				break;
			case 2:
				System.out.println("Enter your login id:");
				String username=sc.next();
				System.out.println("Enter your password:");
				String password=sc.next();
				try {
					int value=lService.login(username,password);
					if(value == -1)
					{
						System.out.println("Wrong Credentials.Please try again");
						break;
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
							case 5:
								break;
							case 6:
								break;
							case 7:
								break;
							default:
									System.out.println("Wrong Choice");
						}
					}
				} catch (LoanException e)
				{
					e.printStackTrace();
				}
				break;
			case 3:System.out.println("Enter your login id:");
			String uname=sc.next();
			System.out.println("Enter your password:");
			String pwd=sc.next();
		
				try {
					int value = lService.login(uname,pwd);
					if(value == -1)
					{
						System.out.println("Wrong Credentials.Please try again");
						break;
					}
					if(value == 1)
					{
						System.out.println("Congratulations");
					}
					
				} 
				catch (LoanException e)
				{
					e.printStackTrace();
				}
			
				break;
			default :System.exit(0);	
			}
		}
		
	}
	private static void displayAllLoans() 
	{
		ArrayList<LoanProgramsOffered> loanList;
		// TODO Auto-generated method stub
		try {
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
	
	private static void updateLoan()
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
		} catch (LoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void insertLoan()
	{
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
		} catch (LoanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void deleteLoan()
	{
		System.out.println("Enter the Loan Name which you want to delete");
		String loanName=sc.nextLine();
		int tupleDeleted;
		try
		{
			tupleDeleted= lService.deleteLoanProgram(loanName);
		}
		catch (LoanException e) 
		{
			e.printStackTrace();
		}
	}

}
