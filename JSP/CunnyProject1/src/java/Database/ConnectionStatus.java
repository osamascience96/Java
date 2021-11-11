/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class ConnectionStatus {
    private String id;
    private String password;
    
    public ConnectionStatus(String id, String password){
        this.id = id;
        this.password = password;
    }
    
    public boolean CheckValidConnection(){
        boolean isValid = false;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://s16988308.onlinehome-server.com:1433;databaseName=CUNY_DB;integratedSecurity=false;" , this.id, this.password);
            if(connection != null){
                isValid = true;
                DBCredentials.SetDBID(this.id);
                DBCredentials.SetDBPassword(this.password);
                connection.close();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isValid;
    }
}
