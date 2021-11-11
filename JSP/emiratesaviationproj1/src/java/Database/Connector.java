/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Connector {
    private Connection connection;
    private static Connector connect = null;
            
    public Connector() {
        // eastablish the connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/eaviuni", "root", "");
        } catch (Exception ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connector GetConnectionInstance(){
        if(connect == null){
            connect = new Connector();
        }
        
        System.out.println(connect);
        
        return connect;
    }
    
    public Connection GetSQLConnection(){
        return this.connection;
    }
    
}
