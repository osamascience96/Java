/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.pojo.User;
import com.service.AdminService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet("/editprofilecontroller")
public class EditProfileController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService adminService = new AdminService();
        
        String user_id = req.getParameter("user_id");
        String name = req.getParameter("full-name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String martial_status = req.getParameter("martial-status");
        String nationality = req.getParameter("nationality");
        String date_of_birth = req.getParameter("date-of-birth");
        
        User user = new User();
        user.SetId(Integer.parseInt(user_id));
        user.SetName(name);
        user.SetPhone(phone);
        user.SetEmail(email);
        user.SetGender(gender);
        user.SetStatus(martial_status);
        user.SetNationality(nationality);
        user.SetDateOfBirth(date_of_birth);
        
        boolean response = adminService.UpdateUserProfileDB(user);
        resp.sendRedirect("customer-controller-servlet?customer-mode=default");
    }
    
}
