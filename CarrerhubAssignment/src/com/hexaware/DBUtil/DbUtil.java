package com.hexaware.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	static Connection con;

	public static Connection getDBConn() {

		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/career hub assessment", "root", "");
		} catch (SQLException e) {
	
			e.printStackTrace();
		}

		return con;
	}

	public static void main(String[] args) {
		System.out.println(getDBConn());
	}
}