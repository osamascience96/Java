/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db.Confs;
import db.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class FAQ extends Confs{
    // member variables
    public int id;
    public String name;
    public String email;
    public String subject;
    public String message;
    public String created_at;
    
    // sql connection
    private final Connection connection;

    public FAQ() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public boolean InsertFAQ(){
        boolean IsFAQ = false;
        String query = "INSERT INTO [user].faq(name, email, subject, message) VALUES (?, ?, ?, ?)".replace("[user]", User);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, this.name);
            pstmt.setString(2, this.email);
            pstmt.setString(3, this.subject);
            pstmt.setString(4, this.message);
            
            IsFAQ = pstmt.executeUpdate() > 0 ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(FAQ.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return IsFAQ;
    }
}
