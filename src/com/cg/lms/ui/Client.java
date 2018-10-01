package com.cg.lms.ui;

import java.util.Scanner;

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
						System.out.println("Congratulations");
						break;
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
						break;
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

}
