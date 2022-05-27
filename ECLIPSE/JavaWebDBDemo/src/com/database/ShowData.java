package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.models.Record;

public class ShowData {
	private Connection connect;
	private ArrayList<Record> recordModelList;
	
	public ShowData() {
		connect = Connect.getConnectionInstance().getConnection();
		recordModelList = new ArrayList<Record>();
	}
	
	public ArrayList<Record> GetAllData() throws SQLException {
		String query = "SELECT * FROM GIRLS;";
		// preparing the statement
		Statement stmt = this.connect.createStatement();
		// executing the result set
		ResultSet rs = stmt.executeQuery(query);
		
		// iterate thorugh each row(record)
		while(rs.next()) {
			Record record = new Record();
			record.setID(rs.getInt("ID"));
			record.setName(rs.getString("NAME"));
			record.setAge(rs.getInt("AGE"));
			record.setLoveStatus(rs.getInt("LOVE_STATUS"));
			record.setImageLink(rs.getString("IMG_LINK"));
			record.setCountry(rs.getString("COUNTRY"));
			
			// add the model to the list 
			recordModelList.add(record);
		}
		
		return this.recordModelList;
	}
}
