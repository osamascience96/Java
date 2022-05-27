package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtility {
	private Connection conn = null;
	private static DBUtility dbUtility = null;
	
    private static final String Driver = "org.postgresql.Driver";
    private static final String ConnUrl = "jdbc:postgresql://localhost:5432/student";
    private static final String Username = "postgres";
    private static final String Password = "admin";

    // This is a constructor
    private DBUtility() {
        try {
            Class.forName(Driver);
            this.conn = DriverManager.getConnection(ConnUrl, Username, Password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // static function to get the single instance of the class
    public static DBUtility GetConnectorInstance() {
    	if(dbUtility == null) {
    		dbUtility = new DBUtility();
    	}
    	
    	return dbUtility;
    }
    
    public Connection GetConnection() {
    	return this.conn;
    }
}