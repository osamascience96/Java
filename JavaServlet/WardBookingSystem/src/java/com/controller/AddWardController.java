/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.conf.ImageInputStream;
import com.pojo.Ward;
import com.service.AdminService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet("/addwardcontroller")
public class AddWardController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("ward-name");
        String type = req.getParameter("ward_type");
        String ward_price_per_day = req.getParameter("price_per_day");
        
        Ward ward = new Ward();
        ward.SetName(name);
        ward.SetType(type);
        ward.SetPrice(ward_price_per_day);
//        
        AdminService adminService = new AdminService();
        boolean response = adminService.InsertWard(ward);
//        
        resp.sendRedirect("admin-controller-servlet?admin-mode=ward");
    }
}
