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
    
    public boolean CheckProductExists(Bean.Product product) throws SQLException{
        boolean is_exist = false;
        
        String query = "SELECT name FROM products WHERE name = ?";
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, product.getName());
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            String name = rs.getString("name");
            if(name.compareToIgnoreCase(product.getName()) == 0){
                is_exist = true;
            }
        }
        
        return is_exist;
    }
    
    public void InsertProduct(Bean.Product product) throws SQLException{
        String query = "INSERT INTO products(c_id, name, description, price, image) VALUES(?, ?, ?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, product.getCategoryId());
        pstmt.setString(2, product.getName());
        pstmt.setString(3, product.getDescription());
        pstmt.setDouble(4, product.getPrice());
        pstmt.setBlob(5, product.getInputStream());
        
        pstmt.executeUpdate();
    }
    
    public ArrayList<Bean.Product> GetProductArrayList(int category_id) throws SQLException{
        ArrayList<Bean.Product> arrayListProducts = new ArrayList<Bean.Product>();
        
        String query = "SELECT * FROM products WHERE c_id = ?";
        PreparedStatement pstmt = this.connection.prepareCall(query);
        pstmt.setInt(1, category_id);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            arrayListProducts.add(new Bean.Product(rs.getInt("id"), rs.getInt("c_id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getBlob("image"), rs.getString("created_at")));
        }
        
        return arrayListProducts;
    }
    
    public Bean.Product GetModifiedProductBean(Bean.Product product) throws SQLException{
        String query = "SELECT * FROM products WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, product.getId());
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getDouble("price"));
            product.setImage(rs.getBlob("image"));
        }
        
        return product;
    }
}
