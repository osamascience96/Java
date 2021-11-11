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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Doctor {
    private Connection connection;

    public Doctor() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<com.pojo.User> GetDoctorList(){
        ArrayList<com.pojo.User> userObjList = new ArrayList<com.pojo.User>();
        String query = "SELECT * FROM `users` WHERE role = 'doctor'";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                userObjList.add(new com.pojo.User(rs.getInt("id"), rs.getString("fullname"), rs.getString("username"), rs.getString("email"), rs.getString("phone"), rs.getString("password"), rs.getString("profession"), rs.getString("role"), rs.getString("created_at")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObjList;
    }
    
    public void DeleteDoctor(int id){
        String query = "DELETE FROM `users` WHERE id = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
