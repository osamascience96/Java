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
@WebServlet("/editusercontroller")
public class EditUserController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("userid");
        String name = req.getParameter("user_name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String nationality = req.getParameter("nationality");
        String gender = req.getParameter("gender");
        String status = req.getParameter("status");
        String dob = req.getParameter("dob");
        
        
        boolean response = new AdminService().EditUser(new User(Integer.parseInt(user_id), name, email, "", gender, phone, status, nationality, dob));
        
        resp.sendRedirect("admin-controller-servlet?admin-mode=users");
    }
    
}
