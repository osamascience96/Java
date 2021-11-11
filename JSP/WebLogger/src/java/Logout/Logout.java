/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logout;

import POJO.Log;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "Logout", urlPatterns = {"/logout_servlet"})
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("username");
        
        if(httpSession.getAttribute("log_data") != null){
        Log log = (Log)httpSession.getAttribute("log_data");
            // get the previous time
            long previous_millis = log.GetMilliseconds();
            long current_millis = new Date().getTime();

            log.SetMilliseconds(current_millis - previous_millis);

            httpSession.removeAttribute("log_data");
            httpSession.invalidate();
        }
        
        resp.sendRedirect("/WebLogger/");
    }

}
