/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FAQ;
import pojo.User;

/**
 *
 * @author osama
 */
@WebServlet(name = "ContactController", urlPatterns = {"/ContactController"})
public class ContactController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("page_name", "contactus");
        RequestDispatcher rd = req.getRequestDispatcher("contactus.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String emailaddress = req.getParameter("emailaddress");
        String message = req.getParameter("message");
        
        User userObj = new model.User().GetUserByEmail(emailaddress);
        
        pojo.FAQ faqObj = new pojo.FAQ();
        faqObj.setUser(userObj);
        faqObj.setFirstName(firstName);
        faqObj.setLastName(lastName);
        faqObj.setEmail(emailaddress);
        faqObj.setMessage(message);
        
        int id = new FAQ().InsertFAQ(faqObj);
        
        String response = id > 0 ? "ContactController?response=success" : "ContactController?response=error";
        
        resp.sendRedirect(response);
    }
    
    
    
}
