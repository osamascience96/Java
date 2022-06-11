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
public class Seat {
    // member variables
    public int id;
    public char rowNum;
    public int columnNum;
    public Room room;
    public double price;
    public String createdAt;
    
    // db Connection
    public Connection connection;

    public Seat() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    
}
