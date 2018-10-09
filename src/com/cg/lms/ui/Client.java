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
	public static void main(String[] args) throws LoanException 
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
				CustomerUi cui = new CustomerUi();
				cui.cuiMethod();

				break;
			case 2:
				AdminUi adui = new AdminUi();
				adui.adminUiMethod();
				break;
			case 3:
				LadUi ladui = new LadUi();
				ladui.ladUiMethod();
				break;
			default :System.exit(0);	
			}
		}
		
	}
	

}
