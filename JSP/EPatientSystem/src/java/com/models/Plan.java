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
public class Plan {
    private Connection connection;
    
    public Plan(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public boolean PlanExists(String date, int doctor_id){
        boolean plan_exists = false;
        String query = "SELECT * FROM plan WHERE doctor_id = ? AND avaiabledate = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, doctor_id);
            pstmt.setString(2, date);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                plan_exists = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Plan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plan_exists;
    }
    
    public int InsertPlan(com.pojo.Plan plan){
        int planId = 0;
        String query = "INSERT INTO plan(doctor_id, avaiabledate, fromtime, totime, apointments_count) VALUES(?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, plan.getDoctorId());
            pstmt.setString(2, plan.getAvailableDate());
            pstmt.setString(3, plan.getFromtime());
            pstmt.setString(4, plan.getTotime());
            pstmt.setInt(5, plan.getAppointmentsCount());
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                planId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Plan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return planId;
    }
}
