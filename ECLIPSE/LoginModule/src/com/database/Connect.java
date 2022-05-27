package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	// instance of the sql connection 
	private static Connection connect = null;
	
	// private object
	private static Connect connectionInstance = new Connect();
	
	// private constructor
	private Connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\osama\\eclipse-workspace\\LoginModule\\person.db");
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
