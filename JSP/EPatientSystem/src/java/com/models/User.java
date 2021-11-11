/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class User {
    private Connection connection;

    public User() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public com.pojo.User GetUserById(int id){
        com.pojo.User userObj = null;
        String query = "SELECT * FROM users WHERE id = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                userObj = new com.pojo.User(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"), rs.getString("email"), rs.getString("phone"), rs.getString("password"), rs.getString("profession"), rs.getString("role"), rs.getString("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObj;
    }
    
    public com.pojo.User GetUser(String username){
        com.pojo.User userobj = null;
        String query = "SELECT * FROM users Where username = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                userobj = new com.pojo.User(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"), rs.getString("email"), rs.getString("phone"), rs.getString("password"), rs.getString("profession"), rs.getString("role"), rs.getString("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userobj;
    }
    
    public int InsertUser(com.pojo.User user){
        int id = 0;
        String query = "INSERt INTO users(fullname, username, email, phone, password, profession, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getFullname());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhone());
            pstmt.setString(5, user.getPassword());
            pstmt.setString(6, user.getProfession());
            pstmt.setString(7, user.getRole());
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if(rs.next()){
                id = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
}
