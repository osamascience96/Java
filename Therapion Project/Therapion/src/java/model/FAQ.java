/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helper.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class FAQ {
    private Connection connection;

    public FAQ() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public int InsertFAQ(pojo.FAQ faq){
        String query = "INSERT INTO faq(user_id, first_name, last_name, email, message) VALUES(?, ?, ?, ?, ?)";
        
        int row = 0;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, faq.getUser() != null ? faq.getUser().getId() : 0);
            pstmt.setString(2, faq.getFirstName());
            pstmt.setString(3, faq.getLastName());
            pstmt.setString(4, faq.getEmail());
            pstmt.setString(5, faq.getMessage());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FAQ.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return row;
    }
}
