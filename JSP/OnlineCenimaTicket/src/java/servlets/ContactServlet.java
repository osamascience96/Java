/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.FAQService;

/**
 *
 * @author osama
 */
@WebServlet(name = "ContactServlet", urlPatterns = {"/ContactServlet"})
public class ContactServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String subject = req.getParameter("subject");
        String email = req.getParameter("email");
        String message = req.getParameter("message");
        
        FAQService fAQService = new FAQService(name, email, subject, message);
        String msg = fAQService.DoSubmitMessage();
        
        resp.sendRedirect("contact.jsp?respSub=".concat(msg));
    }
    
}
