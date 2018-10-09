package com.cg.lms.ui;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.lms.bean.ApprovedLoans;
import com.cg.lms.bean.CustomerDetails;
import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.exception.LoanException;
import com.cg.lms.service.LoanManagementService;
import com.cg.lms.service.LoanManagementServiceImpl;

public class LadUi 
{
	LoanManagementService lService=null;
	Scanner sc = new Scanner(System.in);
	ArrayList<LoanApplication> loanList=null;
	LoanApplication la = null;
	LoanProgramsOffered lpo = null;
	CustomerDetails cd = null;
	String cdname;
	public void ladUiMethod() throws LoanException
	{

		lService= new LoanManagementServiceImpl();

		System.out.println("********LAD Login Page*********");
		System.out.println();
		System.out.println();

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
					int c=0;
					System.out.println("+++++++++Welcome Loan Approval Department +++++++++++");
					System.out.println("Select Operation to be performed:");
					System.out.println("1)View all loan Programs \n"
							+ "2)View all Application by loan Programs \n"
							+ "3)Update Application status \n"
							+ "4)Update status after interview \n"
							+ "5)Exit ");
					System.out.println("Enter your choice:");
					c=sc.nextInt();
					
					do
					{
						
				
						switch(c)
						{
							case 1:displayAllLoans();
								break;
							case 2:viewAppByLoanProg();
								break;
							case 3:updateApplicationStatusAndDateUi();
								break;
							case 4:changeStatusAfterInterviewUi();
								break;
							case 5: System.exit(0);
							default:
									System.out.println("Wrong Choice");
						}
						System.out.println("Select Operation to be performed:");
						System.out.println("1)View all loan Programs \n"
								+ "2)View all Application by loan Programs \n"
								+ "3)Update Application status \n"
								+ "4)Update status after interview \n"
								+ "5)Exit ");
						System.out.println("Enter your choice:");
						c=sc.nextInt();
					}while(c!=5);					
				}
				
			} 
			catch (LoanException e)
			{
				throw new LoanException("Wrong credentials.Please retry.");
			}
		
	}
	
	private void viewAppByLoanProg() throws LoanException 
	{
		
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
			
			throw new LoanException("Please enter the correct loan program");
		}
		
	}
	private void displayAllLoans() throws LoanException 
	{
		
		ArrayList<LoanProgramsOffered> loanList;
		try {
			loanList=lService.viewLoanProgramOffered();
			System.out.println("\tProgramName \tdescription \t\ttype \tdurationinyears \tminloanamount \tmaxloanamount \trateofinterest \tproofs_required");
			for(LoanProgramsOffered l:loanList)
			{
				System.out.println("\t"+l.getProgramName()+"\t"+l.getDescription()+"\t"+l.getType()+"\t\t"+l.getDurationinyears()+"\t\t\t"+l.getMinloanamount()+"\t\t"+l.getMaxloanamount()+"\t\t"+l.getRateofinterest()+"\t\t"+l.getProofs_required());			}
		} catch (LoanException e) {
			
			throw new LoanException("Sorry for the inconvenience");
		}
	}
	


	private void changeStatusAfterInterviewUi() throws LoanException 
	{
		ApprovedLoans al =null;
		try
		{
			System.out.println("Enter the application Id of the application");
			int id = sc.nextInt();
			la = lService.viewApplicationStatusById(id);
			lpo = lService.getLoanProgramByName(la.getLoan_program());
			cdname = lService.getCustomerDetailsByAppId(id);
			System.out.println("The application details are");
			System.out.println();
			System.out.println(la);
			if(la.getStatus().equals("approved"))
					{
						System.out.println();
						System.out.println("This application has already been accepted");
						System.out.println();
					}
			else
			{
			System.out.println("Please set the new status as approved or rejected");
			String newStatus= sc.next();
			
			
			int data = lService.setStatusAfterInterview(id, newStatus);
			if(data==1)
				System.out.println("Status is successfully updated");
			
			if(data==1 && newStatus.equals("approved"))
			{
				System.out.println(cdname);
				String custName = cdname;
				System.out.println("Please enter the sum to be granted to the applicant");
				double amtGranted = sc.nextDouble();
				double interest = lpo.getRateofinterest();
				System.out.println("Enter the dowm payment amount");
				double downPayment = sc.nextDouble();
				int duration = lpo.getDurationinyears();
				double totalAmtPayable = amtGranted + (amtGranted*interest*duration/100);
				double installments = (totalAmtPayable - downPayment)/(duration*12);
				
				al = new ApprovedLoans(id,custName,amtGranted,installments,duration,downPayment,interest,totalAmtPayable);
				int data1 = lService.addToApprovedLoan(al);
				
				if(data1 == 1)
				{
					System.out.println("The loan has been approved and added to the required database");
				}
			}
			}
		}
		catch(Exception e)
		{
			throw new LoanException("Please enter the correct status");
		}
	}

	private void updateApplicationStatusAndDateUi() throws LoanException 
	{
		Date sqlDate;
		try
		{
			
			System.out.println("Enter the application Id of the application");
			int id = sc.nextInt();
			LoanApplication la = lService.viewApplicationStatusById(id);
			System.out.println("The application details are");
			System.out.println(la);
		
			if(la.getStatus().equals("approved") || la.getStatus().equals("accepted"))
			{
				System.out.println("Applroval has already been performed");
				
			}
			else
			{
				System.out.println("Please set the new status are accepted or rejected");
				String newStatus= sc.next();
				if(newStatus.equals("accepted"))
				{
					System.out.println("Enter the date of interview");
					String date = sc.next();
					lService.validateDateFormat(date);
					java.util.Date utilDate = new SimpleDateFormat("dd-MMM-yy").parse(date);
					sqlDate = new java.sql.Date(utilDate.getTime());
				}
				else 
				{
					sqlDate = null;
				}
				int data = lService.updateApplicationStatus(id, newStatus, sqlDate);
				if(data==1)
				System.out.println("Status and date are successfully updated");
			}
		}
		catch(Exception e)
		{
			throw new LoanException("Please enter the correct status");
		}
		
	}

	
}
