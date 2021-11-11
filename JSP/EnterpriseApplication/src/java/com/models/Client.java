/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.database.Connector;
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
public class Client {
    private Connection connection;
    
    public Client(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<com.pojo.Client> GetAllClientList() throws SQLException{
        ArrayList<com.pojo.Client> clientArrayList = new ArrayList<com.pojo.Client>();
        
        String query = "SELECT * FROM client";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            com.pojo.Client client = new com.pojo.Client(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("created_at"), rs.getString("updated_at"));
            // set the email and phone to the object
            client.SetEmail(rs.getString("email"));
            client.SetPhone(rs.getString("phone"));
            clientArrayList.add(client);
        }
        
        return clientArrayList;
    }
    
    public boolean CheckClientExistance(String name) throws SQLException{
        String query = "SELECT * FROM client WHERE name = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, name);
        
        ResultSet rs = ps.executeQuery();
        
        String final_client_name = "";
        while(rs.next()){
            final_client_name = rs.getString("name");
        }
        
        return final_client_name.compareToIgnoreCase(name) == 0 ? true : false;
    }
    
    public void InsertClient(com.pojo.Client client) throws SQLException{
        String query = "INSERT INTO client(name, address, email, phone, created_at) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, client.GetName());
        ps.setString(2, client.GetAddress());
        ps.setString(3, client.GetEmail());
        ps.setString(4, client.GetPhone());
        ps.setString(5, client.GetCreatedAT());
        
        ps.execute();
        
    }
    
    public void UpdateClient(com.pojo.Client client) throws SQLException{
        String query = "UPDATE client SET name = ?, address = ?, email = ?, phone = ? WHERE id = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setString(1, client.GetName());
        ps.setString(2, client.GetAddress());
        ps.setString(3, client.GetEmail());
        ps.setString(4, client.GetPhone());
        ps.setInt(5, client.GetId());
        
        ps.execute();
    }
    
    public void DeleteClient(int id) throws SQLException{
        String query = "DELETE FROM client WHERE id = ?";
        
        PreparedStatement ps = this.connection.prepareStatement(query);
        ps.setInt(1, id);
        
        ps.execute();
    }
}
