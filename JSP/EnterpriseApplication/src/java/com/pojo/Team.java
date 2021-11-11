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
public class Team {
    private int id;
    private String team_name;
    private int is_on_call;
    private int team_members;
    private String datetime;
    
    public Team(){
    }
    
    public Team(int id, String team_name, int is_on_call, int team_members, String datetime){
        this.id = id;
        this.team_name = team_name;
        this.is_on_call = is_on_call;
        this.team_members = team_members;
        this.datetime = datetime;
    }
    
    public void SetID(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetTeamName(String team_name){
        this.team_name = team_name;
    }
    public String GetTeamName(){
        return this.team_name;
    }
    
    public void SetIsOnCall(int is_on_call){
        this.is_on_call = is_on_call;
    }
    public int GetIsOnCall(){
        return this.is_on_call;
    }
    
    public void SetTeamMembers(int team_members){
        this.team_members = team_members;
    }
    public int GetTeamMembers(){
        return this.team_members;
    }
    
    public void SetDateTime(String datetime){
        this.datetime = datetime;
    }
    public String GetDateTime(){
        return this.datetime;
    }
}
