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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class User {
    private Connection connection;
    
    public User(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public int InsertUser(Bean.User user){
        int key = 0;
        
        String query = "SELECT * FROM users WHERE email = ? || phone_no = ?";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPhoneNumber());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                key = rs.getInt("id");
            }else{
                query = "INSERT INTO users(name, email, address, phone_no, credit_card_no) VALUES(?, ?, ?, ?, ?)";
                pstmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, user.getName());
                pstmt.setString(2, user.getEmail());
                pstmt.setString(3, user.getAddress());
                pstmt.setString(4, user.getPhoneNumber());
                pstmt.setString(5, user.getCreditCardNumber());
                pstmt.execute();
                
                rs = pstmt.getGeneratedKeys();
                if(rs.next()){
                    key = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return key;
    }
    
    
    public void SetRating(int userId, int orderId, float rating) throws SQLException{
        String query = "INSERT INTO rating(user_id, order_id, rating) VALUES (?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, userId);
        pstmt.setInt(2, orderId);
        pstmt.setFloat(3, rating);
        pstmt.executeUpdate();
    }
}
