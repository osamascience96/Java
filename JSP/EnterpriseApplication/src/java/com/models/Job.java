/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.database.Connector;
import com.pojo.JobComment;
import com.pojo.JobTask;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Job {
    private Connection conn;
    
    public Job(){
        this.conn = Connector.getConnectionInstance().getConnection();
    }
    
    // get all the jobs
    public ArrayList<com.pojo.Job> GetAllJobs() throws SQLException{
        ArrayList<com.pojo.Job> JobsArrayList = new ArrayList<com.pojo.Job>();
        String query = "SELECT jobs.id as JobId, jobs.team_id as TeamId, Jobs.description as Description, jobcomments.comment as jobcomments, client.name as client_name, team.name as TeamName, jobs.start as StartDate, jobs.end as EndDate FROM jobs LEFT JOIN client ON jobs.client_id = client.id LEFT JOIN team ON jobs.team_id = team.id Left JOIN jobcomments ON jobcomments.job_id = jobs.id";
        
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            com.pojo.Job job = new com.pojo.Job();
            
            com.pojo.Team team = new com.pojo.Team();
            com.pojo.Client client = new com.pojo.Client();
            JobComment jobComment = new JobComment();
            
            client.SetName(rs.getString("client_name"));
            team.SetTeamName(rs.getString("TeamName"));
            jobComment.SetComment(rs.getString("jobcomments"));
            
            job.SetId(rs.getInt("JobId"));
            job.SetTeamId(rs.getInt("TeamId"));
            job.SetDescription(rs.getString("Description"));
            job.SetJobCommentObj(jobComment);
            job.SetClientObj(client);
            job.SetTeamObj(team);
            job.SetStartDate(rs.getString("StartDate"));
            job.SetEndDate(rs.getString("EndDate"));
            
            JobsArrayList.add(job);
        }
        
        // Get all the task jobs data inside the list
        for(int i=0; i < JobsArrayList.size(); i++){
            int job_id = JobsArrayList.get(i).GetId();
            JobsArrayList.get(i).SetJobTaskArrayList(GetAllJobTasks(job_id));
        }
        
        return JobsArrayList;
    }
    
    // get all the jobstasks
    public ArrayList<JobTask> GetAllJobTasks(int job_id){
        ArrayList<JobTask> JobTaskArrayList = new ArrayList<JobTask>();
        
        String query = "SELECT * FROM jobtasks LEFT JOIN tasks ON jobtasks.task_id = tasks.id WHERE job_id = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = this.conn.prepareStatement(query);
            ps.setInt(1, job_id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                JobTask jobTask = new JobTask(0, rs.getInt("task_id"), rs.getInt("job_id"), rs.getDouble("operating_cost"), rs.getDouble("operating_revenue"));
                jobTask.SetTaskObj(new com.pojo.Task(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getInt("duration"), rs.getString("created_at")));
                
                // add to the list 
                JobTaskArrayList.add(jobTask);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return JobTaskArrayList;
    }
    
    // insert job
    public int InsertJob(com.pojo.Job job) throws SQLException{
        int generated_key = 0;
        
        String query = "INSERT INTO jobs(team_id, client_id, description, start, end) VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pstmt = this.conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstmt.setInt(1, job.GetTeamId());
        pstmt.setInt(2, job.GetClientId());
        pstmt.setString(3, job.GetDescription());
        pstmt.setString(4, job.GetStartDate());
        pstmt.setString(5, job.GetEndDate());
        
        pstmt.execute();
        
        ResultSet rs = pstmt.getGeneratedKeys();
        while(rs.next()){
            generated_key = rs.getInt(1);
        }
        
        return generated_key;
    }
    
    // insert comments to the database
    public void InsertComments(JobComment jobComment) throws SQLException{
        String query = "INSERT INTO jobcomments(job_id, comment) VALUES(?, ?)";
        
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, jobComment.GetJobId());
        pstmt.setString(2, jobComment.GetComment());
        
        pstmt.execute();
    }
    
    // insert job task
    public void InsertJobTask(JobTask jobtask) throws SQLException{
        String query = "INSERT INTO jobtasks(task_id, job_id, operating_cost, operating_revenue) VALUES(?, ?, ?, ?)";
        
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        
        pstmt.setInt(1, jobtask.GetTaskId());
        pstmt.setInt(2, jobtask.GetJobId());
        pstmt.setDouble(3, jobtask.GetOperatingCost());
        pstmt.setDouble(4, jobtask.GetOperatingRevenue());
        
        pstmt.execute();
    }
    
    public boolean DeleteJob(int job_id) throws SQLException{
        boolean is_deleted = false;
        
        int team_id = 0;
        int is_on_call = 0;
        
        // get the team_id joined to the job
        String query = "SELECT team_id FROM `jobs` WHERE id = ?";
        
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, job_id);
        
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            team_id = rs.getInt("team_id");
        }
        
        // check if the team is on the call 
        query = "SELECT is_on_call FROM team WHERE id = ?";
        pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, team_id);
        
        rs = pstmt.executeQuery();
        
        while(rs.next()){
            is_on_call = rs.getInt("is_on_call");
        }
        
        if(is_on_call == 0){
            // Delete FROM jobs
            query = "DELETE FROM jobs WHERE id = ?";

            pstmt = this.conn.prepareStatement(query);
            pstmt.setInt(1, job_id);

            pstmt.execute();

            // Delete from comments
            query = "DELETE FROM jobcomments WHERE job_id = ?";

            pstmt = this.conn.prepareStatement(query);
            pstmt.setInt(1, job_id);

            pstmt.execute();

            // Delete from jobtasks
            query = "DELETE FROM jobtasks WHERE job_id = ?";

            pstmt = this.conn.prepareStatement(query);
            pstmt.setInt(1, job_id);

            pstmt.execute();
            
            is_deleted = true;
        }
        
        return is_deleted;
    }
}
