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
public class Show {
    // member variables
    public int id;
    public Film film;
    public Room room;
    public String date;
    public String time;
    public String createdAt;
    
    // db Connection
    public Connection connection;
    
    public Show() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
}
