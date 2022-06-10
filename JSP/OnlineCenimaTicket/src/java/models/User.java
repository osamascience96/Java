/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db.Connector;
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
    // member variables
    public int id;
    public String firstname;
    public String lastname;
    public String username;
    public String email;
    public String Password;
    public String CreatedAt;
    
    // sql connection
    private final Connection connection;

    public User() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public boolean InsertUser(){
        boolean IsUserInserted = false;
        String query = "INSERT INTO APP.users(username, firstname, lastname, email, password) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, this.username);
            pstmt.setString(2, this.firstname);
            pstmt.setString(3, this.lastname);
            pstmt.setString(4, this.email);
            pstmt.setString(5, this.Password);
            
            IsUserInserted = pstmt.executeUpdate() > 0 ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return IsUserInserted;
    }
    
    public User SelectByEmailPass(){
        String query = "SELECT * FROM APP.users WHERE email = ? AND password = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, this.email);
            pstmt.setString(2, this.Password);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                this.id = rs.getInt("id");
                this.firstname = rs.getString("firstname");
                this.lastname = rs.getString("lastname");
                this.username = rs.getString("username");
                this.email = rs.getString("email");
                this.CreatedAt = rs.getString("created_at");
                
                return this;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
