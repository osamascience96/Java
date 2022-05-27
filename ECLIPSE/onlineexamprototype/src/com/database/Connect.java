package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	// instance of the sql connection 
	private static Connection connect = null;
	
	private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String ConnUrl = "jdbc:mysql://localhost:3306/onlineexam";
    private static final String Username = "root";
    private static final String Password = "";
	
	// private object
	private static Connect connectionInstance = new Connect();
	
	// private constructor
	private Connect() {
		try {
			Class.forName(Driver);
			connect = DriverManager.getConnection(ConnUrl, Username, Password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// function that returns the static instance of the connection instance 
	public static Connect getConnectionInstance() {
		return connectionInstance;
	}
	
	// function that returns the sql instance connect
	public Connection getConnection() {
		return connect;
	}
}
