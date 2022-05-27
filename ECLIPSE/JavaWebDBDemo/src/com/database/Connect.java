package com.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	// private instance of the connectino 
	private static Connection conn = null;
	// private object of the class
	private static Connect connectionObj = null;
	
	// private constructor 
	private Connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\osama\\eclipse-workspace\\JavaWebDBDemo\\myfavgirls.db");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	// function that returns the instance of the connection 
	public static Connect getConnectionInstance() {
		if (connectionObj == null) {
			connectionObj = new Connect();
		}
		
		return connectionObj;
	}
	
	// function that returns the connection instnace 
	public Connection getConnection() {
		return conn;
	}
}
