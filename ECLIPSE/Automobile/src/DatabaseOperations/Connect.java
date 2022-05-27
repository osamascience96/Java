package DatabaseOperations;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	// private connection instance to the database
	private static Connection conn = null;
	// private object
	private static Connect connectionInstance = new Connect();
	
	// private constructor
	private Connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:autodb.db");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getClass().getName() + ": "+ e.getMessage());
			System.exit(0);
		}
	}
	
	// function that returns the private instance of the connection object
	public static Connect getConnectionInstance() {
		return connectionInstance;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
