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
@WebServlet(name = "edit_servlet", urlPatterns = {"/edit_servlet"})
public class edit_servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        
        User userDAO = new User();
        
        EJB.User userObj = userDAO.GetUserById(id);
        
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("edit_user", userObj);
        
        resp.sendRedirect("edituser.jsp");
    }
    
}
