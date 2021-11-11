/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author osama
 */
public class Order {
    private Connection connection;
    
    public Order(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public void InsertOrder(bean.Order order) throws SQLException{
        String products_set = "";
        
        for(int i=0; i < order.getInventoryArrayList().size(); i++){
            products_set += String.valueOf(order.getInventoryArrayList().get(i).getId()).concat(",");
        }
        
        String query = "INSERT INTO orders(products_set, user_id) VALUES (?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setString(1, products_set);
        pstmt.setInt(2, order.getUser().getId());
        pstmt.executeUpdate();
    }
}
