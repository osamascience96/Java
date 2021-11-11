/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
@WebServlet(name = "User", urlPatterns = {"/user_controller"})
public class User extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        bean.User userObj = (bean.User)httpSession.getAttribute("userObj");
        
        int userId = userObj.getId();
        
        model.User userModel = new model.User();
        try {
            httpSession.setAttribute("userObj", userModel.GetUserObject(userId));
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("profile.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("profile_username");
        String email = req.getParameter("profile_email");
        String password = req.getParameter("profile_password");
        
        HttpSession httpSession = req.getSession();
        
        bean.User userObj = new bean.User();
        userObj.setId(((bean.User)httpSession.getAttribute("userObj")).getId());
        userObj.setUsername(username);
        userObj.setEmail(email);
        userObj.setPassword(password);
        
        model.User userModel = new model.User();
        try {
            userModel.UpdateUser(userObj);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("user_controller");
    }
    
}
