package com.login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author osama
 */
@WebServlet("/login")
public class Login extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        
        httpSession.setAttribute("username", request.getParameter("username"));
        httpSession.setAttribute("password", request.getParameter("password"));
        
        Cookie username = new Cookie("username", request.getParameter("username"));
        Cookie password = new Cookie("password", request.getParameter("password"));
        
        username.setMaxAge(60*60*10);
        password.setMaxAge(60*60*10);
        
        response.addCookie(username);
        response.addCookie(password);
        
        response.sendRedirect("main.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getCookies() != null){
            if(req.getCookies().length > 1){
                // validate username and password from file system or database
                resp.sendRedirect("main.jsp");
            }
        }
    }
}
