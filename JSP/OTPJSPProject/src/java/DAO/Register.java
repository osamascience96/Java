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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Register {
    private Connection connection;

    public Register() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public EJB.Register CheckRegistration(String email){
        EJB.Register register = null;
        
        String query = "SELECT * FROM registrations WHERE EmailId = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                register = new EJB.Register(rs.getInt("RegistrationId"), rs.getInt("AssesseId"), rs.getString("EmailId"), rs.getString("BillNo"), rs.getString("RegisterdDateTime"), rs.getString("Remarks"), rs.getString("mobileno1"), rs.getString("mobileno2"), rs.getInt("otp"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return register;
    }
    
    public int InsertRegisteration(EJB.Register register){
        int registeredKey = 0;
        
        String query = "INSERT INTO registrations(AssesseId, EmailId, BillNo, Remarks, mobileno1, mobileno2) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, register.getAssesseId());
            pstmt.setString(2, register.getEmail());
            pstmt.setString(3, register.getBillNo());
            pstmt.setString(4, register.getRemarks());
            pstmt.setString(5, register.getMobileNo1());
            pstmt.setString(6, register.getMobileNo2());
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if(rs.next()){
                registeredKey = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return registeredKey;
    }
    
    public int UpdateRegistrationTable(int registrationId, int otp){
        int is_update_registered = 0;
        
        String query = "UPDATE registrations SET otp = ? WHERE RegistrationId = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, otp);
            pstmt.setInt(2, registrationId);
            is_update_registered = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return is_update_registered;
    }
    
    public boolean CheckOTPValidity(int regKey, int otp){
        boolean isvalid = false;
        String query = "SELECT otp FROM registrations WHERE RegistrationId = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, regKey);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                if(rs.getInt("otp") == otp){
                    isvalid = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isvalid;
    }
}
