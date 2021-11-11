/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.models.User;
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
@WebServlet(name = "PatientLogin", urlPatterns = {"/PatientLogin"})
public class PatientLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "index.jsp";
        int id = Integer.parseInt(req.getParameter("id"));
        // check if id is > 0,
        if(id > 0){
            User userModel = new User();
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("patient_profile", userModel.GetUserById(id));
            link = "patientHOME.jsp";
        }
        
        resp.sendRedirect(link);
    }
    
}
