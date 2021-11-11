/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Database.User;
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
@WebServlet(name = "Update", urlPatterns = {"/update_servlet"})
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String lastname = req.getParameter("last_name");
        String firstname = req.getParameter("first_name");
        
        String response = "";
        
        if(username.isEmpty() || password.isEmpty() || lastname.isEmpty() || firstname.isEmpty()){
            response = "field_missing";
        }else{
            // check if the username exists 
            User userDb = new User();
            if(userDb.GetUserByusername(username) != null){
                // check the username password
                if(userDb.GetUserByLogin(username, password) != null){
                    // update the data
                    boolean is_updated = userDb.UpdateUserFLName(firstname, lastname, username, password);
                    response = (is_updated ? "user_updated" : "user_not_updated").concat("&firstname=").concat(firstname).concat("&lastname=").concat(lastname);
                }else{
                    response = "invalid_credentials";
                }
            }else{
                // insert the user 
                boolean is_inserted = userDb.InsertUser(username, password, firstname, lastname);
                response = (is_inserted ? "user_updated" : "user_not_updated").concat("&firstname=").concat(firstname).concat("&lastname=").concat(lastname);
            }
        }
        
        resp.sendRedirect("response.jsp?message=".concat(response));
    }
    
}
