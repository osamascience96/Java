/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import bean.Orders;
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
    
    public void InsertOrder(Orders order) throws SQLException{
        String query = "INSERT INTO orders(user_id, product_sets) VALUES(?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, order.getUser_id());
        pstmt.setString(2, order.getProduct_sets());
        pstmt.executeUpdate();
    }
}
