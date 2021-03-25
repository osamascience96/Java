/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */
package com.model;

import com.database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Benutzermodell
public class User {
    // sql connection instance
    private Connection connection;
    
    // constructor
    public User(){
        // die Verbindungs-SQL-Instanz, die die Benutzerdaten mithilfe der Singleton-Instanz der Datenbank überprüft
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    // Benutzerdaten aus der Datenbank abrufen
    public com.pojo.User GetUserData(String email) throws SQLException{
        // Initialisieren Sie das Benutzerobjekt so, dass es die Benutzerdaten aus der Datenbank enthält
        com.pojo.User userObj = new com.pojo.User();
        // Abfrage für die Datenbank
        String query = "SELECT * FROM user WHERE email = ?";
        // Bereiten Sie die Abfrage für die Anweisung in der Datenbank vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, email);
        // Ergebnismenge, die die ausgeführten Daten enthält
        ResultSet rs = ps.executeQuery();
        
        // Durchlaufen Sie die Ergebnismenge und starten Sie das Benutzerobjekt
        while (rs.next()) {
            userObj.SetId(rs.getInt("id"));
            userObj.SetFirstName(rs.getString("first_name"));
            userObj.SetLastName(rs.getString("last_name"));
            userObj.SetGender(rs.getString("gender"));
            userObj.SetEmail(rs.getString("email"));
            userObj.SetPassword(rs.getString("password"));
            userObj.SetPrice(rs.getDouble("balance"));
        }
        
        // Geben Sie das Benutzerobjekt zurück
        return userObj;
    }
    // Fügen Sie den Benutzer in die Datenbank ein
    public boolean InsertUser(com.pojo.User user) throws SQLException{
        // Abfrage für die Datenbank
        String query = "INSERT into user(first_name, last_name, gender, email, password, address) VALUES (?, ?, ?, ?, ?, ?)";
        // Bereiten Sie die Abfrage für die Anweisung in der Datenbank vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, user.GetFirstName());
        ps.setString(2, user.GetLastName());
        ps.setString(3, user.GetGender());
        ps.setString(4, user.GetEmail());
        ps.setString(5, user.GetPassword());
        ps.setString(6, user.GetAddress());
        // Führen Sie die Anweisung in der Datenbank aus
        boolean response = ps.execute();
        
        return true;
    }
    
    // Überprüfen Sie, ob der Benutzer in der Datenbank vorhanden ist
    public boolean CheckUserExists(com.pojo.User user) throws SQLException{
        // initlize the user arraylist
        ArrayList<com.pojo.User> arrayListUser = new ArrayList<com.pojo.User>();
        // Abfrage für die Datenbank
        String query = "SELECT * FROM user WHERE email = ?";
        // Bereiten Sie die Abfrage für die Anweisung in der Datenbank vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, user.GetEmail());
        // Ergebnismenge, die die ausgeführten Daten enthält
        ResultSet rs = ps.executeQuery();
        // Durchlaufen Sie die Ergebnismenge, um die Daten aus der Datenbank im Benutzerobjekt zu initiieren
        while(rs.next()){
            com.pojo.User userObj = new com.pojo.User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"), rs.getString("email"), rs.getString("password"));
            userObj.SetPrice(rs.getDouble("balance"));
            arrayListUser.add(userObj);
        }
        
        // Geben Sie die Array-Liste zurück
        return arrayListUser.size() > 0 ? true : false;
    }
    
    // Überprüfen Sie die Anmeldung aus der Datenbank
    public boolean CheckLogin(com.pojo.User user) throws SQLException{
        // Initialisiere die Benutzer-Arrayliste
        ArrayList<com.pojo.User> arrayListUser = new ArrayList<com.pojo.User>();
        // Abfrage für die Datenbank
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        // Bereiten Sie die Abfrage für die Anweisung in der Datenbank vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, user.GetEmail());
        ps.setString(2, user.GetPassword());
        // Ergebnismenge, die die ausgeführten Daten enthält
        ResultSet rs = ps.executeQuery();
        // Durchlaufen Sie die Ergebnismenge, um die aus der Datenbank abgerufenen Daten zu initialisieren
        while(rs.next()){
            com.pojo.User userObj = new com.pojo.User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"), rs.getString("email"), rs.getString("password"));
            userObj.SetPrice(rs.getDouble("balance"));
            arrayListUser.add(userObj);
        }
        // Geben Sie die Benutzer-Arrayliste zurück
        return arrayListUser.size() != 0 ? true : false;
    }
    
    // Holen Sie sich das Benutzerguthaben aus der Datenbank
    public int GetUserBalance(int user_id) throws SQLException{
        // Bilanz variable
        int balance = 0;
        // Abfrage für die Datenbank
        String query = "SELECT balance FROM user WHERE id = ?";
        // Bereiten Sie die Abfrage für die Anweisung in der Datenbank vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, user_id);
        // Ergebnismenge, die die ausgeführten Daten enthält
        ResultSet rs = ps.executeQuery();
        // Rufen Sie den Kontostand aus der Datenbank ab, um die Daten für die aus der Datenbank abgerufene Kontostandvariable zu initiieren
        while(rs.next()){
            balance = rs.getInt("balance");
        }
        // den Restbetrag zurückgeben
        return balance;
    }
    
    // Aktualisieren Sie den Benutzer auf die Datenbank
    public void UpdateUser(int user_id, int balance) throws SQLException{
        // Abfrage für die Datenbank
        String query = "UPDATE user SET balance = ? WHERE id = ?";
        // Bereiten Sie die Abfrage für die Anweisung in der Datenbank vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, balance);
        ps.setInt(2, user_id);
        // Führen Sie die Abfrage in der Datenbank aus
        ps.execute();
    }
}
