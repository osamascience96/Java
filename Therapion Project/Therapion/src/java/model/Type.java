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
public class Type {
    private Connection connection;

    public Type() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public pojo.Type GetTypeById(int id){
        String query = "SELECT * FROM type WHERE id = ?";
        
        pojo.Type typeObj = null;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                typeObj = new pojo.Type(rs.getInt("id"), rs.getString("user_type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Type.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return typeObj;
    }
    
    public pojo.Type GetTypeByType(String name){
        String query = "SELECT * FROM type WHERE user_type = ?";
        
        pojo.Type typeObj = null;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, name);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                typeObj = new pojo.Type(rs.getInt("id"), rs.getString("user_type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Type.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return typeObj;
    }
}
