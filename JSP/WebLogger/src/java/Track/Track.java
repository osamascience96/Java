/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Track;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
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
@WebServlet(name = "Track", urlPatterns = {"/track_servlet"})
public class Track extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // check if the session contains the admin user 
        HttpSession httpSession = req.getSession();
        
        String allow = req.getParameter("allow");
        
        if(allow.compareTo("true") == 0){
            if(httpSession.getAttribute("username") != null){
                String username = (String) httpSession.getAttribute("username");

                if(username.compareTo("admin321321") == 0){
                    ServletContext servletContext = req.getServletContext();
                    servletContext.setAttribute("tracking", true);
                }
            }
        }else{
            if(httpSession.getAttribute("username") != null){
                String username = (String) httpSession.getAttribute("username");

                if(username.compareTo("admin321321") == 0){
                    ServletContext servletContext = req.getServletContext();
                    servletContext.setAttribute("tracking", false);
                }
            }
        }
        
        resp.sendRedirect("admin.jsp");
    }
    
}
