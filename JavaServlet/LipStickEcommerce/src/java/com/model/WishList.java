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

// WishList-Modell
public class WishList {
    // sql connection instance
    private Connection connection;
    
    // constructor
    public WishList(){
        // die Verbindungs-SQL-Instanz, die die Benutzerdaten mithilfe der Singleton-Instanz der Datenbank überprüft
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    // Fügen Sie die Wunschliste in die Datenbank ein
    public void InsertWishList(com.pojo.WishList wishList) throws SQLException{
        // auszuführende Abfragezeichenfolge
        String query = "INSERT INTO wishlist(user_id, product_id) VALUES (?, ?)";
        
        // Bereiten Sie die SQL-Anweisung mit der obigen Abfrage vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, wishList.GetUserId());
        ps.setInt(2, wishList.GetProductid());
        
        // Führen Sie die Abfrage in der Datenbank aus
        ps.execute();
    }
    
    // Holen Sie sich alle Wunschliste des Benutzers aus der Datenbank
    public ArrayList<com.pojo.WishList> GetAllWishProducts(int user_id) throws SQLException{
        // Initiieren Sie die Wunschliste-Arrayliste, um das Objekt aus der Datenbank in die Liste aufzunehmen
        ArrayList<com.pojo.WishList> arrayWishList = new ArrayList<com.pojo.WishList>();
        // Zeichenfolgenabfrage für die Datenbank
        String query = "SELECT wishlist.id, wishlist.product_id, product.name as product_name, product.price as product_price, product.image_name as product_image FROM wishlist JOIN product ON wishlist.product_id = product.id WHERE wishlist.user_id = ?";
        // Bereiten Sie die SQL-Anweisung mit der obigen Abfrage vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, user_id);
        // Ausführen der Abfrage und Abrufen der Daten im Resulset
        ResultSet rs = ps.executeQuery();
        // Iterieren Sie die Ergebnismenge zum Wunschlistenobjekt und fügen Sie das Objekt dann der oben initiierten Liste hinzu
        while(rs.next()){
            com.pojo.WishList wishList = new com.pojo.WishList();
            wishList.SetId(rs.getInt("id"));
            wishList.SetProductId(rs.getInt("product_id"));
            wishList.SetProductName(rs.getString("product_name"));
            wishList.SetProductPrice(rs.getDouble("product_price"));
            wishList.SetProductImageName(rs.getString("product_image"));
            
            arrayWishList.add(wishList);
        }
        
        // Geben Sie die Wunschliste zurück
        return arrayWishList;
    }
    
    // Löschen Sie die Wunschliste in der Datenbank
    public void DeleteWishList(int id) throws SQLException{
        // Initiieren Sie die Abfrage
        String query = "DELETE FROM wishlist WHERE id = ?";
        // Bereiten Sie die SQL-Anweisung mit der obigen Abfrage vor
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, id);
        // Führen Sie die Abfrage in der Datenbank aus
        ps.execute();
    }
}
