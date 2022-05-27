package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This is the sql connection singleton class,
public class Connect implements DBCredentials{
	// instance of the sql connection 
	private static Connection connect = null;
	
	// private object
	private static Connect connectionInstance = new Connect();
	
	// private constructor
	private Connect() {
		try {
			Class.forName(Driver).newInstance();
			connect = DriverManager.getConnection(DBConnectionString, DBUsername, DBPassword);
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
