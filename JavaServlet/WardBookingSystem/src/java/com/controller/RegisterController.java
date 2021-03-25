/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.conf.Base64Encryption;
import com.service.UserService;
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
@WebServlet("/register_controller_servlet")
public class RegisterController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String email = req.getParameter("useremail");
        String password = req.getParameter("password");
        password = new Base64Encryption(password).GetEncodedString();
        
        // TODO: Insert the user to the db and then redirect the user to the login page
        UserService rs = new UserService();
        boolean response = rs.InsertUser(name, email, password);
        
        if(response){
            resp.sendRedirect("login.html?response=account-created");
        }else {
            resp.sendRedirect("login.html?response=account-not-created");
        }
    }
}
