/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Room;

/**
 *
 * @author osama
 */
public class RoomService {
    private String name;
    private String description;
    private String createdAt;
    
    private Room room;

    public RoomService() {
        this.room = new Room();
    }

    public RoomService(String name, String description, String createdAt) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        
        this.room = new Room();
    }
    
    public List<Room> GetAllRooms(){
        return this.room.SelectAllRooms();
    }
    
    public List<Room> GetAllRoomsBestPrice(){
        return this.room.SelectAllRoomsBestSeatPrice();
    }
}
