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
public class Show extends Confs{
    // member variables
    public int id;
    public Film film;
    public Room room;
    public String date;
    public String time;
    public String createdAt;
    
    public int ticketsCount = 0;
    
    // db Connection
    public Connection connection;
    
    public Show() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }

    public Show(int id, Film film, Room room, String date, String time, String createdAt) {
        this.id = id;
        this.film = film;
        this.room = room;
        this.date = date;
        this.time = time;
        this.createdAt = createdAt;
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
    
    public List<Show> SelectByShowDate(){
        String query = "SELECT [schema].SHOWS.*, [schema].FILM.NAME as FILMNAME, [schema].ROOM.NAME as ROOMNAME FROM [schema].SHOWS LEFT JOIN [schema].FILM ON [schema].SHOWS.FILM_ID = [schema].FILM.ID LEFT JOIN [schema].ROOM ON [schema].ROOM.ID = [schema].SHOWS.ROOM_ID WHERE [schema].SHOWS.SHOW_DATE = ?".replace("[schema]", Schema);
        
        ArrayList<Show> shows = new ArrayList<Show>();
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, this.date);
            
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
                
                shows.add(new Show(this.id, this.film, this.room, this.date, this.time, this.createdAt));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return shows;
    }
    
    public List<Show> SelectShowTicketsCounts(){
        String query = "SELECT [schema].SHOWS.ID as ShowId, [schema].FILM.NAME as filmname, [schema].SHOWS.SHOW_DATE as ShowDate, [schema].SHOWS.SHOW_TIME as ShowTime, count([schema].TICKET.ID) as amount_of_tickets FROM [schema].SHOWS LEFT JOIN [schema].TICKET ON [schema].TICKET.SHOW_ID = [schema].SHOWS.ID LEFT JOIN [schema].FILM ON [schema].FILM.ID = [schema].SHOWS.FILM_ID GROUP BY [schema].SHOWS.ID, [schema].SHOWS.SHOW_DATE, [schema].SHOWS.SHOW_TIME, [schema].FILM.NAME".replace("[schema]", Schema);
        
        ArrayList<Show> shows = new ArrayList<Show>();
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                
                this.id = rs.getInt("ShowId");
                
                this.film = new Film();
                this.film.setName(rs.getString("filmname"));
                
                this.date = rs.getString("ShowDate");
                this.time = rs.getString("ShowTime");
                
                this.ticketsCount = rs.getInt("amount_of_tickets");
                
                Show show = new Show();
                show.setId(this.id);
                show.setFilm(this.film);
                show.setDate(this.date);
                show.setTime(this.time);
                show.setTicketsCount(this.ticketsCount);
                
                shows.add(show);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return shows;
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

    public int getTicketsCount() {
        return ticketsCount;
    }

    public void setTicketsCount(int ticketsCount) {
        this.ticketsCount = ticketsCount;
    }
    
    
    
}
