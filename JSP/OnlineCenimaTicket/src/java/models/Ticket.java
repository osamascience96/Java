/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db.Connector;
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
public class Ticket {
    // member variables
    public int id;
    public User user;
    public Seat seat;
    public Show show;
    public String createdAt;
    
    // db Connection
    public Connection connection;
    
    public Ticket(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public boolean InsertTicket(){
        String query = "INSERT INTO APP.TICKET (USER_ID, SEAT_ID, SHOW_ID) VALUES (?,?,?)";
        
        boolean isInserted = false;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, this.user.getId());
            pstmt.setInt(2, this.seat.getId());
            pstmt.setInt(3, this.show.getId());
            
            isInserted = pstmt.executeUpdate() > 0 ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isInserted;
    }
    
    
}
