/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Seat;
import models.Show;
import models.Ticket;
import models.User;

/**
 *
 * @author osama
 */
public class TicketService {
    private int id;
    private int userId;
    private int seatId;
    private int showId;
    
    private Ticket ticket;
    

    public TicketService() {
        this.ticket = new Ticket();
    }

    public TicketService(int id, int userId, int seatId, int showId) {
        this.id = id;
        this.userId = userId;
        this.seatId = seatId;
        this.showId = showId;
        
        this.ticket = new Ticket();
    }
    
    public boolean DoInsertTicket(){
        User user = new User();
        user.setId(this.userId);
        
        Seat seat = new Seat();
        seat.setId(this.seatId);
        
        Show show = new Show();
        show.setId(this.showId);
        
        this.ticket.user = user;
        this.ticket.seat = seat;
        this.ticket.show = show;
        
        return this.ticket.InsertTicket();
    }
    
    public List<Ticket> GetTicketsByUserId(){
        User user = new User();
        user.setId(this.userId);
        
        this.ticket.setUser(user);
        
        return this.ticket.SelectByUserId();
    }
    
    public List<Ticket> GetTicketsByDate(String date){
        Show show = new Show();
        show.setDate(date);
        
        this.ticket.setShow(show);
        return this.ticket.SelectByDate();
    }
    
    public double GetTotalRevenue(){
        return this.ticket.SelectTotalRevenue();
    }
    
    public Ticket GetTicketById(){
        this.ticket.id = this.id;
        
        return this.ticket.SelectById();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }
}
