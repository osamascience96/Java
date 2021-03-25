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
@WebServlet(urlPatterns = {"/task_one_servlet"})
public class TaskOneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("random_value", Math.random());
        
        double random_probability = (double) session.getAttribute("random_value");
        
        random_probability = Math.round(random_probability * 100.0) / 100.0;
        
        if(random_probability > 0.5){
            resp.sendRedirect("http://www.google.com");
        }else{
            resp.sendRedirect("http://www.bing.com");
        }
    }
    
}
