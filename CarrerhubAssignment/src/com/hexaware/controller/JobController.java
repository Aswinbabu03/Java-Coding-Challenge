package com.hexaware.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hexaware.model.Applicant;
import com.hexaware.model.Company;
import com.hexaware.model.JobListing;
import com.hexaware.model.JobApplication;

public class JobController implements JobInterface {
    JobListing joblisting;
    Company company;
    Applicant applicant;
    JobApplication jobApplication;
    List<JobListing> jobList=new ArrayList<>();
    List<Company> companyList=new ArrayList<>();
    List<Applicant> applicantList=new ArrayList<>();
    List<JobApplication> jobApplicationList=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public void addJob() {
		// TODO Auto-generated method stub
		joblisting=new JobListing();
		System.out.println("Enter the Job Id: ");
		int jobID=sc.nextInt();
		joblisting.setJobID(jobID);
		System.out.println("Enter the Company Id: ");
		int companyID=sc.nextInt();
		joblisting.setCompanyID(companyID);
		System.out.println("Enter the Job Title: ");
		String jobTitle=sc.next();
		joblisting.setJobTitle(jobTitle);
        System.out.println("Enter the Job Description: ");
        String jobDescription =sc.next();
        joblisting.setJobDescription(jobDescription);
        System.out.println("Enter the Job Location: ");
        String jobLocation=sc.next();
        joblisting.setJobLocation(jobLocation);
        System.out.println("Enter the salary: ");
        double salary=sc.nextDouble();
        joblisting.setSalary(salary);
        System.out.println("Enter the Job Type: ");
        String jobType=sc.next();
        joblisting.setJobType(jobType);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    sc.nextLine();
        System.out.println("Enter the postedDate  (yyyy-MM-dd): ");
        String dateInput=sc.nextLine();
        LocalDate postedDate = LocalDate.parse(dateInput, dateFormatter);
        joblisting.setPostedDate(postedDate);
        jobList.add(joblisting);
        System.out.println("Job "+joblisting.getJobID()+" "+"sucessfully added");
		
    }
    public void addCompany() {
		// TODO Auto-generated method stub
		company=new Company();
		System.out.println("Enter the Company Id: ");
		int companyID=sc.nextInt();
		company.setCompanyID(companyID);
		System.out.println("Enter the Company Name: ");
		String companyName=sc.next();
		company.setCompanyName(companyName);
		sc.nextLine();
		System.out.println("Enter the Location: ");
		String location=sc.nextLine();
		company.setLocation(location);
		companyList.add(company);
		 System.out.println("Job "+company.getCompanyID()+" "+"sucessfully added");
			
	}
    public void addApplicant() {
    	// TODO Auto-generated method stub
    	applicant=new Applicant();
    	System.out.println("Enter the Applicant ID:");
    	int applicantID=sc.nextInt();    
    	applicant.setApplicantID(applicantID);
    	System.out.println("Enter Applicant's firstName: ");
    	String firstName=sc.next();
    	applicant.setFirstName(firstName);
    	sc.nextLine();
    	System.out.println("Enter Applicant's lastName: ");
    	String lastName=sc.next();
    	applicant.setLastName(lastName);
    	sc.nextLine();
    	System.out.println("Enter Applicant's email: ");
    	String email=sc.next();
    	applicant.setEmail(email);
    	sc.nextLine();
    	System.out.println("Enter Applicant's phoneNumber: ");
    	String phone=sc.next();
    	applicant.setPhone(phone);
    	sc.nextLine();
    	System.out.println("Enter Applicant's email:");
    	String resume=sc.next();
    	applicant.setResume(resume);
    	applicantList.add(applicant);
    	System.out.println("Job "+applicant.getApplicantID()+" "+"successfully added");
    	}
    public void addJobApplication() {
    	jobApplication =new JobApplication();
    	System.out.println("Enter the Application ID:");
    	int jobapplicationID=sc.nextInt();    
    	jobApplication.setApplicationID(jobapplicationID);
    	System.out.println("Enter the Job Id: ");
		int jobID=sc.nextInt();
		joblisting.setJobID(jobID);
		sc.nextLine();
		System.out.println("Enter the Applicant ID:");
    	int applicantID=sc.nextInt();    
    	applicant.setApplicantID(applicantID);
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    sc.nextLine();
    	System.out.println("Enter the APplicationDate  (yyyy-MM-dd): ");
        String dateInput=sc.nextLine();
        LocalDate applicationDate = LocalDate.parse(dateInput, dateFormatter);
    	jobApplication.setApplicationDate(applicationDate);
    	sc.nextLine();
    	System.out.println("Enter the application coverletter: ");
    	String coverLetter=sc.next();
    	jobApplication.setCoverLetter(coverLetter);
    	jobApplicationList.add(jobApplication);
    	System.out.println("Job "+jobApplication.getApplicationID()+" "+"successfully added");
    }
	@Override
	public void addJobListing() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void retrieveJobListing() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void retrieveCompany() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void retrieveApplicant() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void retrieveJobApplication() {
		// TODO Auto-generated method stub
		
	}
}