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
public class Task {
    private int id;
    private String name;
    private String description;
    private int duration;
    private String created_at;
    private String updated_at;
    
    public Task(){
    }
    
    public Task(int id, String name, String description, int duration, String created_at){
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.created_at = created_at;
    }
    
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetName(String name){
        this.name = name;
    }
    public String GetName(){
        return this.name;
    }
    
    public void SetDescription(String description){
        this.description = description;
    }
    public String GetDescription(){
        return this.description;
    }
    
    public void SetDuration(int duration){
        this.duration = duration;
    }
    public int GetDuration(){
        return this.duration;
    }
    
    public void SetCreatedAt(String created_at){
        this.created_at = created_at;
    }
    public String GetCreatedAt(){
        return this.created_at;
    }
    
    public void SetUpdatedAt(String updated_at){
        this.updated_at = updated_at;
    }
    public String GetUpdated(){
        return this.updated_at = updated_at;
    }
}
