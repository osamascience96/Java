/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author osama
 */
@WebServlet(urlPatterns = {"/task_three_servlet"})
public class TaskThreeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        int count = 0;
        String link = "";
        
        if(httpSession.getAttribute("count") != null){
            count = (int) httpSession.getAttribute("count");
            httpSession.setAttribute("count", ++count);
        }else{
            httpSession.setAttribute("count", count);
        }
        
        if(count < 9){
            link = "https://www.washingtonpost.com/";
        }else{
            link = "https://www.nytimes.com/";
            httpSession.setAttribute("count", 0);
        }
        
        resp.sendRedirect(link);
    }
    
}
