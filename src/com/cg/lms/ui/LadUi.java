package com.cg.lms.ui;

import java.util.Scanner;

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
					System.out.println("Congratulations");
				}
				
			} 
			catch (LoanException e)
			{
				e.printStackTrace();
			}
		
	}
}
