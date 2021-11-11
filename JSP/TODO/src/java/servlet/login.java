/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.User;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "invalid_credentials";
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        User userDAO = new User();
        
        EJB.User userEJB = new EJB.User();
        userEJB.setEmail(email);
        userEJB.setPassword(password);
        
        userEJB = userDAO.GetUserLogin(userEJB);
        
        if(userEJB != null){
            if(userEJB.getApprovd() == 1){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("login_credentials", userEJB);
                if(userEJB.getUsertype().compareTo("user") == 0){
                    response = "user_login_success";
                    httpSession.setAttribute("user_login", true);
                }else if(userEJB.getUsertype().compareTo("admin") == 0){
                    response = "admin_login_success";
                    httpSession.setAttribute("admin_login", true);
                }
            }else{
                response = "user_login_not_allowed";
            }
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
