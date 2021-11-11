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
    
    public ArrayList<bean.Product> GetAllProductList() throws SQLException{
        String query = "SELECT * FROM product";
        
        ArrayList<bean.Product> productArrayList = new ArrayList<bean.Product>();
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            productArrayList.add(new bean.Product(rs.getInt("id"), rs.getInt("category_id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getBlob("image"), rs.getString("created_at")));
        }
        
        return productArrayList;
    }
    
    public bean.Product GetProduct(int id) throws SQLException{
        String query = "SELECT * FROM product WHERE id = ?";
        
        bean.Product productObj = null;
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            productObj = new bean.Product(rs.getInt("id"), rs.getInt("category_id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getBlob("image"), rs.getString("created_at"));
        }
        
        return productObj;
    }
    
    public ArrayList<bean.Product> GetAllCategoryProducts(int categoryId) throws SQLException{
        ArrayList<bean.Product> productArrayList = new ArrayList<bean.Product>();
        
        String query = "SELECT * FROM product WHERE category_id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, categoryId);
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            productArrayList.add(new bean.Product(rs.getInt("id"), rs.getInt("category_id"), rs.getString("name"), rs.getString("description"), rs.getDouble("price"), rs.getBlob("image"), rs.getString("created_at")));
        }
        
        return productArrayList;
    }
    
    public void InsertProduct(bean.Product product) throws SQLException{
        String query = "INSERT INTO product(category_id, name, description, price, image) VALUES(?, ?, ?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, product.getCategory_id());
        pstmt.setString(2, product.getName());
        pstmt.setString(3, product.getDescription());
        pstmt.setDouble(4, product.getPrice());
        pstmt.setBlob(5, product.getInputStream());
        
        pstmt.executeUpdate();
    }
    
    public boolean IsProductAlreadyExists(bean.Product product) throws SQLException{
        boolean exists = false;
        
        String query = "SELECT * FROM product WHERE category_id = ? AND upper(name) = upper(?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, product.getCategory_id());
        pstmt.setString(2, product.getName());
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            exists = true;
        }
        
        return exists;
    }
}
