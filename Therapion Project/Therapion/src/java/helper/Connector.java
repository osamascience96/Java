/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Connector {
    // Mitglieder
    private Connection connect;
    // Diese Klasseninstanz ist statisch
    private static Connector connectionObj = null;
    
    // privater Konstrukteur
    private Connector(){
        try {
            // Herstellen der Verbindung zum Treiber zur Datenbank in der SQL
            // driver
            Class.forName("com.mysql.jdbc.Driver");
            // connection path
            this.connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/therapion", "root", "");
        } catch (Exception ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Funktion, die die Instanz der Verbindung zurückgibt 
    public static Connector getConnectionInstance(){
        if(connectionObj == null){
            connectionObj = new Connector();
        }
        
        return connectionObj;
    }
    
    // Funktion, die das Objekt java.sql zurückgibt
    public Connection getConnection(){
        return this.connect;
    }
}
