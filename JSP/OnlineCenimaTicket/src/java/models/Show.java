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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Show extends Confs{
    // member variables
    public int id;
    public Film film;
    public Room room;
    public String date;
    public String time;
    public String createdAt;
    
    // db Connection
    public Connection connection;
    
    public Show() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public Show SelectById(){
        String query = "SELECT [schema].SHOWS.*, [schema].FILM.NAME as FILMNAME, [schema].ROOM.NAME as ROOMNAME FROM [schema].SHOWS LEFT JOIN [schema].FILM ON [schema].SHOWS.FILM_ID = [schema].FILM.ID LEFT JOIN [schema].ROOM ON [schema].ROOM.ID = [schema].SHOWS.ROOM_ID WHERE [schema].SHOWS.ID = ?".replace("[schema]", Schema);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, this.id);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                
                this.id = rs.getInt("ID");
                
                this.film = new Film();
                this.room = new Room();
                
                this.film.setId(rs.getInt("FILM_ID"));
                this.film.setName(rs.getString("FILMNAME"));
                
                this.room.setId(rs.getInt("ROOM_ID"));
                this.room.setName(rs.getString("ROOMNAME"));
                
                this.date = rs.getString("SHOW_DATE");
                this.time = rs.getString("SHOW_TIME");
                
                this.createdAt = rs.getString("CREATED_AT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
    
}
