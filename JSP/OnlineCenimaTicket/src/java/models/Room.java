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
public class Room {
    // memeber variables
    public int id;
    public String name;
    public String description;
    public String createdAt;
    
    // db connection
    public Connection connection;

    public Room() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    
}
