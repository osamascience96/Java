/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.models.Doctor;
import com.models.Patient;
import com.models.User;
import java.io.IOException;
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
@WebServlet(name = "Admin", urlPatterns = {"/admin_servlet"})
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "index.jsp";
        
        int id = req.getParameter("id") != null ? Integer.parseInt(req.getParameter("id")) : 0;
        
        if(id != 0){
            User userModel = new User();
            Patient patientModel = new Patient();
            Doctor doctorModel = new Doctor();
            
            com.pojo.User userObj = userModel.GetUserById(id);
            ArrayList<com.pojo.User> patientArrayList = patientModel.GetPatientList();
            ArrayList<com.pojo.User> doctorArrayList = doctorModel.GetDoctorList();
            
            if(userObj != null){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("admin_user", userObj);
                httpSession.setAttribute("patient_list", patientArrayList);
                httpSession.setAttribute("doctor_list", doctorArrayList);
                link = "adminHOME.jsp";
            }
        }
        
        resp.sendRedirect(link);
    }
    
    
}
