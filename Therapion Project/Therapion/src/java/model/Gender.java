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
public class Gender {
    private Connection connection;

    public Gender() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public pojo.Gender GetGenderById(int id){
        String query = "SELECT * FROM gender WHERE id = ?";
        
        pojo.Gender genderObj = null;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                genderObj = new pojo.Gender(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return genderObj;
    }
    
    public pojo.Gender GetGenderByName(String name){
        String query = "SELECT * FROM gender WHERE name = ?";
        
        pojo.Gender genderObj = null;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, name);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                genderObj = new pojo.Gender(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return genderObj;
    }
}
