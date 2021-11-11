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

/**
 *
 * @author osama
 */
@WebServlet(urlPatterns = {"/task_two_servlet"})
public class TaskTwoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String favourate_language = req.getParameter("language_name");
        if(favourate_language.compareToIgnoreCase("Java") == 0){
            resp.getWriter().println("your favourate Language is " + favourate_language);
        }else{
            resp.sendRedirect("error404.html");
        }
    }
    
}
