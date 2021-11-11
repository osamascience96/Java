/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.helper.DateTimeHelper;
import com.models.Client;
import com.models.Employee;
import com.models.Job;
import com.models.Task;
import com.models.Team;
import com.pojo.JobComment;
import com.pojo.JobTask;
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
@WebServlet(name = "JobServlet", urlPatterns = {"/job_servlet"})
public class JobServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "jobs.jsp";
        
        Job jobModel = new Job();
        Team teamModel = new Team();
        
        if(req.getParameter("delete_record") != null){
            int job_id = Integer.parseInt(req.getParameter("delete_record"));
            boolean is_deleted = false;
            
            try {
                is_deleted = jobModel.DeleteJob(job_id);
            } catch (SQLException ex) {
                Logger.getLogger(JobServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(is_deleted){
                link = "job_servlet?response=delete_success";
            }else{
                link = "job_servlet?response=deleted_failed";
            }
        }else if(req.getParameter("finish_record") != null){
            int team_id = Integer.parseInt(req.getParameter("finish_record"));
            System.out.println(team_id);
            try {
                teamModel.SetTeamCall(0, team_id);
            } catch (SQLException ex) {
                Logger.getLogger(JobServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            link = "job_servlet?response=finish_job_success";
        }else{
            // init the session 
            HttpSession httpSession = req.getSession();

            // select teams, tasks, clients list
            Task taskModel = new Task();
            Client clientModel = new Client();

            try {
                ArrayList<com.pojo.Team> teamArrayList = teamModel.GetAllFreeTeamsRecordList();
                ArrayList<com.pojo.Task> taskArrayList = taskModel.GetAllTasksDB();
                ArrayList<com.pojo.Client> clientsArrayList = clientModel.GetAllClientList();
                // Get ALl the jobs from the database
                ArrayList<com.pojo.Job> jobArrayList = jobModel.GetAllJobs();
                // setting the lists to the session
                httpSession.setAttribute("task_list", taskArrayList);
                httpSession.setAttribute("team_list", teamArrayList);
                httpSession.setAttribute("clients_list", clientsArrayList);
                httpSession.setAttribute("job_list", jobArrayList);
            } catch (SQLException ex) {
                Logger.getLogger(JobServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            // concat the response
            if(req.getParameter("response") != null){
                link = link.concat("?response=".concat(req.getParameter("response")));
            }
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "job_servlet";
        
        String request_type = req.getParameter("request_type");
        Job jobModel = new Job();
        Employee employeeModel = new Employee();
        Task taskModel = new Task();
        Team teamModel = new Team();
        
        if(request_type != null){
            if(request_type.compareTo("insert") == 0){
                // Get all the values from parameter
                String[] client_array = req.getParameterValues("client_array");
                String[] team_array = req.getParameterValues("teams_array");
                String[] task_array = req.getParameterValues("tasks_array");
                String description = req.getParameter("description");
                String comments = req.getParameter("comment");
                String start_date_time = req.getParameter("start_date").concat(" ").concat(req.getParameter("start_time"));
                String end_date_time = req.getParameter("end_date").concat(" ").concat(req.getParameter("end_time"));
                // check if the clients array length is 1
                if(client_array.length > 1){
                    link = link.concat("?response=client_length_exceeds");
                }else if(team_array.length > 1){
                    link = link.concat("?response=teams_length_exceeds");
                }else{
                    int client_id = Integer.parseInt(client_array[0]);
                    int team_id = Integer.parseInt(team_array[0]);
                    
                    try {
                        int job_id = jobModel.InsertJob(new com.pojo.Job(0, team_id, client_id, description, start_date_time, end_date_time));
                        // make the team on call 
                        teamModel.SetTeamCall(1, team_id);
                        // check if the comment is not empty
                        if(!comments.isEmpty()){
                            JobComment jobComment = new JobComment();
                            jobComment.SetJobId(job_id);
                            jobComment.SetComment(comments);
                            jobModel.InsertComments(jobComment);
                        }
                        
                        // fetch all the employees of team hourly rate
                        ArrayList<com.pojo.Employee> employeeArrayList = employeeModel.GetAllEmployeeByTeamID(team_id);
                        double team_hourly_rate = 0;
                        //chcek if the employeelist is non nul
                        if(employeeArrayList != null){
                            for(int i=0; i < employeeArrayList.size(); i++){
                                team_hourly_rate += Double.parseDouble(employeeArrayList.get(i).GetHourlyPayRate());
                            }
                        }
                        // interate task array and insert jobcost and revenue
                        for(int i=0; i < task_array.length; i++){
                            int task_id = Integer.parseInt(task_array[i]);
                            int task_time = taskModel.GetSelectedtaskTotalTime(String.valueOf(task_id));
                            // calculating cost and revenue
                            double cost = team_hourly_rate * (Double.valueOf(task_time) / 60);
                            double revenue = team_hourly_rate * (Double.valueOf(task_time) / 60);

                            String[] start_date_time_array = start_date_time.split(" ");
                            String[] end_date_time_array = end_date_time.split(" ");

                            String startdate = DateTimeHelper.GetDayofWeekbyDate(start_date_time_array[0]);
                            String enddate = DateTimeHelper.GetDayofWeekbyDate(end_date_time_array[0]);

                            // check if both the date are on hours date
                            if(DateTimeHelper.IsOnDay(startdate) && DateTimeHelper.IsOnDay(enddate)){
                                // check if the time is on hours time
                                if(DateTimeHelper.IsOnTime(start_date_time_array[1]) && DateTimeHelper.IsOnTime(end_date_time_array[1])){
                                    revenue = revenue * 3;
                                }else{
                                    revenue = revenue * 4;
                                }
                            }else{
                                revenue = revenue * 4;
                            }
                            
                            // insert to the database
                            jobModel.InsertJobTask(new JobTask(0, task_id, job_id, cost, revenue));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(JobServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    link = link.concat("?response=insert_record_success");
                }
            }else if(request_type.compareTo("add_comment") == 0){
                int job_id = Integer.parseInt(req.getParameter("job_id"));
                String comments = req.getParameter("comment");
                
                JobComment jobComment = new JobComment();
                jobComment.SetJobId(job_id);
                jobComment.SetComment(comments);
                
                try {
                    jobModel.InsertComments(jobComment);
                } catch (SQLException ex) {
                    Logger.getLogger(JobServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                link = link.concat("?response=comment_added_success");
            }else{
                link = link.concat("?response=invalid_request_type");
            }
        }else{
            link = link.concat("?response=no_request_type");
        }
        
        resp.sendRedirect(link);
    }
    
    
    
}
