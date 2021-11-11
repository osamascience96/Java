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
    
    public void InsertUser(Bean.User user) throws SQLException{
        String query = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPassword());
        pstmt.executeUpdate();
    }
    
    public Bean.User check_user_exists(Bean.User user) throws SQLException{
        Bean.User userObj = null;
        
        String query = "SELECT * FROM users WHERE username = ? OR email = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            userObj = new Bean.User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("created_at"));
        }
        
        return userObj;
    }
    
    public Bean.User Check_login(Bean.User user) throws SQLException{
        Bean.User userObj = null;
        
        String query = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPassword());
        
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            userObj = new Bean.User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("created_at"));
        }
        
        return userObj;
    }
}
