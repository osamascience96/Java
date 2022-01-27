/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.User;

/**
 *
 * @author osama
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        String response = "";
        
        User userObj = new model.User().GetUserbyEmailandPass(email, password);
        
        if(userObj != null){
            // correct credentials
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("userObj", userObj);
            
            response = "TherapistController";
        }else{
            response = "login.jsp?response='invalid_credentials'";
        }
        
        resp.sendRedirect(response);
    }
    
}
