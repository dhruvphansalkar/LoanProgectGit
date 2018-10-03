package com.cg.lms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.exception.LoanException;
import com.cg.lms.service.LoanManagementService;
import com.cg.lms.service.LoanManagementServiceImpl;

public class CustomerUi 
{
	LoanManagementService lService=null;
	Scanner sc = new Scanner(System.in);
	public void cuiMethod()
	{
		lService= new LoanManagementServiceImpl();
		System.out.println("+++++++++Welcome Customer Namaskar +++++++++++");
		while(true)
		{
			
			System.out.println("Select Operation to be performed:");
			System.out.println("1)View all loan Programs \n"
					+ "2)View Application status by ID \n"
					+ "3)Exit ");
			System.out.println("Enter your choice:");
			int c=sc.nextInt();
			switch(c)
			{
				case 1:displayAllLoans();
					break;
				case 2:viewAppStatusByID();
					break;
			/*	case 3:deleteLoan();
					break;
				case 4:updateLoan();
					break;*/
				case 3: System.exit(0);
				default:
						System.out.println("Wrong Choice");
			}
		}
	}
	private void viewAppStatusByID()
	{
		System.out.println("Enter Your Application Id");
		int app_id=sc.nextInt();
		try {
			LoanApplication obj=lService.viewApplicationStatusById(app_id);
			System.out.println(obj);
			
		} catch (LoanException e) {
			// TODO Auto-generated catch block
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
}
