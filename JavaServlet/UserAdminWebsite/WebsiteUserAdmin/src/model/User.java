package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Connector;

public class User {
	private Connection connection;
	
	public User() {
		this.connection = Connector.getConnectionInstance().getConnection();
	}
	
	public ArrayList<pojo.User> GetallUsers(){
		ArrayList<pojo.User> users = new ArrayList<pojo.User>();
		
		String query = "SELECT * FROM users";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				users.add(new pojo.User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("type"), rs.getString("password"), rs.getString("created_at")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public pojo.User GetUserbyUserCred(String email, String password){
		String query = "SELECT * FROM users where email = ? AND password = ?";
		
		pojo.User userObj = null;
		
		PreparedStatement pstmt;
		try {
			pstmt = this.connection.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				userObj = new pojo.User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("type"), rs.getString("password"), rs.getString("created_at"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userObj;
	}
	
	
}
