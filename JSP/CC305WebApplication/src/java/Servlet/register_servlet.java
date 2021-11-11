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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "register_servlet", urlPatterns = {"/register_servlet"})
public class register_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        Bean.User userObj = new Bean.User();
        userObj.setUsername(username);
        userObj.setPassword(password);
        
        // check if the user exists in db
        User userModel = new User();
        
        try {
            if(userModel.GetUser(userObj) == null){
                // register the user
                userModel.InsertUser(userObj);
                link = "Registeration.jsp?response=success";
            }else{
                link = "Registeration.jsp?response=user_exists";
            }
        } catch (SQLException ex) {
            Logger.getLogger(register_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }
    
}
