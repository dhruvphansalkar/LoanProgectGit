package com.cg.lms.bean;



import java.sql.Date;
import java.sql.Timestamp;
 //sql option is also present

public class LoanApplication {

				//REMOVE				

	int Application_Id;
	Date application_date;
	String Loan_program;
	int AmountofLoan;
	String AddressofProperty;
	int AnnualFamilyIncome;
	String DocumentProofsAvailable;
	String GuaranteeCover;
	int MarketValueofGuaranteeCover;
	String Status;
	Date DateOfInterview;

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
	public LoanApplication(int application_Id, Date date,
			String loan_program, int amountofLoan, String addressofProperty,
			int annualFamilyIncome, String documentProofsAvailable,
			String guaranteeCover, int marketValueofGuaranteeCover,
			String status, Date date2) {
		super();
		Application_Id = application_Id;
		this.application_date = date;
		Loan_program = loan_program;
		AmountofLoan = amountofLoan;
		AddressofProperty = addressofProperty;
		AnnualFamilyIncome = annualFamilyIncome;
		DocumentProofsAvailable = documentProofsAvailable;
		GuaranteeCover = guaranteeCover;
		MarketValueofGuaranteeCover = marketValueofGuaranteeCover;
		Status = status;
		DateOfInterview = date2;
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
