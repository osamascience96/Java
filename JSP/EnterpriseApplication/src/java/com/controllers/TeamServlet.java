/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.models.Team;
import com.pojo.Employee;
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
@WebServlet(name = "TeamServlet", urlPatterns = {"/team_servlet"})
public class TeamServlet extends HttpServlet {
    
    private Team teamModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.teamModel = new Team();
        
        String link = "teams.jsp";
        
        if(req.getParameter("delete_team_id") != null){
            int team_id = Integer.parseInt(req.getParameter("delete_team_id"));
            boolean response = false;
            
            try {
                response = this.teamModel.deleteTeamDatabase(team_id);
            } catch (SQLException ex) {
                Logger.getLogger(TeamServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(response){
                link = "team_servlet?response=delete_success";
            }else{
                link = "team_servlet?response=delete_not_possible";
            }
        }else{
            ArrayList<com.pojo.Team> arrayListTeams = null;
            ArrayList<Employee> freeEmployeesList = null;
            ArrayList<Employee> onTeamEmployeeList = null;

            try {
                arrayListTeams = this.teamModel.GetAllTeamsRecordList();
                freeEmployeesList = this.teamModel.GetFreeEmployeeData();
                onTeamEmployeeList = this.teamModel.GetOnTeamEmployeeData();
            } catch (SQLException ex) {
                Logger.getLogger(TeamServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("teamlist", arrayListTeams);
            httpSession.setAttribute("freeEmployeeList", freeEmployeesList);
            httpSession.setAttribute("onTeamEmployeeList", onTeamEmployeeList);
            
            if(req.getParameter("response") != null){
                String response = req.getParameter("response");
                link = link.concat("?response=").concat(response);
            }
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.teamModel = new Team();
        String link = "";
        
        if(req.getParameter("post_action").compareTo("insert") == 0){
            String team_name = req.getParameter("team_name");
            String on_call = req.getParameter("on_call");
            String employees_id_array[] = req.getParameterValues("employees_array");
            
            boolean response = false;
            
            try {
                if(!this.teamModel.CheckTeamExistance(team_name)){
                    response = this.teamModel.InsertTeamDatabase(team_name, on_call, employees_id_array);
                    link = "team_servlet?response=team_inserted_successfully";
                }else{
                    link = "team_servlet?response=team_already_exists";
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeamServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(req.getParameter("post_action").compareTo("edit") == 0){
            String team_id = req.getParameter("team_member_id");
            String team_name = req.getParameter("team_name");
            String on_call = req.getParameter("on_call");
            int final_team_scale = Integer.parseInt(req.getParameter("final_team_scale"));
            String employees_id_array[] = req.getParameterValues("employees_array") != null ? req.getParameterValues("employees_array") : new String[0];
            
            if(employees_id_array.length <= final_team_scale){
                // proceed forward
                com.pojo.Team team = new com.pojo.Team();
                team.SetID(Integer.parseInt(team_id));
                team.SetTeamName(team_name);
                team.SetIsOnCall(Integer.parseInt(on_call));
                
                boolean response = false;
                
                try {
                    response = this.teamModel.editTeamDatabase(team, employees_id_array);
                } catch (SQLException ex) {
                    Logger.getLogger(TeamServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                link = "team_servlet?response=edited_success";
            }else{
                link = "team_servlet";
            }
        }else if(req.getParameter("post_action").compareTo("scale_member") == 0){
            String team_member = req.getParameter("member_scale");
            String team_id = req.getParameter("team_id");
            
            boolean response = false;
            
            try {
                response = this.teamModel.UpdateTeamScale(team_member, team_id);
                link = "team_servlet?response=update_team_scale_update_success";
            } catch (SQLException ex) {
                Logger.getLogger(TeamServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        resp.sendRedirect(link);
    }
    
}
