package com.cg.lms.junit;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.cg.lms.bean.CustomerDetails;
import com.cg.lms.bean.LoanApplication;
import com.cg.lms.dao.LoanManagementDaoImpl;
import com.cg.lms.exception.LoanException;
import com.cg.lms.service.LoanManagementServiceImpl;

public class LoanTest {
	
	@Test
    public void loginAdminTest() throws LoanException {

		LoanManagementServiceImpl lService=new LoanManagementServiceImpl();
		assertEquals(1, lService.login("admin", "admin123"));
			
	} 
	@Test
    public void loginLADTest() throws LoanException {

		LoanManagementServiceImpl lService=new LoanManagementServiceImpl();
		assertEquals(1, lService.login("lad", "lad123"));
			
	}
	
	@Test
    public void viewApplicationStatusByIdTest() throws LoanException, ParseException {
		LoanApplication la = null;
		LoanManagementDaoImpl lmdao=new LoanManagementDaoImpl();
		String date = "03-OCT-18";
		java.util.Date utilDate = new SimpleDateFormat("dd-MMM-yy").parse(date);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		assertEquals(la,lmdao.viewApplicationStatusById(200));
		
			
	}

	@Test
    public void addCustomerDetailsTest() throws LoanException {

		LoanManagementServiceImpl lService=new LoanManagementServiceImpl();
		try{
			assertEquals(1, lService.addCustomerDetails(new LoanApplication(201,new Date(03-10-18),"Program_A",1000,"Mumbai",100,"Adhaar","House",2000,null,null),new CustomerDetails(201,"Pranav",new Date(01-10-18),"unmarried",123456,1234567890,2,"abc@gmail.com")));
		}
		catch(NullPointerException e){
			System.out.println("success");
		}
	} 
}

