package com.cg.lms.ui;

<<<<<<< HEAD
=======
import java.sql.Date;
>>>>>>> 3cb2d6012fc4ae0e9c8bfd5956358940913584a0
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.exception.LoanException;
import com.cg.lms.service.LoanManagementService;
import com.cg.lms.service.LoanManagementServiceImpl;

public class LadUi 
{
	LoanManagementService lService=null;
	Scanner sc = new Scanner(System.in);
	
	public void ladUiMethod()
	{
<<<<<<< HEAD
		lService= new LoanManagementServiceImpl();
=======
		System.out.println("********LAD Login Page*********");
		System.out.println();
		System.out.println();
>>>>>>> 3cb2d6012fc4ae0e9c8bfd5956358940913584a0
		System.out.println("Enter your login id:");
		String uname=sc.next();
		System.out.println("Enter your password:");
		String pwd=sc.next();
	
			try {
				int value = lService.login(uname,pwd);
				if(value == 2)
				{
					System.out.println("Wrong Credentials.Please try again");
				}
				if(value == 1)
				{
<<<<<<< HEAD
					System.out.println("+++++++++Welcome Loan Approval Department +++++++++++");
					while(true)
					{
						
						System.out.println("Select Operation to be performed:");
						System.out.println("1)View all loan Programs \n"
								+ "2)View all Application by loan Programs \n"
								+ "3)Update Application status \n"
								+ "4)Update status after interview \n"
								+ "5)Exit ");
						System.out.println("Enter your choice:");
						int c=sc.nextInt();
						switch(c)
						{
							case 1:displayAllLoans();
								break;
							case 2:viewAppByLoanProg();
								break;
						/*	case 3:deleteLoan();
								break;
							case 4:updateLoan();
								break;*/
							case 5: System.exit(0);
							default:
									System.out.println("Wrong Choice");
						}
					}
=======
					System.out.println("*****************Congratulations********************");
				
					
					System.out.println("Welcome LAD");
					System.out.println("Select Operation to be performed:");
					System.out.println("1)view Loan Program Offered \n"
							+ "2)update Application Status \n"
							+ "3)set Status After Interview \n"
							+ "4)view Application By Loan Program\n"
							+ "5)EXIT ");
					System.out.println("Enter your choice:");
					int c=sc.nextInt();
					do{
					switch(c)
						{
							case 1:viewAllLoanProgramsUi();
								break;
							case 2:updateApplicationStatusAndDateUi();
								break;
							case 3:changeStatusAfterInterviewUi();
								break;
							case 4:viewApplicationByLoanProgramUi();
								break;
							case 5:
								System.exit(0);
							default:
								System.out.println("Wrong Choice");
						}
					System.out.println("Welcome LAD");
					System.out.println("Select Operation to be performed:");
					System.out.println("1)view Application By Loan Program \n"
							+ "2)update Application Status \n"
							+ "3)set Status After Interview \n"
							+ "4)view Loan Program Offered \n"
							+ "5)EXIT ");
					System.out.println("Enter your choice:");
					c=sc.nextInt();
					}while(c!=5);
					
>>>>>>> 3cb2d6012fc4ae0e9c8bfd5956358940913584a0
				}
				
			} 
			catch (LoanException e)
			{
				e.printStackTrace();
			}
		
	}
<<<<<<< HEAD
	private void viewAppByLoanProg() 
	{
		ArrayList<LoanApplication> loanList;
		System.out.println("Enter the loan program name to view applications:");
		String progName=sc.next();
		try {
			loanList=lService.viewApplicationByLoanProgram(progName);
			System.out.println("\tApplication_Id \tApplication_date \tLoan_program"
					+ " \tAmountofLoan \tAddressofProperty \tAnnualFamilyIncome "
					+ "\tDocumentProofsAvailable \tGuaranteeCover "
					+ "\tMarketValueofGuaranteeCover \tStatus"
					+ "\tDateOfInterview");
		for(LoanApplication l:loanList)
		{
			System.out.println("\t"+l.getApplication_Id()+"\t"+l.getApplication_date()+
					"\t"+l.getLoan_program()+"\t"+l.getAmountofLoan()+
					"\t"+l.getAddressofProperty()+"\t"+l.getAnnualFamilyIncome()+
					"\t"+l.getDocumentProofsAvailable()+"\t"+l.getGuaranteeCover()+"\t"+l.getMarketValueofGuaranteeCover()+
					"\t"+l.getStatus()+"\t"+l.getDateOfInterview());
		}
		}
		catch (LoanException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	private void displayAllLoans() 
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
	
=======

	private void viewApplicationByLoanProgramUi() 
	{
		// TODO Auto-generated method stub
		
	}

	private void changeStatusAfterInterviewUi() 
	{
		// TODO Auto-generated method stub
		
	}

	private void updateApplicationStatusAndDateUi() 
	{
		// TODO Auto-generated method stub
		
	}

	private void viewAllLoanProgramsUi() 
	{
		// TODO Auto-generated method stub
		
	}
>>>>>>> 3cb2d6012fc4ae0e9c8bfd5956358940913584a0
}
