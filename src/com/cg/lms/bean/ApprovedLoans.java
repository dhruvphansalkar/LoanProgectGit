package com.cg.lms.bean;

public class ApprovedLoans {

	int Application_Id;
	String Customer_name;
	double amountofloangranted;
	double monthlyinstallment;
	int yearstimeperiod;
	double downpayment;
	double rateofinterest;
	double totalamountpayable;
	
	
	
	
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

	public double getAmountofloangranted() {
		return amountofloangranted;
	}

	public void setAmountofloangranted(double amountofloangranted) {
		this.amountofloangranted = amountofloangranted;
	}

	public double getMonthlyinstallment() {
		return monthlyinstallment;
	}

	public void setMonthlyinstallment(double monthlyinstallment) {
		this.monthlyinstallment = monthlyinstallment;
	}

	public int getYearstimeperiod() {
		return yearstimeperiod;
	}

	public void setYearstimeperiod(int yearstimeperiod) {
		this.yearstimeperiod = yearstimeperiod;
	}

	public double getDownpayment() {
		return downpayment;
	}

	public void setDownpayment(double downpayment) {
		this.downpayment = downpayment;
	}

	public double getRateofinterest() {
		return rateofinterest;
	}

	public void setRateofinterest(double rateofinterest) {
		this.rateofinterest = rateofinterest;
	}

	public double getTotalamountpayable() {
		return totalamountpayable;
	}

	public void setTotalamountpayable(double totalamountpayable) {
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
			double amountofloangranted, double monthlyinstallment,
			int yearstimeperiod, double downpayment, double rateofinterest,
			double totalamountpayable) {
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
