package com.hexaware.view;

import java.util.Scanner;

import com.hexaware.controller.JobController;
import com.hexaware.controller.JobInterface;

public class CareerHubMain {
	public static void main(String args[]) {
		JobInterface jc = new JobController();
		try (Scanner sc = new Scanner(System.in)) {
			String c = null;
			do {
				System.out.println("1.Add JobListing");
				System.out.println("2.Add Company");
				System.out.println("3.Add Applicant");
				System.out.println("4.Add JobApplication");
				System.out.println("5.Retrieve Job");
				System.out.println("6.Retrieve Company");
				System.out.println("7.Retrieve Applicant");
				System.out.println("8.Retrieve JobApplication");
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					jc.addJobListing();
					break;
				}
				case 2: {
					jc.addCompany();
					break;
				}
				case 3: {
					jc.addApplicant();
					break;
				}
				case 4: {
					jc.addJobApplication();
					break;
				}
				case 5: {
			         jc.retrieveJobListing();
			         break;
				}
				case 6: {
			          jc.retrieveCompany();
			          break;
				}
				case 7: {
			          jc.retrieveApplicant();
			          break;
				}
				case 8: {
			          jc.retrieveJobApplication();
			          break;
				}
				default: {
					System.out.println("Enter the Correct choice. ");
				}
				}
				System.out.println("Do you want to continue? Yes or yes");
				c = sc.next();
			} while (c.equals("Yes") || c.equals("yes"));
		}
		System.out.println("Thank You !!!");
		System.exit(0);

	}

}
