/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class User {
    private Connection connection;

    public User() {
        this.connection = Connector.GetConnectionInstance().GetSQLConnection();
    }
    
    public Pojo.User GetUserByusername(String username){
        String query = "SELECT * FROM users WHERE username = ?";
        
        Pojo.User userObj = null;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, username);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                userObj = new Pojo.User(rs.getString("username"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObj;
    }
    
    public Pojo.User GetUserByLogin(String username, String password){
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        Pojo.User userObj = null;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                userObj = new Pojo.User(rs.getString("username"), rs.getString("password"), rs.getString("firstname"), rs.getString("lastname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObj;
    }
    
    public boolean InsertUser(String username, String password, String firstname, String lastname){
        String query = "INSERT INTO users(username, password, firstname, lastname) VALUES(?, ?, ?, ?)";
        
        try {
            
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, firstname);
            pstmt.setString(4, lastname);
            
            return pstmt.executeUpdate() > 0 ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean UpdateUserFLName(String firstname, String lastname, String username, String password){
        String query = "UPDATE users SET firstname = ?, lastname = ? WHERE username = ? AND password = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            
            return pstmt.executeUpdate() > 0 ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}