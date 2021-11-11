/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "login_servlet", urlPatterns = {"/login_servlet"})
public class login_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        Bean.User userobj = new Bean.User();
        userobj.setUsername(username);
        userobj.setPassword(password);
        
        User userModel = new User();
        
        try {
            userobj = userModel.CheckCredentials(userobj);
        } catch (SQLException ex) {
            Logger.getLogger(login_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(userobj != null){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user_session", userobj);
            link = "Profile.jsp";
        }else{
            link = "page3.jsp?response=wrong_credentials";
        }
        
        resp.sendRedirect(link);
        
    }
    
}
