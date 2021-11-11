/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author osama
 */
public class JobTask {
    private int id;
    private int task_id;
    private int job_id;
    private double operating_cost;
    private double operating_revenue;
    private Task taskObj;
    
    public JobTask(){
    }
    
    public JobTask(int id, int task_id, int job_id, double operating_cost, double operating_revenue){
        this.id = id;
        this.task_id = task_id;
        this.job_id = job_id;
        this.operating_cost = operating_cost;
        this.operating_revenue = operating_revenue;
    }
    
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetTaskId(int task_id){
        this.task_id = task_id;
    }
    public int GetTaskId(){
        return this.task_id;
    }
    
    public void SetJobId(int job_id){
        this.job_id = job_id;
    }
    public int GetJobId(){
        return this.job_id;
    }
    
    public void SetOperatingCost(double operating_cost){
        this.operating_cost = operating_cost;
    }
    public double GetOperatingCost(){
        return this.operating_cost;
    }
    
    public void SetOperatingRevenue(double operating_revenue){
        this.operating_revenue = this.operating_revenue;
    }
    public double GetOperatingRevenue(){
        return this.operating_revenue;
    }
    
    public void SetTaskObj(Task taskObj){
        this.taskObj = taskObj;
    }
    public Task GetTaskObj(){
        return this.taskObj;
    }
}
