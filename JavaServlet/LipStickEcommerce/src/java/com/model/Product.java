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

// Produktmodell
public class Product {
    // sql connection instance
    private Connection connection = null;
    
    public Product(){
        // die Verbindungs-SQL-Instanz, die die Benutzerdaten mithilfe der Singleton-Instanz der Datenbank überprüft
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    // Holen Sie sich alle Produkte aus der Datenbank
    public ArrayList<com.pojo.Product> GetAllProducts() throws SQLException{
        // Initiieren Sie die Produkt-Arrayliste
        ArrayList<com.pojo.Product> productsArrayList = new ArrayList<com.pojo.Product>();
        // Abfrage zeichenfolgen funktion 
        String query = "SELECT * FROM product";
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor 
        PreparedStatement ps = this.connection.prepareStatement(query);
        // Abrufen des ausgeführten Abfrageergebnisses in die Ergebnismenge
        ResultSet rs = ps.executeQuery();
        // Durchlaufen Sie die Ergebnismenge, um die aus der Database in die Arrayliste abgerufenen Werte zu initialisieren
        while(rs.next()){
            productsArrayList.add(new com.pojo.Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getString("type"), rs.getString("color_type"), rs.getString("skin_type"), rs.getString("image_name")));
        }
        //Produktarrayliste zurücksenden
        return productsArrayList;
    }
    // Holen Sie sich ALLE Produkte aus der Datenbank nur nach Hauttyp gefiltert
    public ArrayList<com.pojo.Product> GetAllProductsFilterSkinType(String skin_type) throws SQLException{
        // Initiieren Sie die Produktarray-Liste
        ArrayList<com.pojo.Product> productsArrayList = new ArrayList<com.pojo.Product>();
        // Abfrage zeichenfolgen funktion 
        String query = "SELECT * FROM product WHERE skin_type LIKE ?";
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor 
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, skin_type);
        // Abrufen des ausgeführten Abfrageergebnisses in die Ergebnismenge
        ResultSet rs = ps.executeQuery();
        // Durchlaufen Sie die Ergebnismenge, um die aus der Database in die Arrayliste abgerufenen Werte zu initialisieren
        while(rs.next()){
            productsArrayList.add(new com.pojo.Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getString("type"), rs.getString("color_type"), rs.getString("skin_type"), rs.getString("image_name")));
        }
        //Produktarrayliste zurücksenden
        return productsArrayList;
    }
    // Holen Sie sich alle Produkte aus der Datenbank und filtern Sie den Typ
    public ArrayList<com.pojo.Product> GetAllProductsFilterType(String type) throws SQLException{
        // Initiieren Sie die Produktarray-Liste
        ArrayList<com.pojo.Product> productsArrayList = new ArrayList<com.pojo.Product>();
        // Abfrage zeichenfolgen funktion 
        String query = "SELECT * FROM product WHERE type LIKE ?";
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor 
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, type);
        // Abrufen des ausgeführten Abfrageergebnisses in die Ergebnismenge
        ResultSet rs = ps.executeQuery();
        // Durchlaufen Sie die Ergebnismenge, um die aus der Database in die Arrayliste abgerufenen Werte zu initialisieren
        while(rs.next()){
            productsArrayList.add(new com.pojo.Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getString("type"), rs.getString("color_type"), rs.getString("skin_type"), rs.getString("image_name")));
        }
        //Produktarrayliste zurücksenden
        return productsArrayList;
    }
    // Get all the products from the database filtering the color type
    public ArrayList<com.pojo.Product> GetAllProductsFilterColorType(String color_type) throws SQLException{
        // Initiieren Sie die Produktarray-Liste
        ArrayList<com.pojo.Product> productsArrayList = new ArrayList<com.pojo.Product>();
        // Abfrage zeichenfolgen funktion 
        String query = "SELECT * FROM product WHERE color_type LIKE ?";
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor 
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, color_type);
        // Abrufen des ausgeführten Abfrageergebnisses in die Ergebnismenge
        ResultSet rs = ps.executeQuery();
        // Durchlaufen Sie die Ergebnismenge, um die aus der Database in die Arrayliste abgerufenen Werte zu initialisieren
        while(rs.next()){
            productsArrayList.add(new com.pojo.Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("description"), rs.getString("type"), rs.getString("color_type"), rs.getString("skin_type"), rs.getString("image_name")));
        }
        //Produktarrayliste zurücksenden
        return productsArrayList;
    }
    // Get single the products from the database
    public com.pojo.Product GetProduct(int id) throws SQLException{
        // Abfrage zeichenfolgen funktion 
        String query = "SELECT * FROM product WHERE id = ?";
        // Initialisieren Sie das Produktobjekt so, dass es die Daten aus der Datenbank enthält
        com.pojo.Product product = new com.pojo.Product();
        // Bereiten Sie die Abfrage aus der SQL-Anweisung vor 
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, id);
        // Abrufen des ausgeführten Abfrageergebnisses in die Ergebnismenge
        ResultSet rs = ps.executeQuery();
        // Durchlaufen Sie die Ergebnismenge, um die aus der Database in die object abgerufenen Werte zu initialisieren
        while(rs.next()){
            product.SetId(rs.getInt("id"));
            product.SetName(rs.getString("name"));
            product.SetPrice(rs.getDouble("price"));
            product.SetDescription(rs.getString("description"));
            product.SetType(rs.getString("type"));
            product.SetColorType(rs.getString("color_type"));
            product.SetSkinType(rs.getString("skin_type"));
            product.SetImageName(rs.getString("image_name"));
        }
        // Produktobjekt zurückgeben
        return product;
    }
}
