/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
@WebServlet(name = "Admin", urlPatterns = {"/admin_controller"})
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        model.User userModel = new model.User();
        
        if(req.getParameter("is_del") != null){
            int id = Integer.parseInt(req.getParameter("id"));
            try {
                userModel.DeleteUser(id);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        HttpSession httpSession = req.getSession();
        try {
            httpSession.setAttribute("users_admin_list", userModel.GetAllUsers());
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("admin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String actionType = req.getParameter("actionType");
        
        int id = 0;
        if(req.getParameter("id") != null){
            id = Integer.parseInt(req.getParameter("id"));
        }
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String role = req.getParameter("role");
        String password = req.getParameter("password");
        
        bean.User userObj = new bean.User();
        userObj.setId(id);
        userObj.setUsername(username);
        userObj.setEmail(email);
        userObj.setRole(role);
        userObj.setPassword(password);
        
        model.User userModel = new model.User();
        
        if(actionType.compareTo("insert") == 0){
            try {
                if(userModel.UserExists(userObj)){
                    response = "user_exists";
                }else{
                    userModel.InserAdmintUser(userObj);
                    response = "user_inserted";
                }
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(actionType.compareTo("update") == 0){
            try {
                userModel.UpdateAdminUser(userObj);
            } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            response = "user_updated";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
