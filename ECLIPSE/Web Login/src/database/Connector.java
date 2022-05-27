/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // connection path
            this.connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
        } catch (Exception ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Funktion, die die Instanz der Verbindung zurückgibt 
    public static Connector getConnectionInstance(){
        if(connectionObj == null){
            connectionObj = new Connector();
        }
        
        System.out.println();
        
        return connectionObj;
    }
    
    // Funktion, die das Objekt java.sql zurückgibt
    public Connection getConnection(){
        return this.connect;
    }
}
