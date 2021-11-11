/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.User;
import Helper.DateTimeHelper;
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
@WebServlet(name = "Register", urlPatterns = {"/register_servlet"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String type = req.getParameter("usertype");
        String date = DateTimeHelper.GetCurrentDateTimeStamp();
        
        User userObj = new User();
        userObj.setName(name);
        userObj.setUsername(username);
        userObj.setEmail(email);
        userObj.setPassword(password);
        userObj.setType(type);
        userObj.setDate(date);
        
        String path = req.getServletContext().getRealPath("/files/register.json").toString();
        System.out.println(path);
        File.Register registerFile = new File.Register(path);
        String response = registerFile.InsertData(userObj);
        
        resp.sendRedirect("index.jsp?response=".concat(response));
    }
}
