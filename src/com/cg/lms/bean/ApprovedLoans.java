package com.cg.lms.bean;

public class ApprovedLoans {

	int Application_Id;
	String Customer_name;
	int amountofloangranted;
	int monthlyinstallment;
	int yearstimeperiod;
	int downpayment;
	int rateofinterest;
	int totalamountpayable;
	public int getApplication_Id() {
		return Application_Id;
	}
	public void setApplication_Id(int application_Id) {
		Application_Id = application_Id;
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public int getAmountofloangranted() {
		return amountofloangranted;
	}
	public void setAmountofloangranted(int amountofloangranted) {
		this.amountofloangranted = amountofloangranted;
	}
	public int getMonthlyinstallment() {
		return monthlyinstallment;
	}
	public void setMonthlyinstallment(int monthlyinstallment) {
		this.monthlyinstallment = monthlyinstallment;
	}
	public int getYearstimeperiod() {
		return yearstimeperiod;
	}
	public void setYearstimeperiod(int yearstimeperiod) {
		this.yearstimeperiod = yearstimeperiod;
	}
	public int getDownpayment() {
		return downpayment;
	}
	public void setDownpayment(int downpayment) {
		this.downpayment = downpayment;
	}
	public int getRateofinterest() {
		return rateofinterest;
	}
	public void setRateofinterest(int rateofinterest) {
		this.rateofinterest = rateofinterest;
	}
	public int getTotalamountpayable() {
		return totalamountpayable;
	}
	public void setTotalamountpayable(int totalamountpayable) {
		this.totalamountpayable = totalamountpayable;
	}
	@Override
	public String toString() {
		return "ApprovedLoans [Application_Id=" + Application_Id
				+ ", Customer_name=" + Customer_name + ", amountofloangranted="
				+ amountofloangranted + ", monthlyinstallment="
				+ monthlyinstallment + ", yearstimeperiod=" + yearstimeperiod
				+ ", downpayment=" + downpayment + ", rateofinterest="
				+ rateofinterest + ", totalamountpayable=" + totalamountpayable
				+ "]";
	}
	public ApprovedLoans(int application_Id, String customer_name,
			int amountofloangranted, int monthlyinstallment,
			int yearstimeperiod, int downpayment, int rateofinterest,
			int totalamountpayable) {
		super();
		Application_Id = application_Id;
		Customer_name = customer_name;
		this.amountofloangranted = amountofloangranted;
		this.monthlyinstallment = monthlyinstallment;
		this.yearstimeperiod = yearstimeperiod;
		this.downpayment = downpayment;
		this.rateofinterest = rateofinterest;
		this.totalamountpayable = totalamountpayable;
	}
	public ApprovedLoans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
