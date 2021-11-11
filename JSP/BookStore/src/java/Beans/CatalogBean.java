/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Database.Connector;
import Model.Catalog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class CatalogBean {

    private Connector connection;
    private Connection sqlConnection;
    
    public CatalogBean() {
        this.connection = Connector.GetConnectionInstance();
        this.sqlConnection = this.connection.GetSQLConnection();
    }
    
    
    public ArrayList<Catalog> GetAllCatalog(){
        String query = "SELECT * FROM catalog";
        
        ArrayList<Catalog> catalogArrayList = new ArrayList<Catalog>();
        
        try {
            PreparedStatement pstmt = this.sqlConnection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Catalog catalog = new Catalog(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"), rs.getString("created_at"));
                catalogArrayList.add(catalog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatalogBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return catalogArrayList;
    }
    
    public Catalog GetCatalogById(int id){
        Catalog catalog = null;
        String query = "SELECT * FROM catalog WHERE id = ?";
        
        try {
            PreparedStatement pstmt = this.sqlConnection.prepareStatement(query);
            pstmt.setInt(1, id);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                catalog = new Catalog(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"), rs.getString("created_at"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatalogBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return catalog;
    }
    
    public ArrayList<Catalog> GetCatalogListByAuthor(String author){
        ArrayList<Catalog> arrayListCatalog = new ArrayList<Catalog>();
        String query = "SELECT * FROM catalog WHERE author = ?";
        
        try {
            PreparedStatement pstmt = this.sqlConnection.prepareStatement(query);
            pstmt.setString(1, author);
            
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Catalog catalog = new Catalog(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"), rs.getString("created_at"));
                arrayListCatalog.add(catalog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CatalogBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListCatalog;
    }
    
    public int InsertCatalog(Catalog catalog){
        String query = "INSERT INTO catalog(title, author, price) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = this.sqlConnection.prepareStatement(query);
            pstmt.setString(1, catalog.getTitle());
            pstmt.setString(2, catalog.getAuthor());
            pstmt.setDouble(3, catalog.getPrice());
            
            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CatalogBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
}
