/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.database.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class User {
    private Connection connect;
    private ArrayList<com.pojo.User> usersArrayList;
    
    public User(){
        this.connect = Connector.getConnectionInstance().getConnection();
        this.usersArrayList = new ArrayList<com.pojo.User>();
    }
    
    // function checks the user by email and returns the pojo object
    public ArrayList<com.pojo.User> CheckUser(String email) throws SQLException{
        String query = "SELECT * FROM `users` WHERE email = '" + email + "'";
        Statement stmt = this.connect.createStatement();
        // get the result row 
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            com.pojo.User user = new com.pojo.User();
            user.SetId(rs.getInt("id"));
            user.SetName("name");
            user.SetEmail(rs.getString("email"));
            this.usersArrayList.add(user);
        }
        
        return this.usersArrayList;
    }
    
    public int InsertdatatoUsers(String name, String username, String password) throws SQLException{
        String query = "INSERT INTO `users`(name, email, password)VALUES('" + name + "', '" + username + "', '" + password + "')";
        Statement stmt = this.connect.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public ArrayList<com.pojo.User> CheckUserLoginData(String email, String password) throws SQLException{
        String query = "SELECT * FROM `users` WHERE email = '" + email + "' AND password = '" + password + "'";
        Statement stmt = this.connect.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            com.pojo.User user = new com.pojo.User();
            user.SetId(rs.getInt("id"));
            user.SetName("name");
            user.SetEmail(rs.getString("email"));
            this.usersArrayList.add(user);
        }
        
        return this.usersArrayList;
    }
    
    public com.pojo.User GetUserFromDB(String email) throws SQLException{
        String query = "SELECT * FROM `users` WHERE email = '" + email + "'";
        Statement stmt = this.connect.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        com.pojo.User user = null;
        
        while(rs.next()){
            user = new com.pojo.User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phone"), rs.getString("status"), rs.getString("nationality"), rs.getString("date_of_birth"));
            user.SetTimeStamp(rs.getString("created_at"));
            user.SetImage(rs.getBlob("image"));
        }
        
        return user;
    }
    
    public com.pojo.User GetUserFromDBviaid(String user_id) throws SQLException{
        String query = "SELECT * FROM `users` WHERE id = " + user_id;
        Statement stmt = this.connect.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        com.pojo.User user = null;
        
        while(rs.next()){
            user = new com.pojo.User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phone"), rs.getString("status"), rs.getString("nationality"), rs.getString("date_of_birth"));
            user.SetTimeStamp(rs.getString("created_at"));
            user.SetImage(rs.getBlob("image"));
        }
        
        return user;
    }
}
