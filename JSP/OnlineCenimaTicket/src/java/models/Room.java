/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db.Confs;
import db.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Room extends Confs{
    // memeber variables
    public int id;
    public String name;
    public String description;
    public Seat seat;
    public String createdAt;
    
    // db connection
    public Connection connection;

    public Room() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }

    public Room(int id, String name, String description, String createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
    }
    
    public List<Room> SelectAllRooms(){
        
        ArrayList<Room> rooms = new ArrayList<>();
        
        String query = "SELECT * FROM [schema].ROOM".replace("[schema]", Schema);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                rooms.add(new Room(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getString("created_at")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rooms;
    }
    
    // The function considers last rows price to be the best price, so selected Zth row
    public List<Room> SelectAllRoomsBestSeatPrice(){
        ArrayList<Room> rooms = new ArrayList<>();
        
        String query = "SELECT DISTINCT [schema].ROOM.*, [schema].SEATS.PRICE AS BESTSEATPRICE FROM [schema].ROOM LEFT JOIN [schema].SEATS ON [schema].SEATS.ROOM_ID = [schema].ROOM.ID WHERE [schema].SEATS.ROW_NUM = ?".replace("[schema]", Schema);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, "Z");
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Room room = new Room(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getString("created_at"));
                
                Seat seat = new Seat();
                seat.setPrice(rs.getDouble("BESTSEATPRICE"));
                
                room.setSeat(seat);
                
                rooms.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rooms;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
