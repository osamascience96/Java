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
public class Order {
    private Connection connection;
    
    public Order(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public void InsertOrder(Bean.Order order) throws SQLException{
        String query = "INSERT INTO orders(user_id, product_id, total_price) VALUES (?, ?, ?)";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, order.getUserId());
        pstmt.setString(2, order.getProductSet());
        pstmt.setDouble(3, order.getTotalPrice());
        pstmt.executeUpdate();
    }
    
    public ArrayList<Bean.Order> GetOrders() throws SQLException{
        String query = "SELECT users.username, users.email, orders.total_price FROM orders LEFT JOIN users ON users.id = orders.user_id";
        
        ArrayList<Bean.Order> arrayListOrders = new ArrayList<Bean.Order>();
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            Bean.Order order = new Bean.Order();
            Bean.User user = new Bean.User();
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            order.setUser(user);
            order.setTotalPrice(rs.getDouble("total_price"));
            
            arrayListOrders.add(order);
        }
        
        return arrayListOrders;
    }
}
