/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "register.jsp";
        
        String fullname = req.getParameter("name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String number = req.getParameter("number");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");
        
        // compare the password and compare password
        if(password.compareTo(confirm_password) != 0){
            link = link.concat("?response=password_unmatched");
        }else{
            // validate email and phone
            boolean is_email_valid = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\")){7,}@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(email).matches();
            boolean is_phone_valid = Pattern.compile("^[0-9]{11}$").matcher(number).matches() || Pattern.compile("^[0-9]{12}$").matcher(number).matches();
            
            if(!is_email_valid){
                link = link.concat("?response=email_invalid");
            }else if(!is_phone_valid){
                link = link.concat("?response=phone_invalid");
            }else{
                // check if the user exists
                User userModel = new User();
                com.pojo.User userPojo = userModel.GetUser(username);
                if(userPojo != null){
                    link = link.concat("?response=user_exists");
                }else{
                    userPojo = new com.pojo.User();
                    userPojo.setFullname(fullname);
                    userPojo.setUsername(username);
                    userPojo.setEmail(email);
                    userPojo.setPhone(number);
                    userPojo.setPassword(password);
                    userPojo.setRole("patient");
                    int id = userModel.InsertUser(userPojo);
                    link = "index.jsp?created_user=".concat(String.valueOf(id));
                }
            }
        }
        
        resp.sendRedirect(link);
    }

}
