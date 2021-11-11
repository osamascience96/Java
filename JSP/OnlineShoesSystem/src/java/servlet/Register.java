/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
        String link = "register.jsp";
        
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        User userModel = new User();
        
        bean.User userObj = new bean.User();
        userObj.setName(name);
        userObj.setUsername(username);
        userObj.setEmail(email);
        userObj.setPassword(password);
        
        try {
            if(userModel.GetUser(userObj) != null){
                link = link.concat("?response=").concat("user_exists");
            }else{
                try {
                    userModel.InsertUser(userObj);
                } catch (SQLException ex) {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                link = link.concat("?response=").concat("record_inserted");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }
}
