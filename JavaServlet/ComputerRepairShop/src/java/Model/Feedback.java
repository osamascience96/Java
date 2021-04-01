/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Feedback {
    private Connection conn;
    
    public Feedback(){
        this.conn = Connector.getConnectionInstance().getConnection();
    }
    
    public void InsertFeedback(POJO.Feedback feedback){
        String query = "INSERT INTO feedback(name, country, phone, email, subject, type, Message) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.setString(1, feedback.GetName());
            ps.setString(2, feedback.GetCountry());
            ps.setString(3, feedback.GetPhone());
            ps.setString(4, feedback.GetEmail());
            ps.setString(5, feedback.GetSubject());
            ps.setString(6, feedback.GetType());
            ps.setString(7, feedback.GetMessage());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
