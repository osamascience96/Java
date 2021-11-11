/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.User;
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
@WebServlet(name = "user_servlet", urlPatterns = {"/user_servlet"})
public class user_servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "index.jsp";
        
        HttpSession httpSession = req.getSession();
        
        if(httpSession.getAttribute("admin_login") != null){
            User userDAO = new User();
            httpSession.setAttribute("users_list", userDAO.GetAllUsersList());
            
            link = "users.jsp";
        }
        
        resp.sendRedirect(link);
    }
    
}
