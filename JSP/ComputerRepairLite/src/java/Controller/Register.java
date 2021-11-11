/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
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

/**
 *
 * @author osama
 */
@WebServlet(name = "Register", urlPatterns = {"/register_servlet"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        POJO.User userObj = new POJO.User();
        userObj.setFullname(fullname);
        userObj.setUsername(username);
        userObj.setEmail(email);
        userObj.setPassword(password);
        
        User userModel = new User();
        
        try {
            if(!(userModel.CheckUserExistance(userObj))){
                userModel.InsertUser(userObj);
                link = "register.jsp?response=user_insert_success";
            }else{
                link = "register.jsp?response=user_exists";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }
    
}
