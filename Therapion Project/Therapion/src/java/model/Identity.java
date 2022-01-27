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
public class Identity {
    private Connection connection;

    public Identity() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public pojo.Identity GetIdentityById(int id){
        String query = "SELECT FROM identity WHERE id = ?";
        
        pojo.Identity identityObj = null;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                identityObj = new pojo.Identity(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Identity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return identityObj;
    }
    
    public pojo.Identity GetIdentityByName(String name){
        String query = "SELECT * FROM identity WHERE name = ?";
        
        pojo.Identity identityObj = null;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, name);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                identityObj = new pojo.Identity(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Identity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return identityObj;
    }
}
