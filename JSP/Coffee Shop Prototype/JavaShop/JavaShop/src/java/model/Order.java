/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.database.Connector;
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
        String query = "";
        PreparedStatement ps = null;
        
        if(order.getNotes() != null){
            query = "INSERT INTO orders(product_id, session_id, customer_name, phone_number, address, total_price, quantity, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = this.connection.prepareStatement(query);
            ps.setInt(1, order.getProductId());
            ps.setString(2, order.getSessionId());
            ps.setString(3, order.getCustomerName());
            ps.setString(4, order.getContactNo());
            ps.setString(5, order.getAddress());
            ps.setDouble(6, order.getPrice());
            ps.setInt(7, order.getQuantity());
            ps.setString(8, order.getNotes());
        }else{
            query = "INSERT INTO orders(product_id, session_id, customer_name, phone_number, address, total_price, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = this.connection.prepareStatement(query);
            ps.setInt(1, order.getProductId());
            ps.setString(2, order.getSessionId());
            ps.setString(3, order.getCustomerName());
            ps.setString(4, order.getContactNo());
            ps.setString(5, order.getAddress());
            ps.setDouble(6, order.getPrice());
            ps.setInt(7, order.getQuantity());
        }
        
        ps.executeUpdate();
    }
}
