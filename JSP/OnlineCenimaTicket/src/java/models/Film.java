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
public class Film extends Confs{
    // member variables
    public int id;
    public String name;
    public String directorName;
    public Genre genre;
    public Show show;
    public String description;
    public String releaseDate;
    public String trailer;
    public String image;
    public boolean isReleased;
    public String createdAt;
    
    // db connection
    public Connection connection;

    public Film() {
        this.connection = Connector.getConnectionInstance().getConnection();
    }

    public Film(int id, String name, String directorName, Genre genre, String description, String releaseDate, String trailer, String image, boolean isReleased, String createdAt) {
        this.id = id;
        this.name = name;
        this.directorName = directorName;
        this.genre = genre;
        this.description = description;
        this.releaseDate = releaseDate;
        this.trailer = trailer;
        this.image = image;
        this.isReleased = isReleased;
        this.createdAt = createdAt;
    }
    
    public Film SelectById(){
        String query = "SELECT [schema].FILM.*, [schema].GENRE.NAME AS GENRENAME FROM [schema].FILM JOIN [schema].GENRE ON [schema].GENRE.ID = [schema].FILM.GENRE_ID WHERE [schema].FILM.ID = ?".replace("[schema]", Schema);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, this.id);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                this.genre = new Genre();
                genre.setId(rs.getInt("GENRE_ID"));
                genre.setName(rs.getString("GENRENAME"));
                
                this.id = rs.getInt("ID");
                this.name = rs.getString("NAME");
                this.directorName = rs.getString("DIRECTOR_NAME");
                this.description = rs.getString("DESCRIPTION");
                this.releaseDate = rs.getString("RELEASE_DATE");
                this.trailer = rs.getString("TRAILER");
                this.image = rs.getString("IMAGES");
                this.isReleased  = rs.getBoolean("ISRELEASED");
                this.createdAt = rs.getString("CREATED_AT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Film.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this;
    }
    
    public List<Film> SelectComingMovies(){
        ArrayList<Film> films = new ArrayList<>();
        
        String query = "SELECT [schema].FILM.*, [schema].GENRE.NAME AS GENRENAME FROM [schema].FILM JOIN [schema].GENRE ON [schema].GENRE.ID = [schema].FILM.GENRE_ID WHERE [schema].FILM.ISRELEASED = false FETCH FIRST 4 ROWS ONLY".replace("[schema]", Schema);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Genre genre = new Genre();
                genre.setId(rs.getInt("GENRE_ID"));
                genre.setName(rs.getString("GENRENAME"));
                
                films.add(new Film(rs.getInt("ID"), rs.getString("NAME"), rs.getString("DIRECTOR_NAME"), genre, rs.getString("DESCRIPTION"), rs.getString("RELEASE_DATE"), rs.getString("TRAILER"), rs.getString("IMAGES"), rs.getBoolean("ISRELEASED"), rs.getString("CREATED_AT")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Film.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return films;
    }
    
    public List<Film> SelectAllMovies(){
        ArrayList<Film> films = new ArrayList<>();
        
        String query = "SELECT [schema].FILM.*, [schema].ROOM.NAME as ROOMNAME, [schema].SHOWS.ID as SHOWID, [schema].SHOWS.SHOW_DATE as SHOWDATE, [schema].SHOWS.SHOW_TIME as SHOWTIME, [schema].GENRE.NAME AS GENRENAME FROM [schema].FILM JOIN [schema].GENRE ON [schema].GENRE.ID = [schema].FILM.GENRE_ID LEFT JOIN [schema].SHOWS ON [schema].SHOWS.FILM_ID = [schema].FILM.ID LEFT JOIN [schema].ROOM ON [schema].ROOM.ID = [schema].SHOWS.ROOM_ID".replace("[schema]", Schema);
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Genre genre = new Genre();
                genre.setId(rs.getInt("GENRE_ID"));
                genre.setName(rs.getString("GENRENAME"));
                
                Show show = null;
                
                if(rs.getString("ROOMNAME") != null){
                    Room room = new Room();
                    room.setName(rs.getString("ROOMNAME"));
                    
                    show = new Show();
                    show.setId(rs.getInt("SHOWID"));
                    show.setRoom(room);
                    show.setDate(rs.getString("SHOWDATE"));
                    show.setTime(rs.getString("SHOWTIME"));
                }
                
                
                Film film = new Film(rs.getInt("ID"), rs.getString("NAME"), rs.getString("DIRECTOR_NAME"), genre, rs.getString("DESCRIPTION"), rs.getString("RELEASE_DATE"), rs.getString("TRAILER"), rs.getString("IMAGES"), rs.getBoolean("ISRELEASED"), rs.getString("CREATED_AT"));
                film.setShow(show);
                
                films.add(film);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Film.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return films;
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

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIsReleased() {
        return isReleased;
    }

    public void setIsReleased(boolean isReleased) {
        this.isReleased = isReleased;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
