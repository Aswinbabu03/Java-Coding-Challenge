package com.hexaware.model;

import java.time.LocalDate;

public class JobApplication {
	private int applicationID;
	private int jobID;
	private int  applicantID;
	private LocalDate applicationDate;
	private String coverLetter;
	
	public JobApplication() {
		System.out.println("From JobApplication Constructor...");
	}
	public JobApplication(int applicationID,int jobID,int applicantID,LocalDate applicationDate,String coverLetter) {
		super();
		this.applicationID=applicationID;
		this.jobID=jobID;
		this.applicantID=applicantID;
		this.applicationDate=applicationDate;
		this.coverLetter=coverLetter;
	}
	public int getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public int getApplicantID() {
		return applicantID;
	}
	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}
	public LocalDate getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	@Override
	public String toString() {
		return "JobApplication [applicationID=" + applicationID + ", jobID=" + jobID + ", applicantID=" + applicantID
				+ ", applicationDate=" + applicationDate + ", coverLetter=" + coverLetter + "]";
	}
	
	

}
