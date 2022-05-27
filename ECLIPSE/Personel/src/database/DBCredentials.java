package database;

// Interface, um alle Anmeldedaten der DB zu speichern
/**
 * Besitzt die URL, den Benutzernamen, das Psswort und den Driver, die für die Verbindung zur Datenbank erforderlich sind.
 * @author 
 * @version 1.0
 */
public interface DBCredentials {
	String DBConnectionString = "jdbc:mysql://localhost:3306/personnelmanagement";
	String DBUsername = "root";
	String DBPassword = "";
	String Driver = "com.mysql.cj.jdbc.Driver";
}

//https://www.javatpoint.com/example-to-connect-to-the-mysql-database