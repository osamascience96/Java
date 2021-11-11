/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Model.User;
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
@WebServlet(name = "Login", urlPatterns = {"/login_servlet"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String username_email = req.getParameter("username_email");
        String password = req.getParameter("password_login");
        
        User userModel = new User();
        
        bean.User userObj = new bean.User();
        userObj.setUsername(username_email);
        userObj.setEmail(username_email);
        userObj.setPassword(password);
        
        try {
            userObj = userModel.GetUser(userObj);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // if the user object is null
        if(userObj != null){
            // check if the password is correct
            if(password.compareTo(userObj.getPassword()) == 0){
                response = "password_correct";
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("is_login", true);
                httpSession.setAttribute("user_obj", userObj);
            }else{
                response = "password_incorrect";
            }
        }else{
            response = "user_not_exists_with_username_or_email";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
}
