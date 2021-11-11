/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Task;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "TaskServlet", urlPatterns = {"/task_servlet"})
public class TaskServlet extends HttpServlet {
    private Task taskModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String request_type = req.getParameter("request_type");
        
        this.taskModel = new Task();
        
        String link = "tasks.jsp";
        
        if(request_type != null){
            if(request_type.compareToIgnoreCase("delete") == 0){
                // get the id
                int id = Integer.parseInt(req.getParameter("task_id"));
                try {
                    this.taskModel.deleteTask(id);
                    this.taskModel.deleteEmployeeTask(id);
                } catch (SQLException ex) {
                    Logger.getLogger(TaskServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                link = "task_servlet?response=delete_success";
            }
        }else{
            ArrayList<com.pojo.Task> arrayListTask = null;

            try {
                arrayListTask = this.taskModel.GetAllTasksDB();
            } catch (SQLException ex) {
                Logger.getLogger(TaskServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("tasklist", arrayListTask);
            
            if(req.getParameter("response") != null){
                String response = req.getParameter("response");
                link = link.concat("?response=").concat(response);
            }
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.taskModel = new Task();
        
        String link = "";
        
        String request_type = req.getParameter("request_type");
        
        String taskname = req.getParameter("taskname");
        String taskdescription = req.getParameter("taskdescription");
        int duration = Integer.parseInt(req.getParameter("duration"));
        
        if(request_type != null){
            if(request_type.compareToIgnoreCase("insert") == 0){
                
                String date = req.getParameter("date");
                String time = req.getParameter("time");
                
                com.pojo.Task taskObject = new com.pojo.Task();
                taskObject.SetName(taskname);
                taskObject.SetDescription(taskdescription);
                taskObject.SetDuration(duration);
                taskObject.SetCreatedAt(date.concat(" ").concat(time));
                
                try {
                    if(!this.taskModel.CheckTaskExistance(taskname)){
                        this.taskModel.InsertTask(taskObject);
                        link = "task_servlet?response=insert_success";
                    }else{
                        link = "task_servlet?response=task_exists";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TaskServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(request_type.compareToIgnoreCase("update") == 0){
                
                int id = Integer.parseInt(req.getParameter("task_id"));
                
                com.pojo.Task taskObject = new com.pojo.Task();
                taskObject.SetId(id);
                taskObject.SetName(taskname);
                taskObject.SetDescription(taskdescription);
                taskObject.SetDuration(duration);
                
                try {
                    this.taskModel.UpdateTask(taskObject);
                    link = "task_servlet?response=update_success";
                } catch (SQLException ex) {
                    Logger.getLogger(TaskServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        resp.sendRedirect(link);
    }
}
