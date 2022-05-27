package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Connector;

public class User {
	private Connection connection;
	
	public User() {
		this.connection = Connector.getConnectionInstance().getConnection();
	}
	
	public boolean CheckUserExistance(POJO.User user) throws SQLException {
		boolean is_user_Exists = false;
		
		String query = "SELECT * FROM users WHERE username = ?";
		
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, user.GetUsername());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			is_user_Exists = true;
		}
		
		return is_user_Exists;
	}
	
	public void InsertUser(POJO.User user) throws SQLException {
		String query = "INSERT INTO users(username, password) VALUES (?, ?)";
		
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, user.GetUsername());
		ps.setString(2, user.GetPassword());
		ps.executeUpdate();
	}
	
	public boolean ValidateUser(POJO.User user) throws SQLException {
		boolean is_validated = false;
		
		String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		
		PreparedStatement ps = this.connection.prepareStatement(query);
		ps.setString(1, user.GetUsername());
		ps.setString(2, user.GetPassword());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			is_validated = true;
		}
		
		return is_validated;
	}
}
