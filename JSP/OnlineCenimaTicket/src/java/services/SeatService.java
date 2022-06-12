/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Room;
import models.Seat;

/**
 *
 * @author osama
 */
public class SeatService {
    private int id;
    private char row;
    private int column;
    private int roomId;
    private double price;
    private String createdAt;
    
    private Seat seat;

    public SeatService() {
        this.seat = new Seat();
    }

    public SeatService(int id, char row, int roomId, int column, double price, String createdAt) {
        this.id = id;
        this.row = row;
        this.roomId = roomId;
        this.column = column;
        this.price = price;
        this.createdAt = createdAt;
        
        this.seat = new Seat();
    }
    
    public List<Seat> GetListByRoom(){
        Room room = new Room();
        room.setId(this.roomId);
        
        this.seat.room = room;
        
        return this.seat.SelectByRoomId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
}
