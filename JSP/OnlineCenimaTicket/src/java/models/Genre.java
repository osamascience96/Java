/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db.Connector;
import java.sql.Connection;

/**
 *
 * @author osama
 */
public class Genre {
    // member variables
    public int id;
    public String name;
    public String createdAt;
    
    // Sql Connection
    private Connection connection;

    public Genre() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }

    public Genre(int id, String name, String createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
