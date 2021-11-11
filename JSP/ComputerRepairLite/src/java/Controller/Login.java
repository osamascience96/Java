/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import POJO.User;
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
        String link = "";
        
        String credenital_username_email = req.getParameter("credentials_1");
        String password = req.getParameter("password");
        
        User userObj = new User();
        userObj.setEmail(credenital_username_email);
        userObj.setUsername(credenital_username_email);
        userObj.setPassword(password);
        
        Model.User userModel = new Model.User();
        
        try {
            userObj = userModel.CheckUserbyCredentials(userObj);
            if(userObj != null){
                // create the session that stores the login credentials 
                HttpSession session = req.getSession();
                session.setAttribute("is_login", true);
                session.setAttribute("userObj", userObj);
                link = "index.jsp?response=success_login";
            }else{
                link = "login.jsp?response=user_credentials_error";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }
    
}
