package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hexaware.DBUtil.DbUtil;
import com.hexaware.model.JobListing;
import com.hexaware.DBUtil;


public class JobDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	public void createJobListing(JobListing jl) {
		try {
			con=DbUtil.getDBConn();
			ps=con.prepareStatement("insert into jobs(jobid,companyid,jobtitle,jobdesc,joblocation,salary,jobtype,posteddate) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, jl.getJobID());
			ps.setInt(2, jl.getCompanyID());		
			ps.setString(3, jl.getJobTitle());
			ps.setString(4,jl.getJobDescription());
			ps.setString(5,jl.getJobLocation());
			ps.setDouble(6,jl.getSalary());
			ps.setString(5,jl.getJobType());
			ps.setObject(5,jl.getPostedDate());
			
			int noofrows =ps.executeUpdate();
			System.out.println(noofrows+ " inserted successfully in DB");
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	public void deleteJobListing(int joblistingId) {
	    con = DBUtil.getDBConn();
	    try {
	        ps = con.prepareStatement("delete from students where studentID=?");
	        ps.setInt(1, joblistingId);
	        int rows = ps.executeUpdate();
	        if (rows>0) {
	            System.out.println("Jobs deleted successfully...");
	        } else {
	            System.out.println("No jobs Found ...");
	        }
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	}

	public void showJobListing() {
		con = DBUtil.getDBConn();
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from student");
				
			while(rs.next()) {
				System.out.println("JobListing ID : " + rs.getInt(1));
				System.out.println("Company ID : " + rs.getInt(2));
				System.out.println("JobTitle  : " + rs.getString(3));
				System.out.println("JobDescription : " + rs.getString(4));
				System.out.println("Salary: " + rs.getDouble(5));
				System.out.println("JobLocation : " + rs.getString(6));
				System.out.println("JobTypr : " + rs.getString(7));
				System.out.println("PostedDate : " + rs.getObject(8));


				

				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
}


