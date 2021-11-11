/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import EJB.User;
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
@WebServlet(name = "update_user_status", urlPatterns = {"/update_user_status"})
public class update_user_status extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("user_id"));
        int status = Integer.parseInt(req.getParameter("status"));
        
        DAO.User userDAO = new DAO.User();
        
        int is_user_status = userDAO.UpdateUserStatus(userId, status);
        
        resp.sendRedirect("user_servlet");
    }
    
}
