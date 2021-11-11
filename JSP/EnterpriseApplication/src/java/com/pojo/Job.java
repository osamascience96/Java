/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class Job {
    private int id;
    private int team_id;
    private int client_id;
    private Team teamObj;
    private Client clientObj;
    private JobComment jobCommentObj;
    private String description;
    private String start_date;
    private String end_date;
    private ArrayList<JobTask> jobTaskArrayList;
    
    public Job(){
    }
    
    public Job(int id, int team_id, int client_id, String description, String start_date, String end_date){
        this.id = id;
        this.team_id = team_id;
        this.client_id = client_id;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetTeamId(int team_id){
        this.team_id = team_id;
    }
    public int GetTeamId(){
        return this.team_id;
    }
    
    public void SetClientId(int client_id){
        this.client_id = client_id;
    }
    public int GetClientId(){
        return this.client_id;
    }
    
    public void SetTeamObj(Team teamObj){
        this.teamObj = teamObj;
    }
    public Team GetTeamObj(){
        return this.teamObj;
    }
    
    public void SetClientObj(Client clientObj){
        this.clientObj = clientObj;
    }
    public Client GetClientObj(){
        return this.clientObj;
    }
    
    public void SetJobCommentObj(JobComment jobCommentObj){
        this.jobCommentObj = jobCommentObj;
    }
    public JobComment GetJobCommentObj(){
        return this.jobCommentObj;
    }
    
    public void SetDescription(String description){
        this.description = description;
    }
    public String GetDescription(){
        return this.description;
    }
    
    public void SetStartDate(String start_date){
        this.start_date = start_date;
    }
    public String GetStartDate(){
        return this.start_date;
    }
    
    public void SetEndDate(String end_date){
        this.end_date = end_date;
    }
    public String GetEndDate(){
        return this.end_date;
    }
    
    public void SetJobTaskArrayList(ArrayList<JobTask> jobTaskArrayList){
        this.jobTaskArrayList = jobTaskArrayList;
    }
    public ArrayList<JobTask> GetJobTaskArrayList(){
        return this.jobTaskArrayList;
    }
}
