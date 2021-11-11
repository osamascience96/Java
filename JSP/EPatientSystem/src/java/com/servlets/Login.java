/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.models.User;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "index.jsp";
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        User userModel = new User();
        com.pojo.User userObj = userModel.GetUser(username);
        
        // check if the userobject is not null
        if(userObj != null){
            // check if the password matches with the provided user object 
            if(password.compareTo(userObj.getPassword()) == 0){
                link = link.concat("?response=login_valid").concat("&type=").concat(userObj.getRole()).concat("&id=").concat(String.valueOf(userObj.getId()));
                // redirect to admin or either patient or doctor interface
            }else{
                link = link.concat("?response=login_invalid");
            }
        }else{
            link = link.concat("?response=user_not_exists");
        }
        
        resp.sendRedirect(link);
    }
    
}
