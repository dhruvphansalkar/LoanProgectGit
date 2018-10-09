package com.cg.lms.ui;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Date;
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

	LoanManagementService lService=null;
	Scanner sc = new Scanner(System.in);
	LoanApplication loanApp = null;
	CustomerDetails cd = null;
	
	public void cuiMethod() throws LoanException
	{
		lService= new LoanManagementServiceImpl();
		System.out.println("+++++++++Welcome Customer+++++++++++");
		int c=0;
		System.out.println("Select Operation to be performed:");
		System.out.println("1)View all loan Programs \n"
				+ "2)View Application status by ID \n"
				+ "3)Apply for Loan \n"
				+ "\n 4)Exit ");
		System.out.println("Enter your choice:");
		c=sc.nextInt();
		do
		{
			switch(c)
			{
				case 1:displayAllLoans();
					break;
				case 2:viewAppStatusByID();
					break;
				case 3:addLoan();
					break;
				/*case 4:updateLoan();
					break;*/
				case 4: System.exit(0);
				default:System.out.println("Wrong Choice");
			}
			System.out.println("Select Operation to be performed:");
			System.out.println("1)View all loan Programs \n"
					+ "2)View Application status by ID \n"
					+ "3)Apply for Loan"
					+ "4)Exit ");
			System.out.println("Enter your choice:");
			c=sc.nextInt();
		}while(c!=4);
	}
	//For viewing Application status of customer by ID
	private void viewAppStatusByID() throws LoanException
	{
		System.out.println("Enter Your Application Id");
		int app_id=sc.nextInt();
		try {
			LoanApplication obj=lService.viewApplicationStatusById(app_id);
			System.out.println(obj);
			
		}
		catch (LoanException e) 
		{
			throw new LoanException("Please check the application status");
		}
	}

//For viewing all the loan programs offered
	private void displayAllLoans() throws LoanException 
	{
		
		ArrayList<LoanProgramsOffered> loanList;
		try {


			lService = new LoanManagementServiceImpl();

			loanList=lService.viewLoanProgramOffered();
			System.out.println("\tProgramName \tdescription \t\ttype \tdurationinyears \tminloanamount \tmaxloanamount \trateofinterest \tproofs_required");
			for(LoanProgramsOffered l:loanList)
			{
				System.out.println("\t"+l.getProgramName()+"\t"+l.getDescription()+"\t"+l.getType()+"\t\t"+l.getDurationinyears()+"\t\t\t"+l.getMinloanamount()+"\t\t"+l.getMaxloanamount()+"\t\t"+l.getRateofinterest()+"\t\t"+l.getProofs_required());
			}
		} 
		catch (LoanException e) 
		{
			throw new LoanException("Sorry for the inconvenience");
		}
	}

	// To apply for the Loan
	private void addLoan()
	{
		try
		{
			
			Date t =null;
			lService = new LoanManagementServiceImpl();
			System.out.println("Enter the Loan Program you want to avail");
			String prog = sc.next();
			lService.validateLoanProgramName(prog);
			LoanProgramsOffered obj=lService.getLoanProgramByName(prog);
			System.out.println("Enter your address");
			String address = sc.next();
			System.out.println("Enter your annual family Income");
			int income = sc.nextInt();
			System.out.println("Document proofs available");
			String docProof = sc.next();
			String document=obj.getProofs_required();
			System.out.println(document);
			lService.validateDocument(docProof,document);
			System.out.println("Enter the collateral against the loan");
			String guarentee = sc.next();
			System.out.println("Enter the value of the collateral");
			int guarenteeValue = sc.nextInt();
			System.out.println("Enter the amount of loan you wish to apply for");
			int amtLoan = sc.nextInt();
			
			double min=obj.getMinloanamount();
			double max=obj.getMaxloanamount();
			lService.validateLoanAmount(min, max, amtLoan);
			loanApp = new LoanApplication(1, t, prog, amtLoan, address, income, docProof, guarentee, guarenteeValue, "abc", t);
			
			System.out.println("Enter your name");
			String name = sc.next();
			lService.validateCustName(name);
			System.out.println("Enter your date of birth");
			String date = sc.next();
			lService.validateDateFormat(date);
			java.util.Date utilDate = new SimpleDateFormat("dd-MMM-yy").parse(date);
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			System.out.println("Enter your marital status");
			String maritalStatus = sc.next();
			System.out.println("Enter your phone number");
			int phNo = sc.nextInt();
			lService.validatePhoneNo(phNo);
			System.out.println("Enter your Mobile number");
			int mobNo = sc.nextInt();
			lService.validateMobileNo(mobNo);
			System.out.println("Enter the count of dependents");
			int dependents = sc.nextInt();
			System.out.println("Enter your email address");
			String email = sc.next();
			lService.validateEmailId(email);
			cd = new CustomerDetails(1,name, sqlDate,maritalStatus,phNo,mobNo,dependents,email);
			
			int data = lService.addCustomerDetails(loanApp, cd);
			if(data==1)
			{
				System.out.println("Application succesfully created");
			}
			else
			{
				System.out.println("error in application creation");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
