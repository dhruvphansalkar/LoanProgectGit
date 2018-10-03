package com.cg.lms.ui;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.lms.bean.LoanApplication;
import com.cg.lms.bean.LoanProgramsOffered;
import com.cg.lms.exception.LoanException;
import com.cg.lms.service.LoanManagementService;

public class LadUi 
{
	LoanManagementService lService=null;
	Scanner sc = new Scanner(System.in);
	
	public void ladUiMethod()
	{
		System.out.println("********LAD Login Page*********");
		System.out.println();
		System.out.println();
		System.out.println("Enter your login id:");
		String uname=sc.next();
		System.out.println("Enter your password:");
		String pwd=sc.next();
	
			try {
				int value = lService.login(uname,pwd);
				if(value == -1)
				{
					System.out.println("Wrong Credentials.Please try again");
				}
				if(value == 1)
				{
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
					
				}
				
			} 
			catch (LoanException e)
			{
				e.printStackTrace();
			}
		
	}

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
}
