/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.Note;
import EJB.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "add_todo_servlet", urlPatterns = {"/add_todo_servlet"})
public class add_todo_servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        if(httpSession.getAttribute("login_credentials") != null){
            String data = req.getParameter("todoinput");
            int userId = ((User)httpSession.getAttribute("login_credentials")).getId();
            
            User user = new User();
            user.setId(userId);
            
            Note noteDAO = new Note();
            
            EJB.Note noteEJB = new EJB.Note();
            noteEJB.setUser(user);
            noteEJB.setData(data);
            
            noteDAO.InsertNote(noteEJB);
            
            resp.sendRedirect("admin");
        }
    }
    
}
