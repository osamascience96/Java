/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.google.gson.Gson;
import com.models.Plan;
import com.pojo.User;
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
@WebServlet(name = "plan_servlet", urlPatterns = {"/plan_servlet"})
public class plan_servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String date = req.getParameter("available_date");
        String fromtime = req.getParameter("fromtime");
        String totime = req.getParameter("totime");
        int time_count = Integer.parseInt(req.getParameter("timecount"));
        
        HttpSession httpSession = req.getSession();
        int doctorId = ((User)httpSession.getAttribute("doctor_profile")).getId();
        
        com.pojo.Plan planObj = new com.pojo.Plan();
        planObj.setDoctorId(doctorId);
        planObj.setAvailableDate(date);
        planObj.setFromtime(fromtime);
        planObj.setTotime(totime);
        planObj.setAppointmentsCount(time_count);
        
        Plan planModel = new Plan();
        if(planModel.PlanExists(date, doctorId)){
            response = "plan_exists";
        }else{
            int id = planModel.InsertPlan(planObj);
            
            if(id > 0){
                response = "plan_inserted";
            }else{
                response = "plan_inserted_failed";
            }
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
