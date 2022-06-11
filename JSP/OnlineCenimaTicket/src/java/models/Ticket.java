/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db.Connector;
import java.sql.Connection;

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
}
