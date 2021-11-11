/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Employee;
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
@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee_servlet"})
public class EmployeeServlet extends HttpServlet {
    private Employee employeeModel;
    private Task tasksModel;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.employeeModel = new Employee();
        this.tasksModel = new Task();
        
        String link = "employee.jsp";
        
        
        if(req.getParameter("delete_employee_id") != null){
            boolean response = true;
            try {
                response = this.employeeModel.DeleteEmployeeRecords(req.getParameter("delete_employee_id"));
//                this.tasksModel.deleteEmployeeFromTask(Integer.parseInt(req.getParameter("delete_employee_id")));
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(!response){
                link = "employee_servlet?response=delete_success";
            }else{
                link = "employee_servlet?response=team_employee_exists";
            }
        }else if(req.getParameter("delete_task_id") != null){
            int task_id = Integer.parseInt(req.getParameter("delete_task_id"));
            int employee_id = Integer.parseInt(req.getParameter("employee_id"));
            
            try {
                this.employeeModel.DeleteEmployeeTasks(task_id, employee_id);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            link = "employee_servlet?response=delete_employee_task_success";
        }else{
            ArrayList<com.pojo.Employee> arrayListEmployees = null;
            ArrayList<com.pojo.Task> arrayListTasks = null;
        
            try {
                arrayListEmployees = this.employeeModel.GetAllEmployeeRecords();
                arrayListTasks = this.tasksModel.GetAllTasksDB();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("employeelist", arrayListEmployees);
            httpSession.setAttribute("tasksList", arrayListTasks);
            
            String response = "";
            
            if(req.getParameter("response") != null){
                response = req.getParameter("response");
                link = link.concat("?response=").concat(response);
            }
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.employeeModel = new Employee();
        this.tasksModel = new Task();
        
        String post_method = null;
        
        if(req.getParameter("post_action") != null){
            post_method = req.getParameter("post_action");
        }
        
        if(post_method != null){
            if(post_method.compareToIgnoreCase("insert") == 0){
                String link = "employee_servlet";
                
                com.pojo.Employee employee = new com.pojo.Employee();
                employee.SetFirstName(req.getParameter("first_name"));
                employee.SetLastName(req.getParameter("last_name"));
                employee.SetSocialInsuranceNumber(req.getParameter("sin_box_1").concat("-").concat(req.getParameter("sin_box_2")).concat("-").concat(req.getParameter("sin_box_3")));
                employee.SetHourlyPayRate(req.getParameter("hourly_rate"));
                
                String[] taskIdsArray = req.getParameterValues("task_select_multiple");
                
                int generated_id = 0;
                try {
                    if(!this.employeeModel.CheckSINExistance(employee.GetSocialInsuranceNumber())){
                        generated_id = this.employeeModel.InsertEmployeeRecords(employee);
                        link = link.concat("?response=insert_success");
                    }else{
                        link = link.concat("?response=sin_exists");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                // if the taskId Array is null, then 
                if(taskIdsArray != null){
                    if(generated_id != 0){
                        for(int i=0; i < taskIdsArray.length; i++){
                            try {
                                if(this.tasksModel.CheckTasktoEmployees(Integer.parseInt(taskIdsArray[i]), generated_id) == 0){
                                    this.tasksModel.SetTasktoEmployees(Integer.parseInt(taskIdsArray[i]), generated_id);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                
                resp.sendRedirect(link);
            }else if(post_method.compareToIgnoreCase("edit") == 0){
                
                com.pojo.Employee employee = new com.pojo.Employee();
                employee.SetID(Integer.parseInt(req.getParameter("employee_id")));
                employee.SetFirstName(req.getParameter("first_name"));
                employee.SetLastName(req.getParameter("last_name"));
                employee.SetHourlyPayRate(req.getParameter("hourly_rate"));
                
                String[] taskIdsArray = req.getParameterValues("edit_task_select_multiple");
                
                boolean response = false;
                
                try {
                    response = this.employeeModel.UpdateEmployeeRecords(employee);
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(taskIdsArray != null){
                    for(int i=0; i < taskIdsArray.length; i++){
                        try {
                            if(this.tasksModel.CheckTasktoEmployees(Integer.parseInt(taskIdsArray[i]), employee.GetID()) == 0){
                                this.tasksModel.SetTasktoEmployees(Integer.parseInt(taskIdsArray[i]), employee.GetID());
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
                resp.sendRedirect("employee_servlet?response=edit_success");
            }
        }
    }
}
