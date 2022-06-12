/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Seat;
import models.Show;
import models.User;
import services.FilmService;
import services.SeatService;
import services.ShowService;
import services.TicketService;

/**
 *
 * @author osama
 */
@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        User user = (User) httpSession.getAttribute("user_session_login");
        int showId = Integer.parseInt(req.getParameter("show"));
        
        String link = "";
        
        if(user != null){
        
            ShowService showService = new ShowService();
            showService.setId(showId);

            Show show = showService.GetById();
            
            FilmService filmService = new FilmService();
            filmService.setId(show.getFilm().getId());
            
            show.setFilm(filmService.GetMovieById());

            SeatService seatService = new SeatService();
            seatService.setRoomId(show.getRoom().getId());

            ArrayList<Seat> seats =  (ArrayList<Seat>) seatService.GetListByRoom();
            req.setAttribute("show", show);
            req.setAttribute("seats", seats);
            
            link = "booking.jsp";
        }else{
            link = "login.jsp";
        }
        
        RequestDispatcher rd = req.getRequestDispatcher(link);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int showId = Integer.parseInt(req.getParameter("show"));
        String seatsCSV = req.getParameter("seats");
        
        String[] seatsArr = seatsCSV.split(",");
        
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user_session_login");
        
        String link = "";
        
        if(user != null){
            TicketService ticketService = new TicketService();
            
            for(String id : seatsArr){
                int seatid = Integer.parseInt(id);
                int userId = user.getId();
                
                ticketService.setSeatId(seatid);
                ticketService.setShowId(showId);
                ticketService.setUserId(userId);
                
                boolean IsInserted = ticketService.DoInsertTicket();
            }
            
            link = "tickets.jsp";
        }else{
            link = "login.jsp";
        }
        
        resp.sendRedirect(link);
    }

}
