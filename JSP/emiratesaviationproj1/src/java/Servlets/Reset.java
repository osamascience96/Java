/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.User;
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
@WebServlet(name = "Reset", urlPatterns = {"/reset_servlet"})
public class Reset extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        User userDb = new User();
        
        String response = "";
        
        if(username.isEmpty() || password.isEmpty()){
            response = "login_credentials_missing";
        }else{
            // check the login credentials
            if(userDb.GetUserByLogin(username, password) != null){
                // reset the data
                boolean is_user_updated = userDb.UpdateUserFLName("", "", username, password);
                response = is_user_updated ? "data_reset_success" : "data_reset_failed";
            }else{
                response = "invalid_credentials";
            }
        }
        
        resp.sendRedirect("response.jsp?message=".concat(response));
    }
}
