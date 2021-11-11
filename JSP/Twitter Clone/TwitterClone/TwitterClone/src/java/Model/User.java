/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.Followed;
import Database.Connector;
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
    
    public Bean.User CheckUser(Bean.User user) throws SQLException{
        Bean.User userobj = null;
        
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            userobj = new Bean.User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
        }
        
        return userobj;
    }
    
    public ArrayList<Bean.User> GetAllUserList() throws SQLException{
        ArrayList<Bean.User> arrayListUsers = new ArrayList<Bean.User>();
        
        String query = "SELECT * FROM user";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            arrayListUsers.add(new Bean.User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password")));
        }
        
        return arrayListUsers;
    }
    
    public void followuser(Followed followed) throws SQLException{
        String query = "INSERT INTO followed(user_id, followed_userid) VALUES (?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, followed.getUser_id());
        pstmt.setInt(2, followed.getFollowed_userid());
        
        pstmt.executeUpdate();
    }
    
    public void UnfollowUser(Followed followed) throws SQLException{
        String query = "DELETE FROM followed WHERE user_id = ? AND followed_userid = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, followed.getUser_id());
        pstmt.setInt(2, followed.getFollowed_userid());
        pstmt.executeUpdate();
    }
    
    public ArrayList<Followed> GetAllFollowedUsers(int userid) throws SQLException{
        ArrayList<Followed> arrayListFollowed = new ArrayList<Followed>();
        
        String query = "SELECT * FROM followed WHERE user_id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, userid);
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            Followed followed = new Followed();
            followed.setUser_id(rs.getInt("user_id"));
            followed.setFollowed_userid(rs.getInt("followed_userid"));
            
            arrayListFollowed.add(followed);
        }
        
        return arrayListFollowed;
    }
}