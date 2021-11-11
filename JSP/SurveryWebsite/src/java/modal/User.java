/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import database.Connector;
import helper.DateTime;
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
    
    public bean.User GetUser(String email){
        bean.User user = null;
        
        String query = "SELECT * FROM users WHERE email = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                user = new bean.User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("created_at"), rs.getString("type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    public int InsertUser(bean.User user){
        int userId = 0;
        
        String query = "INSERT INTO users(name, email, password, created_at, type) VALUES (?, ?, ?, ?, 'user')";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, DateTime.GetDateTime());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if(rs.next()){
                userId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userId;
    }
}
