/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author osama
 */
public class User {
    private Connection connection;
    
    public User(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public boolean CheckUserExistance(POJO.User user) throws SQLException{
        boolean is_user_exists = false;
        
        String query = "SELECT * FROM users WHERE email = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getEmail());
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            is_user_exists = true;
        }
        
        return is_user_exists;
    }
    
    public POJO.User CheckUserbyCredentials(POJO.User user) throws SQLException{
        POJO.User userObj = null;
        
        String query = "SELECT * FROM `users` WHERE (email = ? OR username = ?) AND password = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getEmail());
        pstmt.setString(2, user.getUsername());
        pstmt.setString(3, user.getPassword());
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            userObj = new POJO.User(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("created_at"));
        }
        
        return userObj;
    }
    
    public void InsertUser(POJO.User user) throws SQLException{
        String query = "INSERT INTO users(fullname, username, email, password) VALUES(?, ?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getFullname());
        pstmt.setString(2, user.getUsername());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getPassword());
        
        pstmt.executeUpdate();
    }
}
