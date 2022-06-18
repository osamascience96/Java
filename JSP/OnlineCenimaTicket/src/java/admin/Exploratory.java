/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Show;
import services.ShowService;

/**
 *
 * @author osama
 */
@WebServlet(name = "Exploratory", urlPatterns = {"/Exploratory"})
public class Exploratory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        if(httpSession.getAttribute("adminuser") != null){
            ShowService showService = new ShowService();
            ArrayList<Show> showsTicketsCount = (ArrayList<Show>) showService.GetShowsTicketsCount();
            
            Set<String> datesSet = new HashSet<String>();
            for(Show show : showsTicketsCount){
                // add the dates to the set
                String date = show.getDate();
                datesSet.add(date);
            }
            
            JsonArray jsonDates = new JsonArray();
            JsonArray showsCountArr = new JsonArray();
            JsonArray ticketsCountArr = new JsonArray();
            
            for(Object date : datesSet.toArray()){
                String dateStr = date.toString();
                jsonDates.add(dateStr);
                
                int countShows = 0;
                int countTickets = 0;
                
                for(Show show : showsTicketsCount){
                    if(dateStr.compareTo(show.getDate()) == 0){
                        countTickets += show.getTicketsCount();
                        countShows++;
                    }
                }
                
                showsCountArr.add(countShows);
                ticketsCountArr.add(countTickets);
            }
            
            JsonArray jsonArr = new JsonArray();
            jsonArr.add(jsonDates);
            jsonArr.add(showsCountArr);
            jsonArr.add(ticketsCountArr);
            
            Gson gson = new Gson();
            
            resp.getWriter().println(gson.toJson(jsonArr));
        }
    }
    
}
