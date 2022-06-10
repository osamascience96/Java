/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db.Confs;
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
public class User extends Confs{
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
        String query = "INSERT INTO [user].users(username, firstname, lastname, email, password) VALUES (?, ?, ?, ?, ?)".replace("[user]", User);
        
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
        String query = "SELECT * FROM [user].users WHERE email = ? AND password = ?".replace("[user]", User);
        
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String CreatedAt) {
        this.CreatedAt = CreatedAt;
    }
    
    
}
