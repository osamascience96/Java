/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.User;
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
@WebServlet(name = "Login", urlPatterns = {"/login_servlet"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String credential_username_email = req.getParameter("username_email");
        String password = req.getParameter("login_password");
        
        User userObj = new User();
        userObj.setUsername(credential_username_email);
        userObj.setEmail(credential_username_email);
        userObj.setPassword(password);
        
        String path = req.getServletContext().getRealPath("/files/register.json").toString();
        System.out.println(path);
        File.Login loginServlet = new File.Login(path);
        
        userObj = loginServlet.CheckLoginCredentials(userObj);
        
        // saving the userobj to the session
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("user_session", userObj);
        
        // write gson message based on the userobj null or not
        String response = "";
        
        if(userObj != null){
            if(userObj.getType().compareTo("seller") == 0){
                httpSession.setAttribute("is_login_admin", true);
                response = new Gson().toJson("seller_login_success");
            }else if(userObj.getType().compareTo("buyer") == 0){
                httpSession.setAttribute("is_login_user", true);
                response = new Gson().toJson("buyer_login_success");
            }
        }else{
            response = new Gson().toJson("wrong_credentials");
        }
        
        resp.getWriter().println(response);
    }
}
