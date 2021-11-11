/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Inventory;
import database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class Product {
    private Connection connection;
    
    public Product(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public void InsertProduct(Inventory inventory) throws SQLException{
        String query = "INSERT INTO inventory(name, description, price) VALUES(?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, inventory.getName());
        pstmt.setString(2, inventory.getDescription());
        pstmt.setDouble(3, inventory.getPrice());
        
        pstmt.executeUpdate();
    }
    
    public void UpdateProduct(Inventory inventory) throws SQLException{
        String query = "UPDATE inventory SET name = ?, description = ?, price = ? WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, inventory.getName());
        pstmt.setString(2, inventory.getDescription());
        pstmt.setDouble(3, inventory.getPrice());
        pstmt.setInt(4, inventory.getId());
        
        pstmt.executeUpdate();
    }
    
    public ArrayList<Inventory> GetAllInventoryProducts() throws SQLException{
        ArrayList<Inventory> inventoryArrayList = new ArrayList<Inventory>();
        
        String query = "SELECT * FROM inventory";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            inventoryArrayList.add(new Inventory(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getString("created_at")));
        }
        
        return inventoryArrayList;
    }
    
    public void DeleteInventory(int id) throws SQLException{
        String query = "DELETE FROM inventory WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
    }
}
