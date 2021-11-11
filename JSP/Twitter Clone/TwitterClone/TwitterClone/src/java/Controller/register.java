/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.User;
import Model.Register;
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

/**
 *
 * @author osama
 */
@WebServlet(name = "register", urlPatterns = {"/register_servlet"})
public class register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        Register register = new Register();
        
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        // apply the vaidation to the username and password
        
        if(username.length() > 7){
            if(password.length() > 7){
                User user = new User();
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                
                try {
                    if(!(register.checkUser(user))){
                        register.InsertUser(user);
                        link = "register.jsp?response=registration_success";
                    }else{
                        link = "register.jsp?response=user_exists";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                link = "register.jsp?response=password_error";
            }
        }else{
            link = "register.jsp?response=username_error";
        }
        
        
        resp.sendRedirect(link);
    }
    
}
