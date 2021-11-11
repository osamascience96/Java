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
@WebServlet(name = "update_user", urlPatterns = {"/update_user"})
public class update_user extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        String response = "not_valid";
        
        if(httpSession.getAttribute("admin_login") != null){
            User userDAO = new User();
            
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            
            EJB.User userEjb = new EJB.User();
            userEjb.setId(id);
            userEjb.setName(name);
            userEjb.setUsername(username);
            userEjb.setEmail(email);
            userEjb.setPassword(password);
            
            int userid = userDAO.UpdateUser(userEjb);
            
            if(userid > 0){
                response = "update_success";
            }else{
                response = "update_failed";
            }
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
