/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 * creating singleton class for the database connection
 */
public class Connector{
    // members
    private Connection connect;
    private static Connector connectionObj = null;
    
    // private constructor
    private Connector(){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.connect = DriverManager.getConnection("jdbc:derby://localhost:1527/cenima", "root", "root");
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
