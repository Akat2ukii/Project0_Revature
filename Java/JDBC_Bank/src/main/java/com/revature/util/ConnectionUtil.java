package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	// do not ever!!!! hardcode credentials like this
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@projectzero.cf1xjil2bepa.us-east-2.rds.amazonaws.com:1521:orcl"; 
		String username = "admin"; 
		String pass = "p4ssw0rd"; 
		return DriverManager.getConnection(url, username, pass);
		
	}
	
	
	public static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("pass"));
	}
	
	

}
