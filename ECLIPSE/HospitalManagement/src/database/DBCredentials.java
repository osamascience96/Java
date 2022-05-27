package database;

// interface to store all the credentails of the db
public interface DBCredentials {
	String DBConnectionString = "jdbc:mysql://localhost:3306/hospitalmanagement";
	String DBUsername = "root";
	String DBPassword = "";
	String Driver = "com.mysql.cj.jdbc.Driver";
}
