/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.User;
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
@WebServlet(name = "Register", urlPatterns = {"/register_controller"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "index.jsp";
        
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        User userObj = new User();
        userObj.setUsername(username);
        userObj.setEmail(email);
        userObj.setPassword(password);
        
        Model.User userModel = new Model.User();
        
        try {
            if(userModel.check_user_exists(userObj) != null){
                // user exists
                link = link.concat("?response=user_exists");
            }else{
                // user not exists
                userModel.InsertUser(userObj);
                link = link.concat("?response=insert_success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }
    
}
