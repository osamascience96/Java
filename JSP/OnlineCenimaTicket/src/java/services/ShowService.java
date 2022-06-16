/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Show;

/**
 *
 * @author osama
 */
public class ShowService {
    private int id;
    private int filmId;
    private int roomId;
    private String showDate;
    private String showTime;
    
    private Show show;

    public ShowService() {
        this.show = new Show();
    }

    public ShowService(int id, int filmId, int roomId, String showDate, String showTime) {
        this.id = id;
        this.filmId = filmId;
        this.roomId = roomId;
        this.showDate = showDate;
        this.showTime = showTime;
        
        this.show = new Show();
    }
    
    public Show GetById(){
        this.show.id = this.id;
        
        return this.show.SelectById();
    }
    
    public List<Show> GetByDate(){
        this.show.date = this.showDate;
        
        return this.show.SelectByShowDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
    
}
