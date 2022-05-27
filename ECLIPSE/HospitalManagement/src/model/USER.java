package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.User;
import database.Connect;

public class USER {
	private Connection connection;
	
	public USER() {
		this.connection = Connect.getConnectionInstance().getConnection();
	}
	
	public boolean CheckUserExistance(bean.User user) throws SQLException {
		boolean userexists = false;
		
		String query = "SELECT * FROM users WHERE username = ? OR email = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getEmail());
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			userexists = true;
		}
		
		return userexists;
	}
	
	public User GetUserExistance(User user) throws SQLException {
		User userobj = null;
		
		String query = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getPassword());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			userobj = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("usertype"), rs.getString("created_at"));
		}
		
		return userobj;
	}
	
	public int InsertUser(bean.User user) throws SQLException {
		int generatedId = 0;
		
		String query = "INSERT INTO users(username, email, password, usertype) VALUES(?, ?, ?, ?)";
		
		PreparedStatement pstmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getUsertype());
		pstmt.executeUpdate();
		
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next()) {
			generatedId = rs.getInt(1);
		}
		
		return generatedId;
	}
	
	
}
