/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.User;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author osama
 */
@WebServlet(name = "Login", urlPatterns = {"/login_controller"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String username_email = req.getParameter("username_email");
        String password = req.getParameter("password");
        
        User userObj = new User();
        userObj.setUsername(username_email);
        userObj.setEmail(username_email);
        userObj.setPassword(password);
        
        model.User userModel = new model.User();
        
        try {
            userObj = userModel.GetUserModel(userObj);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(userObj != null){
            
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("is_login", true);
            httpSession.setAttribute("userObj", userObj);
            
            response = "user_found_" + userObj.getRole();
        }else{
            response = "no_user";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
