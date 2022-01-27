/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helper.Connector;
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
    private Connection connector;

    public User() {
        this.connector = Connector.getConnectionInstance().getConnection();
    }
    
    public pojo.User GetUserbyEmailandPass(String email, String password){
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        
        pojo.User userObj = null;
        
        
        try {
            PreparedStatement pstmt = this.connector.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                pojo.Type typeObj = new pojo.Type();
                typeObj.setId(rs.getInt("type_id"));
                
                pojo.Gender genderObj = new pojo.Gender();
                genderObj.setId(rs.getInt("gender_id"));
                
                userObj = new pojo.User(rs.getInt("id"), rs.getString("name"), typeObj, rs.getString("image_addr"), genderObj, rs.getString("dob"), rs.getString("address"), rs.getString("email"), rs.getString("password"), rs.getString("phone"), rs.getString("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObj;
    }
    
    public pojo.User GetUserByEmail(String email){
        String query = "SELECT * FROM user WHERE email = ?";
        
        pojo.User userObj = null;
        
        try {
            PreparedStatement pstmt = this.connector.prepareStatement(query);
            pstmt.setString(1, email);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                pojo.Type typeObj = new pojo.Type();
                typeObj.setId(rs.getInt("type_id"));
                
                pojo.Gender genderObj = new pojo.Gender();
                genderObj.setId(rs.getInt("gender_id"));
                
                userObj = new pojo.User(rs.getInt("id"), rs.getString("name"), typeObj, rs.getString("image_addr"), genderObj, rs.getString("dob"), rs.getString("address"), rs.getString("email"), rs.getString("password"), rs.getString("phone"), rs.getString("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObj;
    }
    
    public int InsertbyEmailPass(pojo.User userobj){
        String query = "INSERT INTO user(name, type_id, gender_id, dob, address, email, password, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        int row = 0;
        
        try {
            PreparedStatement pstmt = this.connector.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, userobj.getName());
            pstmt.setInt(2, userobj.getType().getId());
            pstmt.setInt(3, userobj.getGender().getId());
            pstmt.setString(4, userobj.getDateOfBirth());
            pstmt.setString(5, userobj.getAddress());
            pstmt.setString(6, userobj.getEmail());
            pstmt.setString(7, userobj.getPassword());
            pstmt.setString(8, userobj.getPhone());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
}
