/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.database.Connector;
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
    
    public ArrayList<bean.Product> GetAllProducts() throws SQLException{
        String query = "SELECT * FROM product";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        ArrayList<bean.Product> productArrayList = new ArrayList<bean.Product>();
        
        while(rs.next()){
            productArrayList.add(new bean.Product(rs.getInt("id"), rs.getString("typename"), rs.getDouble("price"), rs.getString("image"), rs.getString("created_at")));
        }
        
        return productArrayList;
    }
}
