/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
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
import model.User;

/**
 *
 * @author osama
 */
@WebServlet(name = "Register", urlPatterns = {"/register_controller"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        bean.User userObj = new bean.User();
        userObj.setUsername(username);
        userObj.setEmail(email);
        userObj.setPassword(password);
        
        User userModel = new User();
        
        try {
            if(userModel.UserExists(userObj)){
                response = "user_exists";
            }else{
                userModel.InsertUser(userObj);
                response = "user_inserted";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
