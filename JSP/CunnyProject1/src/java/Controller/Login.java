/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.Student;
import Database.ConnectionStatus;
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
@WebServlet(name = "Login", urlPatterns = {"/login_controller"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String username = req.getParameter("ID");
        String password = req.getParameter("password");
        
        ConnectionStatus connectionStatus = new ConnectionStatus(username, password);
        
        if(connectionStatus.CheckValidConnection()){
            HttpSession session = req.getSession();
            session.setAttribute("is_login", true);
            response = "valid_credentials";
        }else{
            response = "invalid_credentials";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
