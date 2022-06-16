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
public class Ticket extends Confs{
    // member variables
    public int id;
    public User user;
    public Seat seat;
    public Show show;
    public String createdAt;
    
    // db Connection
    public Connection connection;
    
    public Ticket(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }

    public Ticket(int id, User user, Seat seat, Show show, String createdAt) {
        this.id = id;
        this.user = user;
        this.seat = seat;
        this.show = show;
        this.createdAt = createdAt;
    }
    
    public boolean InsertTicket(){
        String query = "INSERT INTO [schema].TICKET (USER_ID, SEAT_ID, SHOW_ID) VALUES (?,?,?)".replace("[schema]", Schema);
        
        boolean isInserted = false;
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, this.user.getId());
            pstmt.setInt(2, this.seat.getId());
            pstmt.setInt(3, this.show.getId());
            
            isInserted = pstmt.executeUpdate() > 0 ? true : false;
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isInserted;
    }
    
    public List<Ticket> SelectByUserId(){
        String query = "SELECT [schema].TICKET.*, [schema].FILM.ID as FILMID, [schema].FILM.NAME as FILMNAME, [schema].FILM.DIRECTOR_NAME as DirectorName, [schema].FILM.DESCRIPTION as FilmDescription, [schema].FILM.RELEASE_DATE as FilmReleaseDate, [schema].FILM.IMAGES as FilmImage, [schema].SEATS.ROW_NUM as ROW_SEATS, [schema].SEATS.COLUMN_NUM as COL_SEATS, [schema].ROOM.ID as ROOM_ID, [schema].ROOM.NAME as ROOM_NAME, [schema].SHOWS.SHOW_DATE as SHOWDATE, [schema].SHOWS.SHOW_TIME as SHOW_TIME FROM [schema].TICKET JOIN [schema].SEATS ON [schema].SEATS.ID = [schema].TICKET.SEAT_ID LEFT JOIN [schema].ROOM ON [schema].ROOM.ID = [schema].SEATS.ROOM_ID JOIN [schema].SHOWS ON [schema].SHOWS.ID = [schema].TICKET.SHOW_ID LEFT JOIN [schema].FILM ON [schema].FILM.ID = [schema].SHOWS.FILM_ID WHERE [schema].TICKET.USER_ID = ?".replace("[schema]", Schema);
        
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, this.user.getId());
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                User user = new User();
                Seat seat = new Seat();
                Room room = new Room();
                Film film = new Film();
                Show show = new Show();
                
                user.setId(rs.getInt("USER_ID"));
                
                seat.setId(rs.getInt("SEAT_ID"));
                seat.setRowNum(rs.getString("ROW_SEATS").charAt(0));
                seat.setColumnNum(rs.getInt("COL_SEATS"));
                
                room.setId(rs.getInt("ROOM_ID"));
                room.setName(rs.getString("ROOM_NAME"));
                
                seat.setRoom(room);
                
                show.setId(rs.getInt("SHOW_ID"));
                show.setDate(rs.getString("SHOWDATE"));
                show.setTime(rs.getString("SHOW_TIME"));
                show.setRoom(room);
                
                film.setId(rs.getInt("FILMID"));
                film.setName(rs.getString("FILMNAME"));
                film.setDirectorName(rs.getString("DIRECTORNAME"));
                film.setDescription(rs.getString("FILMDESCRIPTION"));
                film.setReleaseDate(rs.getString("FILMRELEASEDATE"));
                film.setImage(rs.getString("FILMIMAGE"));
                
                show.setFilm(film);
                
                tickets.add(new Ticket(rs.getInt("ID"), user, seat, show, rs.getString("CREATED_AT")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tickets;
    }
    
    public List<Ticket> SelectAll(){
        String query = "SELECT [schema].TICKET.*, [schema].FILM.ID as FILMID, [schema].FILM.NAME as FILMNAME, [schema].FILM.DIRECTOR_NAME as DirectorName, [schema].FILM.DESCRIPTION as FilmDescription, [schema].FILM.RELEASE_DATE as FilmReleaseDate, [schema].FILM.IMAGES as FilmImage, [schema].SEATS.ROW_NUM as ROW_SEATS, [schema].SEATS.COLUMN_NUM as COL_SEATS, [schema].SEATS.PRICE as SeatPrice, [schema].ROOM.ID as ROOM_ID, [schema].ROOM.NAME as ROOM_NAME, [schema].SHOWS.SHOW_DATE as SHOWDATE, [schema].SHOWS.SHOW_TIME as SHOW_TIME FROM [schema].TICKET JOIN [schema].SEATS ON [schema].SEATS.ID = [schema].TICKET.SEAT_ID LEFT JOIN [schema].ROOM ON [schema].ROOM.ID = [schema].SEATS.ROOM_ID JOIN [schema].SHOWS ON [schema].SHOWS.ID = [schema].TICKET.SHOW_ID LEFT JOIN [schema].FILM ON [schema].FILM.ID = [schema].SHOWS.FILM_ID".replace("[schema]", Schema);
        
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                User user = new User();
                Seat seat = new Seat();
                Room room = new Room();
                Film film = new Film();
                Show show = new Show();
                
                user.setId(rs.getInt("USER_ID"));
                
                seat.setId(rs.getInt("SEAT_ID"));
                seat.setRowNum(rs.getString("ROW_SEATS").charAt(0));
                seat.setColumnNum(rs.getInt("COL_SEATS"));
                seat.setPrice(rs.getDouble("SeatPrice"));
                
                room.setId(rs.getInt("ROOM_ID"));
                room.setName(rs.getString("ROOM_NAME"));
                
                seat.setRoom(room);
                
                show.setId(rs.getInt("SHOW_ID"));
                show.setDate(rs.getString("SHOWDATE"));
                show.setTime(rs.getString("SHOW_TIME"));
                show.setRoom(room);
                
                film.setId(rs.getInt("FILMID"));
                film.setName(rs.getString("FILMNAME"));
                film.setDirectorName(rs.getString("DIRECTORNAME"));
                film.setDescription(rs.getString("FILMDESCRIPTION"));
                film.setReleaseDate(rs.getString("FILMRELEASEDATE"));
                film.setImage(rs.getString("FILMIMAGE"));
                
                show.setFilm(film);
                
                tickets.add(new Ticket(rs.getInt("ID"), user, seat, show, rs.getString("CREATED_AT")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tickets;
    }
    
    public List<Ticket> SelectByDate(){
        String query = "SELECT [schema].TICKET.*, [schema].FILM.ID as FILMID, [schema].FILM.NAME as FILMNAME, [schema].FILM.DIRECTOR_NAME as DirectorName, [schema].FILM.DESCRIPTION as FilmDescription, [schema].FILM.RELEASE_DATE as FilmReleaseDate, [schema].FILM.IMAGES as FilmImage, [schema].SEATS.ROW_NUM as ROW_SEATS, [schema].SEATS.COLUMN_NUM as COL_SEATS, [schema].SEATS.PRICE as SeatPrice, [schema].ROOM.ID as ROOM_ID, [schema].ROOM.NAME as ROOM_NAME, [schema].SHOWS.SHOW_DATE as SHOWDATE, [schema].SHOWS.SHOW_TIME as SHOW_TIME FROM [schema].TICKET JOIN [schema].SEATS ON [schema].SEATS.ID = [schema].TICKET.SEAT_ID LEFT JOIN [schema].ROOM ON [schema].ROOM.ID = [schema].SEATS.ROOM_ID JOIN [schema].SHOWS ON [schema].SHOWS.ID = [schema].TICKET.SHOW_ID LEFT JOIN [schema].FILM ON [schema].FILM.ID = [schema].SHOWS.FILM_ID WHERE [schema].SHOWS.SHOW_DATE = ?".replace("[schema]", Schema);
        
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, this.show.getDate());
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                User user = new User();
                Seat seat = new Seat();
                Room room = new Room();
                Film film = new Film();
                Show show = new Show();
                
                user.setId(rs.getInt("USER_ID"));
                
                seat.setId(rs.getInt("SEAT_ID"));
                seat.setRowNum(rs.getString("ROW_SEATS").charAt(0));
                seat.setColumnNum(rs.getInt("COL_SEATS"));
                seat.setPrice(rs.getDouble("SeatPrice"));
                
                room.setId(rs.getInt("ROOM_ID"));
                room.setName(rs.getString("ROOM_NAME"));
                
                seat.setRoom(room);
                
                show.setId(rs.getInt("SHOW_ID"));
                show.setDate(rs.getString("SHOWDATE"));
                show.setTime(rs.getString("SHOW_TIME"));
                show.setRoom(room);
                
                film.setId(rs.getInt("FILMID"));
                film.setName(rs.getString("FILMNAME"));
                film.setDirectorName(rs.getString("DIRECTORNAME"));
                film.setDescription(rs.getString("FILMDESCRIPTION"));
                film.setReleaseDate(rs.getString("FILMRELEASEDATE"));
                film.setImage(rs.getString("FILMIMAGE"));
                
                show.setFilm(film);
                
                tickets.add(new Ticket(rs.getInt("ID"), user, seat, show, rs.getString("CREATED_AT")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tickets;
    }
    
    public double SelectTotalRevenue(){
        String query = "SELECT SUM([schema].SEATS.PRICE) as TotalRevenue FROM [schema].TICKET JOIN [schema].SEATS ON [schema].TICKET.SEAT_ID = [schema].SEATS.ID".replace("[schema]", Schema);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getDouble("TotalRevenue");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public Ticket SelectById(){
        String query = "SELECT [schema].TICKET.*, [schema].FILM.ID as FILMID, [schema].FILM.NAME as FILMNAME, [schema].FILM.DIRECTOR_NAME as DirectorName, [schema].FILM.DESCRIPTION as FilmDescription, [schema].FILM.RELEASE_DATE as FilmReleaseDate, [schema].FILM.IMAGES as FilmImage, [schema].FILM.TRAILER as FilmTrailer, [schema].SEATS.ROW_NUM as ROW_SEATS, [schema].SEATS.COLUMN_NUM as COL_SEATS, [schema].ROOM.ID as ROOM_ID, [schema].ROOM.NAME as ROOM_NAME, [schema].SHOWS.SHOW_DATE as SHOWDATE, [schema].SHOWS.SHOW_TIME as SHOW_TIME FROM [schema].TICKET JOIN [schema].SEATS ON [schema].SEATS.ID = [schema].TICKET.SEAT_ID LEFT JOIN [schema].ROOM ON [schema].ROOM.ID = [schema].SEATS.ROOM_ID JOIN [schema].SHOWS ON [schema].SHOWS.ID = [schema].TICKET.SHOW_ID LEFT JOIN [schema].FILM ON [schema].FILM.ID = [schema].SHOWS.FILM_ID WHERE [schema].TICKET.ID = ?".replace("[schema]", Schema);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, this.id);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                this.id = rs.getInt("ID");
                
                Room room = new Room();
                Film film = new Film();
                
                this.user = new User();
                this.seat = new Seat();
                this.show = new Show();
                
                this.user.setId(rs.getInt("USER_ID"));
                
                this.seat.setId(rs.getInt("SEAT_ID"));
                this.seat.setRowNum(rs.getString("ROW_SEATS").charAt(0));
                this.seat.setColumnNum(rs.getInt("COL_SEATS"));
                
                room.setId(rs.getInt("ROOM_ID"));
                room.setName(rs.getString("ROOM_NAME"));
                
                this.seat.setRoom(room);
                
                this.show.setId(rs.getInt("SHOW_ID"));
                this.show.setDate(rs.getString("SHOWDATE"));
                this.show.setTime(rs.getString("SHOW_TIME"));
                this.show.setRoom(room);
                
                film.setId(rs.getInt("FILMID"));
                film.setName(rs.getString("FILMNAME"));
                film.setDirectorName(rs.getString("DIRECTORNAME"));
                film.setDescription(rs.getString("FILMDESCRIPTION"));
                film.setReleaseDate(rs.getString("FILMRELEASEDATE"));
                film.setImage(rs.getString("FILMIMAGE"));
                film.setTrailer(rs.getString("FilmTrailer"));
                
                this.show.setFilm(film);
                
                this.createdAt = rs.getString("CREATED_AT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
    
}
