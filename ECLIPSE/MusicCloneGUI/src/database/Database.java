package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private Connection connection;
	private static Database connectorInstance;
	
	private Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/music_db", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Database GetConnectionInstance() {
		if (connectorInstance == null) {
			connectorInstance = new Database();
		}
		
		return connectorInstance;
	}
	
	public Connection GetConnection() {
		return this.connection;
	}
}
