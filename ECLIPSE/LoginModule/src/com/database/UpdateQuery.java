package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Model.User;

public class UpdateQuery {
	private Connect conn;
	
	public UpdateQuery() {
		this.conn = Connect.getConnectionInstance();
	}
	
	public int RegisterUserDB(String name, String username, String password) throws SQLException {
		String query = "INSERT INTO User('NAME', 'USERNAME', 'PASSWORD') VALUES ('" + name + "', '" + username + "', '" + password + "');";
		// preparing the statment 
		Statement stmt = this.conn.getConnection().createStatement();
		// get the result set 
		return stmt.executeUpdate(query);
	}
}
