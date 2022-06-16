/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import helper.DateAndTime;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Ticket;
import models.User;
import services.ShowService;
import services.TicketService;
import services.UserService;

/**
 *
 * @author osama
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String view = "auth/";
        HttpSession httpSession = req.getSession();
        
        String message = req.getParameter("message");
        
        
        if(httpSession.getAttribute("adminuser") != null){
            view = view.concat("index.jsp");
            
            ShowService showService = new ShowService();
            TicketService ticketService = new TicketService();
            
            String currentDate = DateAndTime.GetDate();
            showService.setShowDate(currentDate);
            
            ArrayList<Ticket> tickets = (ArrayList<Ticket>) ticketService.GetTicketsByDate(currentDate);
            
            req.setAttribute("today_show_list", showService.GetByDate());
            req.setAttribute("today_tickets_list", tickets);
            
            double todayRevenue = 0;
            for(Ticket ticket : tickets){
                todayRevenue += ticket.getSeat().getPrice();
            }
            
            req.setAttribute("today_revenue", todayRevenue);
            req.setAttribute("total_revenue", ticketService.GetTotalRevenue());
            
            RequestDispatcher rd = req.getRequestDispatcher(view);
            rd.forward(req, resp);
        }else{
            if(message != null){
                view = view.concat("signin.jsp?error=".concat(message));
            }else{
                view = view.concat("signin.jsp");
            }

            resp.sendRedirect(view);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        UserService userService = new UserService();
        userService.setEmail(email);
        userService.setPassword(password);
        
        String message = "";
        
        User user = userService.LoginAdmin();
        
        if(user != null){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("adminuser", user);
        }else{
            message = "login_failed";
        }
        
        resp.sendRedirect(req.getContextPath().concat("/admin").concat("?message=").concat(message));
    }
    
}
