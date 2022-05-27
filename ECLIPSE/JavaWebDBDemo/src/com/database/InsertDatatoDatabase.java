package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDatatoDatabase {
	private Connection connect;
	
	public InsertDatatoDatabase() {
		connect = Connect.getConnectionInstance().getConnection();
	}
	
	public boolean InsertData(String name, String age, String love_status, String img_link, String country) throws SQLException {
		String query = "INSERT INTO GIRLS(NAME, AGE, LOVE_STATUS, IMG_LINK, COUNTRY) VALUES('".concat(name).concat("', ").concat(age).concat(", ").concat(love_status).concat(", '").concat(img_link).concat("', '").concat(country).concat("');");
		Statement stmt = this.connect.createStatement();
		stmt.executeUpdate(query);
		return true;
	}
}
