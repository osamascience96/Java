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
public class Seat extends Confs{
    // member variables
    public int id;
    public char rowNum;
    public int columnNum;
    public Room room;
    public double price;
    public String createdAt;
    
    // db Connection
    public Connection connection;

    public Seat() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }

    public Seat(int id, char rowNum, int columnNum, Room room, double price, String createdAt) {
        this.id = id;
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        this.room = room;
        this.price = price;
        this.createdAt = createdAt;
    }
    
    public List<Seat> SelectByRoomId(){
        ArrayList<Seat> seats = new ArrayList<>();
        
        String query = "SELECT [schema].SEATS.*, [schema].ROOM.NAME AS ROOMNAME FROM [schema].SEATS JOIN [schema].ROOM ON [schema].ROOM.ID = [schema].SEATS.ROOM_ID WHERE [schema].SEATS.ROOM_ID = ? ORDER BY [schema].SEATS.ROW_NUM, [schema].SEATS.COLUMN_NUM ASC".replace("[schema]", Schema);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, this.room.getId());
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Room room = new Room();
                room.setId(rs.getInt("ROOM_ID"));
                room.setName(rs.getString("ROOMNAME"));
                
                seats.add(new Seat(rs.getInt("ID"), rs.getString("ROW_NUM").charAt(0), rs.getInt("COLUMN_NUM"), room, rs.getDouble("PRICE"), rs.getString("CREATED_AT")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Seat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getRowNum() {
        return rowNum;
    }

    public void setRowNum(char rowNum) {
        this.rowNum = rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
}
