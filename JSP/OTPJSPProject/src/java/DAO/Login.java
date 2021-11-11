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
public class Login {
    private Connection connection;

    public Login() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public int GetUserEmail(String email){
        int loginId = 0;
        
        String query = "SELECT LoginId FROM user_login_accounts JOIN registrations ON registrations.RegistrationId = user_login_accounts.UserId WHERE registrations.EmailId = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                loginId = rs.getInt("LoginId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return loginId;
    }
    
    public int SetUserPassword(int loginId, String password){
        String query = "UPDATE user_login_accounts SET Password = ? WHERE LoginId = ?";
        
        int ispasswordset = 0;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, password);
            pstmt.setInt(2, loginId);
            ispasswordset = pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ispasswordset;
    }
    
    public String GetUserPassword(int loginId){
        String password = null;
        
        String query = "SELECT Password FROM user_login_accounts WHERE LoginId = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, loginId);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                password = rs.getString("Password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return password.isEmpty() ? null : password;
    }
    
    public EJB.Login GetLoginExists(String userId){
        EJB.Login loginObj = null;
        
        String query = "SELECT * FROM user_login_accounts WHERE UserId = ? OR RegistrationOrUserId = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, userId);
            pstmt.setString(2, userId);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                loginObj = new EJB.Login(rs.getInt("LoginId"), rs.getString("UserId"), rs.getString("Password"), rs.getInt("RoleId"), rs.getString("RegistrationOrUserId"), rs.getString("AccessibilityStatus"), rs.getString("CreatedBy"), rs.getString("CreatedDateTime"), rs.getString("EnabledBy"), rs.getString("EnabledDateTime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return loginObj;
    }
    
    public int InsertLoginCredentials(EJB.Login login){
        int generatedKey = 0;
        
        String query = "INSERT INTO user_login_accounts (UserId, Password, RoleId, RegistrationOrUserId, AccessibilityStatus, CreatedBy, EnabledBy, EnabledDateTime) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, login.getUserId());
            stmt.setString(2, login.getPassword());
            stmt.setInt(3, login.getRoleId());
            stmt.setString(4, login.getRegistrationOrUserId());
            stmt.setString(5, login.getAccessibilityStatus());
            stmt.setString(6, login.getCreatedBy());
            stmt.setString(7, login.getEnabledBy());
            stmt.setString(8, login.getEnabledDateTime());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                generatedKey = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return generatedKey;
    }
    
    public boolean UpdateLoginAvialabilityStatus(int loginID, char allow_type){
        
        boolean login_update_response = false;
        
        String query = "";
        
        if(allow_type == 'Y' || allow_type == 'y'){
            query = "UPDATE user_login_accounts SET AccessibilityStatus = 'Y' WHERE LoginID = ?";
        }else if(allow_type == 'N' || allow_type == 'n'){
            query = "UPDATE user_login_accounts SET AccessibilityStatus = 'N' WHERE LoginID = ?";
        }
        
        if(!query.isEmpty()){
            try {
                PreparedStatement pstmt = this.connection.prepareStatement(query);
                pstmt.setInt(1, loginID);
                if(pstmt.executeUpdate() > 0){
                    login_update_response = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return login_update_response;
    }
}
