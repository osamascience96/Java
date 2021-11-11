/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author osama
 */
public class User {
    private Connection connection;
    
    public User(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public bean.User GetUser(bean.User user) throws SQLException{
        bean.User userObj = null;
        
        String query = "SELECT * FROM user WHERE username = ? OR email = ?";
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            userObj = new bean.User();
            userObj.setId(rs.getInt("id"));
            userObj.setUsername(rs.getString("username"));
            userObj.setName(rs.getString("name"));
            userObj.setEmail(rs.getString("email"));
            userObj.setPassword(rs.getString("password"));
            userObj.setCreated_at(rs.getString("created_at"));
        }
        
        return userObj;
    }
    
    public void InsertUser(bean.User user) throws SQLException{
        String query = "INSERT INTO user(username, name, email, password) VALUES(?, ?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getPassword());
        pstmt.executeUpdate();
    }
}
