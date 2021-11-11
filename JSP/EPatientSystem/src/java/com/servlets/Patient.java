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
@WebServlet(name = "Patient", urlPatterns = {"/patient_servlet"})
public class Patient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deleteId = Integer.parseInt(req.getParameter("delete_id"));
        
        com.models.Patient patientModel = new com.models.Patient();
        patientModel.DeletePatient(deleteId);
        
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("patient_list", patientModel.GetPatientList());
        
        resp.sendRedirect("adminPATIENTS.jsp?response=del_success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        
        
        User userModel = new User();
        
        com.pojo.User userObj = new com.pojo.User();
        userObj.setFullname(fullname);
        userObj.setUsername(username);
        userObj.setEmail(email);
        userObj.setPhone(phone);
        userObj.setPassword(password);
        userObj.setRole("patient");
        
        if(userModel.GetUser(username) != null){
            userObj = userModel.GetUser(username);
            if(userObj.getRole().compareTo("patient") == 0){
                response = "patient_exists";
            }else{
                int id = userModel.InsertUser(userObj);
                response = "patient_inserted&id=".concat(String.valueOf(id));

                HttpSession httpSession = req.getSession();
                com.models.Patient patientModel = new com.models.Patient();
                httpSession.setAttribute("patient_list", patientModel.GetPatientList());
            }
        }else{
            int id = userModel.InsertUser(userObj);
            response = "patient_inserted&id=".concat(String.valueOf(id));
            
            HttpSession httpSession = req.getSession();
            com.models.Patient patientModel = new com.models.Patient();
            httpSession.setAttribute("patient_list", patientModel.GetPatientList());
        }
        
        resp.sendRedirect("adminPATIENTS.jsp?response=".concat(response));
    }

}
