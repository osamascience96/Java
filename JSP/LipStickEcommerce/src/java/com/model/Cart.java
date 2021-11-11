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

// Warenkorb-Datenbankmodell
public class Cart {
    // sql connection instance
    private Connection connection;
    
    public Cart(){
        // die Verbindungs-SQL-Instanz, die die Benutzerdaten mithilfe der Singleton-Instanz der Datenbank überprüft
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    // Setzen Sie die Wagenfunktion ein database
    public void InsertCart(com.pojo.Cart cart) throws SQLException{
        // Abfrage zeichenfolgen funktion 
        String query = "INSERT INTO cart(user_id, product_id) VALUES (?, ?)";
        
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor 
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, cart.GetUserId());
        ps.setInt(2, cart.GetProductid());
        
        // Führen Sie die Anweisung aus
        ps.execute();
    }
    
    //Holen Sie sich alle Warenkorb Produkte Funktion database
    public ArrayList<com.pojo.Cart> GetAllCartProducts(int user_id) throws SQLException{
        
        // Arraylist für Arraycartlist
        ArrayList<com.pojo.Cart> arrayCartList = new ArrayList<com.pojo.Cart>();
        
        // Abfrage zeichenfolgen funktion 
        String query = "SELECT cart.id, cart.product_id, product.name as product_name, product.price as product_price, product.image_name as product_image FROM cart JOIN product ON cart.product_id = product.id WHERE cart.user_id = ?";
        
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, user_id);
        
        // Abrufen des ausgeführten Abfrageergebnisses in die Ergebnismenge
        ResultSet rs = ps.executeQuery();
        
        // Durchlaufen Sie die Ergebnismenge, um die aus der Database in die Arrayliste abgerufenen Werte zu initialisieren
        while(rs.next()){
            com.pojo.Cart cartList = new com.pojo.Cart();
            cartList.SetId(rs.getInt("id"));
            cartList.SetProductId(rs.getInt("product_id"));
            cartList.SetProductName(rs.getString("product_name"));
            cartList.SetProductPrice(rs.getDouble("product_price"));
            cartList.SetProductImageName(rs.getString("product_image"));
            
            // Fügen Sie jedes abgerufene Objekt zur Arrayliste hinzu
            arrayCartList.add(cartList);
        }
        
        // Arraylist zurückgeben
        return arrayCartList;
    }
    
    // Funktion der Wagenmenge abrufen database
    public int GetQuantityOfCarts(int user_id) throws SQLException{
        // Mengen variable
        int quantity = 0;
        
        // Abfrage zeichenfolgen funktion 
        String query = "SELECT COUNT(cart.id) FROM cart WHERE cart.user_id = ?";
        
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, user_id);
        
        // Abrufen des ausgeführten Abfrageergebnisses in die Ergebnismenge
        ResultSet rs = ps.executeQuery();
        // Durchlaufen Sie die Ergebnismenge, um die aus der Database in die variable abgerufenen Werte zu initialisieren
        while(rs.next()){
            //Fügen Sie jedes abgerufene Objekt zur variable hinzu
            quantity = rs.getInt("COUNT(cart.id)");
        }
        
        // Rückgabemenge
        return quantity;
    }
    
    // Preis der Kartenfunktion database
    public int GetPriceofCarts(int user_id) throws SQLException{
        // Gesamtpreis variable
        int total_price = 0;
        
        // Abfrage zeichenfolgen funktion 
        String query = "SELECT SUM(product.price) FROM cart JOIN product ON cart.product_id = product.id WHERE cart.user_id = ?";
        
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, user_id);
        
        // Abrufen des ausgeführten Abfrageergebnisses in die Ergebnismenge
        ResultSet rs = ps.executeQuery();
        
        // Durchlaufen Sie die Ergebnismenge, um die aus der Database in die variable abgerufenen Werte zu initialisieren
        while(rs.next()){
            total_price = rs.getInt("SUM(product.price)");
        }
        
        // Gesamtpreis zurückgeben
        return total_price;
    }
    
    // Warenkorbfunktion löschen database
    public void SetDeleteCarts(int user_id) throws SQLException{
        // Abfrage zeichenfolgen funktion 
        String query = "DELETE FROM cart WHERE user_id = ?";
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, user_id);
        // Führen Sie die Anweisung aus
        ps.execute();
    }
    
    // in die Bestelltabellendatenbank einfügen
    public void InsertOrder(int user_id, int quantity, int total_price) throws SQLException{
        // Abfrage zeichenfolgen funktion 
        String query = "INSERT INTO orders(user_id, quantity, total_price)VALUES(?, ?, ?)";
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, user_id);
        ps.setInt(2, quantity);
        ps.setInt(3, total_price);
        // Führen Sie die Anweisung aus
        ps.execute();
    }
}
