/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import EJB.User;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "register_servlet", urlPatterns = {"/register_servlet"})
public class register_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        User userObj = new User();
        userObj.setName(fullname);
        userObj.setEmail(email);
        userObj.setUsername(username);
        userObj.setPassword(password);
        userObj.setUsertype("user");
        
        DAO.User userDAO = new DAO.User();
        
        if(userDAO.GetUserExists(userObj) == null){
            int is_user_inserted = userDAO.InsertUser(userObj);

            if(is_user_inserted > 0){
                response = "user_inserted_success";
            }else{
                response = "user_not_inserted";
            }
        }else{
            response = "user_already_exists";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
