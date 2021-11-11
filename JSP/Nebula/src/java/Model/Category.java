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
public class Category {
    private Connection connection = null;
    
    public Category(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public int InsertCategory(Bean.Category category) throws SQLException{
        String query = "INSERT INTO categories(name, description, image) VALUES(?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, category.getName());
        pstmt.setString(2, category.getDescription());
        pstmt.setBlob(3, category.getInputStream());
        
        pstmt.executeUpdate();
        
        ResultSet rs = pstmt.getGeneratedKeys();
        int generatedKey = 0;
        if(rs.next()){
            generatedKey = rs.getInt(1);
        }
        
        return generatedKey;
    }
    
    public boolean CheckCategoryExists(Bean.Category category) throws SQLException{
        boolean category_exists = false;
        
        String query = "SELECT name FROM categories WHERE name = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, category.getName());
        
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            String name = rs.getString("name");
            if(name.compareToIgnoreCase(category.getName()) == 0){
                category_exists = true;
            }
        }
        
        return category_exists;
    }
    
    public ArrayList<Bean.Category> GetCategoryArrayList() throws SQLException{
        ArrayList<Bean.Category> arrayListCategory = new ArrayList<Bean.Category>();
        
        String query = "SELECT * FROM categories";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            arrayListCategory.add(new Bean.Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getBlob("image"), rs.getString("created_at")));
        }
        
        return arrayListCategory;
    }
}
