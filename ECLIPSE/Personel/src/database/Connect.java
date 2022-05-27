package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-connect-drivermanager.html

// SQL-Connection Singleton Class
/**
 * Erstellt die Verbindung zur Datenbank.
 * @author 
 * @version 1.0
 */
public class Connect implements DBCredentials{
	
	// Instanz der SQL-Connection
	private static Connection connect = null;
	
	// 
	private static Connect connectionInstance = new Connect();
	
	// DriverManager verwaltet den Aufbau v. Verbindungen
	/**
	 * Erstellt die Verbindung zur Datenbank.
	 * @param 
	 */
	private Connect() {
		try {
			//Dem DM angeben mit welchen JDBC-Treibern versucht werden soll, Verbindungen herzustellen -> Class.forName() auf das Interface, das java.sql.Driver implementiert.
			Class.forName(Driver);
			connect = DriverManager.getConnection(DBConnectionString, DBUsername, DBPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Gibt eine statische Verbindungsinstanz wieder.
	 * @param 
	 */
	public static Connect getConnectionInstance() {
		return connectionInstance;
	}
	
	/**
	 * Gibt die SQL-Instanz wieder.
	 * @param 
	 */
	public Connection getConnection() {
		return connect;
	}
}
