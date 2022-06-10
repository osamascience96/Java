/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.UserService;

/**
 *
 * @author osama
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        UserService userService = new UserService(email, password);
        User user = userService.DoLogin();
        
        String response = "";
        
        if(user != null){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user_session_login", user);
            
            response = req.getContextPath();
        }else{
            response = "login.jsp?respLogin=Failed";
        }
        
        resp.sendRedirect(response);
    }
}
