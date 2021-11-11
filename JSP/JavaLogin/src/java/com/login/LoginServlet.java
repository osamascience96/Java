/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login;

import com.filehandling.UserHandling;
import com.models.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login_servlet"})
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        
        String link = "";
        
        User user = new User();
        user.SetUserName(email);
        user.SetPassword(password);
        
        UserHandling userHandling = new UserHandling(req.getServletContext().getRealPath("/").concat("WEB-INF\\classes\\com\\filehandling\\user.txt"));
        // check if the user exists
        if(userHandling.UserExists(user)){
            // validate the login credentials
            if(userHandling.UserLoginValidation(user)){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("name", userHandling.GetUserName(user));
                link = "main.jsp";
            }else{
                link = "index.jsp?response=user_login_validation_failed";
            }
        }else{
            link = "index.jsp?response=user_not_exists";
        }
        
        resp.sendRedirect(link);
    }
}
