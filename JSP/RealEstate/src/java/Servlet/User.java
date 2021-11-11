/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

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
@WebServlet(name = "User", urlPatterns = {"/user_servlet"})
public class User extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        String path = req.getServletContext().getRealPath("/files/property.json").toString();
        System.out.println(path);
        File.User user = new File.User(path);
        
        httpSession.setAttribute("is_login_user", user.GetAllProperties());
        
        resp.sendRedirect("user.jsp");
    }
    
}
