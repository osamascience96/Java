/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        this.EstablishConnection();
    }
    
    private void EstablishConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            this.connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/survey", "postgres", "localhost");
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
        try {
            // check if he connection is closed
            if(this.connect.isClosed()){
                this.EstablishConnection();
                System.out.println("New Connection");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(this.connect);
        return this.connect;
    }
}
