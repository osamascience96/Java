/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public ArrayList<Bean.Product> GetProductArrayList() throws SQLException{
        ArrayList<Bean.Product> productArrayList = new ArrayList<Bean.Product>();
        
        String query = "SELECT * FROM products";
        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        while(rs.next()){
            productArrayList.add(new Bean.Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getBlob("image"), rs.getString("created_at")));
        }
        
        return productArrayList;
    }
    
    public Bean.Product GetSingleProduct(int id) throws SQLException{
        Bean.Product product = null;
        
        String query = "SELECT * FROM products WHERE id = ?";
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            product = new Bean.Product(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getBlob("image"), rs.getString("created_at"));
        }
        
        return product;
    }
}
