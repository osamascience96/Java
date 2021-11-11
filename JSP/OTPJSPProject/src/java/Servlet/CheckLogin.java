/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.Login;
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
@WebServlet(name = "CheckLogin", urlPatterns = {"/CheckLogin"})
public class CheckLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        HttpSession httpSession = req.getSession();
        
        Login loginDAO = new Login();
        int loginID = loginDAO.GetUserEmail(email);
        if(loginID > 0){
            String passwordDB = loginDAO.GetUserPassword(loginID);
            if(passwordDB != null){
                if(passwordDB.compareTo(password) == 0){
                    response = "login_success";
                    httpSession.setAttribute("login_approved", true);
                }else{
                    response = "invalid_login";
                }
            }else{
                loginDAO.SetUserPassword(loginID, password);
                response = "login_success";
                httpSession.setAttribute("login_approved", true);
            }
        }else{
            response = "user_not_exists";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
