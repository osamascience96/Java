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
@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        if(httpSession.getAttribute("login_credentials") != null){
            
            int userId = ((User)httpSession.getAttribute("login_credentials")).getId();
            
            Note noteDAO = new Note();
            
            ArrayList<EJB.Note> noteArrayLIst = noteDAO.GetAllNotes(userId);
            httpSession.setAttribute("notelist", noteArrayLIst);
            
            resp.sendRedirect("admin.jsp");
        }else{
            resp.sendRedirect("index.jsp");
        }
    }
    
}
