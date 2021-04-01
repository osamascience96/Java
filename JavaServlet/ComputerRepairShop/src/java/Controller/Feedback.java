/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
@WebServlet(name = "Feedback", urlPatterns = {"/Feedback"})
public class Feedback extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String type = req.getParameter("type_options");
        String subject = req.getParameter("subject");
        String message = req.getParameter("messages");
        
        POJO.Feedback feedback = new POJO.Feedback();
        feedback.SetName(name);
        feedback.SetCountry(country);
        feedback.SetPhone(phone);
        feedback.SetEmail(email);
        feedback.SetType(type);
        feedback.SetSubject(subject);
        feedback.SetMessage(message);
        
        Model.Feedback feedbackModel = new Model.Feedback();
        feedbackModel.InsertFeedback(feedback);
        
        resp.sendRedirect("index.jsp?response=feedback_add_success");
    }
    
}
