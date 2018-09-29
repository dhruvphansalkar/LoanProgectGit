package com.cg.lms.bean;

public class LoanProgramsOffered {
	String ProgramName;
	String description; 
	String type;
	int durationinyears;
	int minloanamount;
	int maxloanamount;
	int rateofinterest;
	String proofs_required;
	public String getProgramName() {
		return ProgramName;
	}
	public void setProgramName(String programName) {
		ProgramName = programName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDurationinyears() {
		return durationinyears;
	}
	public void setDurationinyears(int durationinyears) {
		this.durationinyears = durationinyears;
	}
	public int getMinloanamount() {
		return minloanamount;
	}
	public void setMinloanamount(int minloanamount) {
		this.minloanamount = minloanamount;
	}
	public int getMaxloanamount() {
		return maxloanamount;
	}
	public void setMaxloanamount(int maxloanamount) {
		this.maxloanamount = maxloanamount;
	}
	public int getRateofinterest() {
		return rateofinterest;
	}
	public void setRateofinterest(int rateofinterest) {
		this.rateofinterest = rateofinterest;
	}
	public String getProofs_required() {
		return proofs_required;
	}
	public void setProofs_required(String proofs_required) {
		this.proofs_required = proofs_required;
	}
	public LoanProgramsOffered(String programName, String description,
			String type, int durationinyears, int minloanamount,
			int maxloanamount, int rateofinterest, String proofs_required) {
		super();
		ProgramName = programName;
		this.description = description;
		this.type = type;
		this.durationinyears = durationinyears;
		this.minloanamount = minloanamount;
		this.maxloanamount = maxloanamount;
		this.rateofinterest = rateofinterest;
		this.proofs_required = proofs_required;
	}
	public LoanProgramsOffered() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoanProgramsOffered [ProgramName=" + ProgramName
				+ ", description=" + description + ", type=" + type
				+ ", durationinyears=" + durationinyears + ", minloanamount="
				+ minloanamount + ", maxloanamount=" + maxloanamount
				+ ", rateofinterest=" + rateofinterest + ", proofs_required="
				+ proofs_required + "]";
	}
	
	
}
