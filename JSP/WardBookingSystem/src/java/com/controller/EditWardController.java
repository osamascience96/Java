/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.pojo.Ward;
import com.service.AdminService;
import java.io.IOException;
import java.sql.Blob;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet("/editwardcontroller")
public class EditWardController extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ward_id = req.getParameter("ward_id");
        String ward_name = req.getParameter("ward-name");
        String ward_type = req.getParameter("ward_type");
        String ward_status = req.getParameter("ward_status");
        String ward_price_per_day = req.getParameter("price_per_day");
        
        AdminService adminService = new AdminService();
        Ward ward = new Ward(Integer.parseInt(ward_id), ward_name, ward_type, null, null, null);
        ward.SetStatus(Integer.parseInt(ward_status));
        ward.SetPrice(ward_price_per_day);
        boolean response = adminService.EditWard(ward);
        
        resp.sendRedirect("admin-controller-servlet?admin-mode=ward");
    }
}
