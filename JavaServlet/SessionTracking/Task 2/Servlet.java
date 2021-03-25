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
@WebServlet(urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("firstname");
        String last_name = req.getParameter("lastname");
        String email_address = req.getParameter("emailaddress");
        
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("visitor") == null){
            // first time visitor
            
            if(first_name.isEmpty()){
                httpSession.setAttribute("firstname", "Unknown");
            }else{
                httpSession.setAttribute("firstname", first_name);
            }
            if(last_name.isEmpty()){
                httpSession.setAttribute("lastname", "Unknown");
            }else{
                httpSession.setAttribute("lastname", last_name);
            }
            if(email_address.isEmpty()){
                httpSession.setAttribute("emailaddress", "Unknown");
            }else{
                httpSession.setAttribute("emailaddress", email_address);
            }
            
            // set the visitor parameter to true
            httpSession.setAttribute("visitor", true);
        }else{
            boolean visitor = (boolean) httpSession.getAttribute("visitor");
            
            if(visitor){
                if(first_name.isEmpty()){
                    httpSession.setAttribute("firstname", httpSession.getAttribute("firstname"));
                }else{
                    httpSession.setAttribute("firstname", first_name);
                }
                if(last_name.isEmpty()){
                    httpSession.setAttribute("lastname", httpSession.getAttribute("lastname"));
                }else{
                    httpSession.setAttribute("lastname", last_name);
                }
                if(email_address.isEmpty()){
                    httpSession.setAttribute("emailaddress", httpSession.getAttribute("emailaddress"));
                }else{
                    httpSession.setAttribute("emailaddress", email_address);
                }
            }
        }
        
        resp.sendRedirect("index.jsp");
    }
    
}
