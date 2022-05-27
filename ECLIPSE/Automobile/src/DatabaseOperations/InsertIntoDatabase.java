package DatabaseOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class InsertIntoDatabase {
	private Connection connection;
	private Statement insertStatment;
	// creating the constructor 
	public InsertIntoDatabase() {
		// creating the statement 
		try {
			connection = Connect.getConnectionInstance().getConnection();
			connection.setAutoCommit(false);
			insertStatment = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InsertOperation(String accidentDate, String cityName, String stateCode, String vehicleNo, double damages, String driverSSN) {
		try {
			int accident_id = 0;
			String sql1 = "Insert into accidents('accident_date', 'city', 'state') VALUES ('" + accidentDate + "', '" + cityName + "', '" + stateCode + "'); ";
			insertStatment.executeUpdate(sql1);
			connection.commit();
			String sql2 = "SELECT aid FROM accidents ORDER BY aid DESC LIMIT 1";
			ResultSet rs = insertStatment.executeQuery(sql2);
			while(rs.next()) {
				accident_id = rs.getInt("aid");
			}
			String sql3 = "Insert into involvements('aid', 'vin', 'damages', 'driver_ssn') VALUES (" + accident_id + ", '" + vehicleNo + "' ," + damages + ", '" + driverSSN + "')";
			insertStatment.executeUpdate(sql3);
			connection.commit();
			insertStatment.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
