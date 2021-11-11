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
public class Category {
    private Connection connection;
    
    public Category(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<bean.Category> GetCategoryLists() throws SQLException{
        ArrayList<bean.Category> categoryArrayList = new ArrayList<bean.Category>();
        
        String query = "SELECT * FROM `category`";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            categoryArrayList.add(new bean.Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getBlob("image"), rs.getString("created_at")));
        }
        
        return categoryArrayList;
    }
    
    public boolean CheckCategoryExists(bean.Category category) throws SQLException{
        boolean is_category_exists = false;
        
        String query = "SELECT * FROM category WHERE upper(name) = upper(?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, category.getName());
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            is_category_exists = true;
        }
        
        return is_category_exists;
    }
    
    public void InsertCategory(bean.Category category) throws SQLException{
        String query = "INSERT INTO category(name, description, image) VALUES (?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, category.getName());
        pstmt.setString(2, category.getDescription());
        pstmt.setBlob(3, category.getInputStream());
        
        pstmt.executeUpdate();
    }
}
