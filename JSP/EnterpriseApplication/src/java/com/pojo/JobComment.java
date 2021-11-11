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
public class JobComment {
    private int id;
    private int job_id;
    private String comment;
    private String created_at;
    private String updated_at;
    
    public JobComment(){
    }
    
    public JobComment(int id, int job_id, String comment, String created_at, String updated_at){
        this.id = id;
        this.job_id = job_id;
        this.comment = comment;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetJobId(int job_id){
        this.job_id = job_id;
    }
    public int GetJobId(){
        return this.job_id;
    }
    
    public void SetComment(String comment){
        this.comment = comment;
    }
    public String GetComment(){
        return this.comment;
    }
    
    public void SetCreatedAt(String created_at){
        this.created_at = created_at;
    }
    public String GetCreatedAt(){
        return this.created_at;
    }
    
    public void SetUpdateAt(String updated_at){
        this.updated_at = updated_at;
    }
    public String GetUpdatedAt(){
        return this.updated_at;
    }
}
