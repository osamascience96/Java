/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.User;
import Database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author osama
 */
public class Register {
    private Connection connection;
    
    public Register(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public boolean checkUser(User user) throws SQLException{
        boolean user_exists = false;
        
        String query = "SELECT * FROM user WHERE username = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            user_exists = true;
        }
        
        return user_exists;
    }
    
    public void InsertUser(User user) throws SQLException{
        String query = "INSERT INTO user(username, email, password) VALUES(?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPassword());
        pstmt.executeUpdate();
    }
}
