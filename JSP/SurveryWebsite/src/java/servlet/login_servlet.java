/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.User;

/**
 *
 * @author osama
 */
@WebServlet(name = "login_servlet", urlPatterns = {"/login_servlet"})
public class login_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        User userModel = new User();
        
        bean.User userBean = userModel.GetUser(email);
        
        // check if the userBean is not null
        if(userBean != null){
            HttpSession httpSession = req.getSession();
            // check the provided user password 
            if(password.compareTo(userBean.getPassword()) == 0){
                httpSession.setAttribute("userbean", userBean);
                response = "login_success_".concat(userBean.getType());
            }else{
                response = "invalid_password";
            }
        }else{
            response = "user_not_exists";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
