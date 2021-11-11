/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class User {
    private Connection connection;
    
    public User(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<bean.User> GetAllUsers() throws SQLException{
        ArrayList<bean.User> arrayListUsers = new ArrayList<bean.User>();
        
        String query = "SELECT * FROM users";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            bean.User user = new bean.User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("created_at"));
            user.setRole(rs.getString("role"));
            arrayListUsers.add(user);
        }
        
        return arrayListUsers;
    }
    
    public bean.User GetUserObject(int userId) throws SQLException{
        String query = "SELECT * FROM users WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, userId);
        
        ResultSet rs = pstmt.executeQuery();
        
        bean.User userObj = null;
        
        if(rs.next()){
            userObj = new bean.User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("created_at"));
            userObj.setRole(rs.getString("role"));
        }
        
        return userObj;
    }
    
    public boolean UserExists(bean.User user) throws SQLException{
        boolean user_exists = false;
        
        String query = "SELECT * FROM users WHERE username = ? OR email = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            user_exists = true;
        }
        
        return user_exists;
    }
    
    public void InsertUser(bean.User user) throws SQLException{
        String query = "INSERT INTO users(username, email, password) VALUES(?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPassword());
        pstmt.executeUpdate();
    }
    
    public void InserAdmintUser(bean.User user) throws SQLException{
        String query = "INSERT INTO users(username, email, role, password) VALUES(?, ?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getRole());
        pstmt.setString(4, user.getPassword());
        pstmt.executeUpdate();
    }
    
    public bean.User GetUserModel(bean.User user) throws SQLException{
        String query = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPassword());
        
        ResultSet rs = pstmt.executeQuery();
        
        bean.User userObj = null;
        
        if(rs.next()){
            userObj = new bean.User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("created_at"));
            userObj.setRole(rs.getString("role"));
        }
        
        return userObj;
    }
    
    public void UpdateUser(bean.User user) throws SQLException{
        String query = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPassword());
        pstmt.setInt(4, user.getId());
        
        pstmt.executeUpdate();
    }
    
    public void UpdateAdminUser(bean.User user) throws SQLException{
        String query = "UPDATE users SET username = ?, email = ?, role = ?, password = ? WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getRole());
        pstmt.setString(4, user.getPassword());
        pstmt.setInt(5, user.getId());
        
        pstmt.executeUpdate();
    }
    
    public void DeleteUser(int id) throws SQLException{
        String query = "DELETE FROM users WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
