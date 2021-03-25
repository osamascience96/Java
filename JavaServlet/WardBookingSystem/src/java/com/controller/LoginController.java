/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.conf.Base64Encryption;
import com.pojo.Booking;
import com.pojo.User;
import com.service.AdminService;
import com.service.UserService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/login_controller-servlet")
public class LoginController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("useremail");
        String password = new Base64Encryption(req.getParameter("password")).GetEncodedString();
//        String password = req.getParameter("password");
        
        UserService us = new UserService();
        boolean response = us.CheckUserLoginData(email, password);
        
        // Getting data from user service
        User userPojo = us.GetUserData(email);

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("User", userPojo);
        
        if(response){
            // check if the login and password are of the admin 
            if(email.equals("admin21@ward.com")){
                resp.sendRedirect("admin-controller-servlet?admin-mode=admin");
            }else{
                // open the user interface
                resp.sendRedirect("customer-controller-servlet?customer-mode=default");
            }
        }else{
            resp.sendRedirect("login.html?response=wrong-login");
        }
    }
}
