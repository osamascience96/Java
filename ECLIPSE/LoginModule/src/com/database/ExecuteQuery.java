package com.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Model.User;

public class ExecuteQuery {
	private Connect conn;
	private ArrayList<User> userArrayList;
	
	public ExecuteQuery() {
		this.conn = Connect.getConnectionInstance();
		this.userArrayList = new ArrayList<User>();
	}
	
	public ArrayList<User> GetUserResultSet(String username) throws SQLException{
		String query = "SELECT * FROM User WHERE USERNAME = '" + username + "';";
		// preparing the statement 
		Statement stmt = this.conn.getConnection().createStatement();
		// get the result set 
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			this.userArrayList.add(new User(rs.getInt("ID"), rs.getString("NAME"), rs.getString("USERNAME"), rs.getString("PASSWORD")));
		}
		
		return this.userArrayList;
	}
	
	public ArrayList<User> GetLoginUserResultSet(String username, String password) throws SQLException{
		String query = "SELECT * FROM User WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "';";
		// preparing the statement 
		Statement stmt = this.conn.getConnection().createStatement();
		// get the result set of the fetched data 
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			this.userArrayList.add(new User(rs.getInt("ID"), rs.getString("NAME"), rs.getString("USERNAME"), rs.getString("PASSWORD")));
		}
		
		return this.userArrayList;
	}
}
