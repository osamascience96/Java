/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.conf.ConfigurationConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 * creating singleton class for the database connection
 */
public class Connector implements ConfigurationConstants{
    // members
    private Connection connect;
    private static Connector connectionObj = null;
    
    // private constructor
    private Connector(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/wardsystem", dbUser, dbPass);
        } catch (Exception ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // function that returns the instance of the connection 
    public static Connector getConnectionInstance(){
        if(connectionObj == null){
            connectionObj = new Connector();
        }
        
        return connectionObj;
    }
    
    // function that returns the java.sql object
    public Connection getConnection(){
        return this.connect;
    }
}
