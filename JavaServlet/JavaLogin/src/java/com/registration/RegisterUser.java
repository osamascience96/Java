/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registration;

import com.filehandling.UserHandling;
import com.models.User;
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
@WebServlet(name = "RegisterUser", urlPatterns = {"/register_user"})
public class RegisterUser extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        String final_response = "";
        UserHandling userHandling = new UserHandling(req.getServletContext().getRealPath("/").concat("WEB-INF\\classes\\com\\filehandling\\user.txt"));
        
        if(!userHandling.UserExists(new User(first_name, last_name, email, password))){
            boolean response = userHandling.WriteUserFile(new User(first_name, last_name, email, password));
            final_response = response == true ? "user_created" : "user_not_created";
        }else{
            final_response = "user_exists";
        }
        
        resp.sendRedirect("register.jsp?write_response=".concat(final_response));
    }
}
