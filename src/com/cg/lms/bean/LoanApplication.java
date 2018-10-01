package com.cg.lms.bean;



import java.util.Date; //sql option is also present

public class LoanApplication {
	int Application_Id;         	//sequence_app_id  SEQUENCE.NEXTvAL
	Date application_date;      	//rEMOVE    
	String Loan_program;			//program name in loan programs offered class from table
	int AmountofLoan;				//user
	String AddressofProperty;  	 	//user
	int AnnualFamilyIncome;     	//user
	String DocumentProofsAvailable;     //user
	String GuaranteeCover;				//user
	int MarketValueofGuaranteeCover;	//user
	String Status;					//REMOVE	
	Date DateOfInterview;			//REMOVE				
	public int getApplication_Id() {
		return Application_Id;
	}
	public void setApplication_Id(int application_Id) {
		Application_Id = application_Id;
	}
	public Date getApplication_date() {
		return application_date;
	}
	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}
	public String getLoan_program() {
		return Loan_program;
	}
	public void setLoan_program(String loan_program) {
		Loan_program = loan_program;
	}
	public int getAmountofLoan() {
		return AmountofLoan;
	}
	public void setAmountofLoan(int amountofLoan) {
		AmountofLoan = amountofLoan;
	}
	public String getAddressofProperty() {
		return AddressofProperty;
	}
	public void setAddressofProperty(String addressofProperty) {
		AddressofProperty = addressofProperty;
	}
	public int getAnnualFamilyIncome() {
		return AnnualFamilyIncome;
	}
	public void setAnnualFamilyIncome(int annualFamilyIncome) {
		AnnualFamilyIncome = annualFamilyIncome;
	}
	public String getDocumentProofsAvailable() {
		return DocumentProofsAvailable;
	}
	public void setDocumentProofsAvailable(String documentProofsAvailable) {
		DocumentProofsAvailable = documentProofsAvailable;
	}
	public String getGuaranteeCover() {
		return GuaranteeCover;
	}
	public void setGuaranteeCover(String guaranteeCover) {
		GuaranteeCover = guaranteeCover;
	}
	public int getMarketValueofGuaranteeCover() {
		return MarketValueofGuaranteeCover;
	}
	public void setMarketValueofGuaranteeCover(int marketValueofGuaranteeCover) {
		MarketValueofGuaranteeCover = marketValueofGuaranteeCover;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getDateOfInterview() {
		return DateOfInterview;
	}
	public void setDateOfInterview(Date dateOfInterview) {
		DateOfInterview = dateOfInterview;
	}
	public LoanApplication(int application_Id, Date application_date,
			String loan_program, int amountofLoan, String addressofProperty,
			int annualFamilyIncome, String documentProofsAvailable,
			String guaranteeCover, int marketValueofGuaranteeCover,
			String status, Date dateOfInterview) {
		super();
		Application_Id = application_Id;
		this.application_date = application_date;
		Loan_program = loan_program;
		AmountofLoan = amountofLoan;
		AddressofProperty = addressofProperty;
		AnnualFamilyIncome = annualFamilyIncome;
		DocumentProofsAvailable = documentProofsAvailable;
		GuaranteeCover = guaranteeCover;
		MarketValueofGuaranteeCover = marketValueofGuaranteeCover;
		Status = status;
		DateOfInterview = dateOfInterview;
	}
	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoanApplication [Application_Id=" + Application_Id
				+ ", application_date=" + application_date + ", Loan_program="
				+ Loan_program + ", AmountofLoan=" + AmountofLoan
				+ ", AddressofProperty=" + AddressofProperty
				+ ", AnnualFamilyIncome=" + AnnualFamilyIncome
				+ ", DocumentProofsAvailable=" + DocumentProofsAvailable
				+ ", GuaranteeCover=" + GuaranteeCover
				+ ", MarketValueofGuaranteeCover="
				+ MarketValueofGuaranteeCover + ", Status=" + Status
				+ ", DateOfInterview=" + DateOfInterview + "]";
	}
	
	
}
