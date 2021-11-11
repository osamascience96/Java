/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.User;
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
        String password = req.getParameter("password");
        
        User userObj = new User();
        userObj.setUsername(username_email);
        userObj.setEmail(username_email);
        userObj.setPassword(password);
        
        Model.User userModel = new Model.User();
        Model.Category categoryModel = new Model.Category();
        
        try {
            userObj = userModel.Check_login(userObj);
            if(userObj != null){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("is_login", true);
                httpSession.setAttribute("user_session", userObj);
                httpSession.setAttribute("category_list_session", categoryModel.GetCategoryArrayList());
                // fetch products list
                response = "login_success";
            }else{
                response = "login_failed";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String json = new Gson().toJson(response);
        resp.getWriter().println(json);
    }
    
}
