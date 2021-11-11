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
@WebServlet(name = "Doctor", urlPatterns = {"/doctor_servlet"})
public class Doctor extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deleteId = Integer.parseInt(req.getParameter("delete_id"));
        
        com.models.Doctor doctorModel = new com.models.Doctor();
        doctorModel.DeleteDoctor(deleteId);
        
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("doctor_list", doctorModel.GetDoctorList());
        
        resp.sendRedirect("adminDOCTORS.jsp?response=del_success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String fullname = req.getParameter("fullname");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String profession = req.getParameter("profession");
        
        User userModel = new User();
        
        com.pojo.User userObj = new com.pojo.User();
        userObj.setFullname(fullname);
        userObj.setUsername(username);
        userObj.setEmail(email);
        userObj.setPhone(phone);
        userObj.setPassword(password);
        userObj.setProfession(profession);
        userObj.setRole("doctor");
        
        if(userModel.GetUser(username) != null){
            userObj = userModel.GetUser(username);
            if(userObj.getRole().compareTo("doctor") == 0){
                response = "doctor_exists";
            }else{
                int id = userModel.InsertUser(userObj);
                response = "doctor_inserted&id=".concat(String.valueOf(id));

                HttpSession httpSession = req.getSession();
                com.models.Doctor doctorModel = new com.models.Doctor();
                httpSession.setAttribute("doctor_list", doctorModel.GetDoctorList());
            }
        }else{
            int id = userModel.InsertUser(userObj);
            response = "doctor_inserted&id=".concat(String.valueOf(id));

            HttpSession httpSession = req.getSession();
            com.models.Doctor doctorModel = new com.models.Doctor();
            httpSession.setAttribute("doctor_list", doctorModel.GetDoctorList());
        }
        
        resp.sendRedirect("adminDOCTORS.jsp?response=".concat(response));
    }

}
