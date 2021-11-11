/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public EJB.User GetUserExists(EJB.User user){
        EJB.User userObj = null;
        
        String query = "SELECT * FROM users WHERE email = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, user.getEmail());
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                userObj = new EJB.User(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("type"), rs.getInt("approved"), rs.getString("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObj;
    }
    
    
    public EJB.User GetUserLogin(EJB.User user){
        
        EJB.User userObj = null;
        
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                userObj = new EJB.User(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("type"), rs.getInt("approved"), rs.getString("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObj;
    }
    
    public int InsertUser(EJB.User user){
        int is_inserted = 0;
        
        String query = "INSERT INTO users(name, username, email, password, type) VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getUsertype());
            is_inserted = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return is_inserted;
    }
    
    public ArrayList<EJB.User> GetAllUsersList(){
        ArrayList<EJB.User> arrayListUsers = new ArrayList<EJB.User>();
        
        String query = "SELECT * FROM users";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                arrayListUsers.add(new EJB.User(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("type"), rs.getInt("approved"), rs.getString("created_at")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListUsers;
    }
    
    
    public EJB.User GetUserById(int id){
        EJB.User userObj = null;
        
        String query = "SELECT * FROM users WHERE id = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                userObj = new EJB.User(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("type"), rs.getInt("approved"), rs.getString("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObj;
    }
    
    public int UpdateUser(EJB.User user){
        int is_used_updated = 0;
        
        String query = "UPDATE users SET name = ?, username = ?, email = ?, password = ? WHERE id = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setInt(5, user.getId());
            
            is_used_updated = pstmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return is_used_updated;
    }
    
    
    public int UpdateUserStatus(int userId, int status){
        int is_status_updated = 0;
        
        String query = "UPDATE users SET approved = ? WHERE id = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, status);
            pstmt.setInt(2, userId);
            is_status_updated = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return is_status_updated;
    }
}
