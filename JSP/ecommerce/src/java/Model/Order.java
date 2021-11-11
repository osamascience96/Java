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

/**
 *
 * @author osama
 */
public class Order {
    private Connection connection;
    
    public Order(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public int InsertOrder(Bean.Order order) throws SQLException{
        int key = 0;
        
        String query = "INSERT INTO orders(userId, products_set, total_price) VALUES (?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, order.getUserId());
        pstmt.setString(2, order.getProductSets());
        pstmt.setDouble(3, order.getTotalPrice());
        
        pstmt.executeUpdate();
        
        ResultSet rs = pstmt.getGeneratedKeys();
        if(rs.next()){
            key = rs.getInt(1);
        }
        
        return key;
    }
    
    public float GetAverageOrdersRating() throws SQLException{
        float averageRating = 0;
        
        String query = "SELECT AVG(rating.rating) FROM rating";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if(rs.next()){
            averageRating = rs.getFloat(1);
        }
        
        return averageRating;
    }
}
