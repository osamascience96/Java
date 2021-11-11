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
public class Employee {
    
    private int id;
    private int team_id;
    private String first_name;
    private String last_name;
    private String team_name;
    private String social_insurance_number;
    private String hourly_pay_rate;
    private String date_time;
    private ArrayList<Task> employeeTaskList;
    
    public Employee(){
    }
    
    public Employee(int id, String first_name, String last_name, String social_insurance_number, String hourly_pay_rate, String date_time){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.social_insurance_number = social_insurance_number;
        this.hourly_pay_rate = hourly_pay_rate;
        this.date_time = date_time;
    }
    
    public void SetID(int id){
        this.id = id;
    }
    public int GetID(){
        return this.id;
    }
    
    public void SetFirstName(String first_name){
        this.first_name = first_name;
    }
    public String GetFirstName(){
        return this.first_name;
    }
    
    public void SetLastName(String last_name){
        this.last_name = last_name;
    }
    public String GetLastName(){
        return this.last_name;
    }
    
    public void SetSocialInsuranceNumber(String social_insurance_number){
        this.social_insurance_number = social_insurance_number;
    }
    public String GetSocialInsuranceNumber(){
        return this.social_insurance_number;
    }
    
    public void SetHourlyPayRate(String hourly_pay_rate){
        this.hourly_pay_rate = hourly_pay_rate;
    }
    public String GetHourlyPayRate(){
        return this.hourly_pay_rate;
    }
    
    public void SetDateTime(String date_time){
        this.date_time = date_time;
    }
    public String GetDateTime(){
        return this.date_time;
    }
    
    public void SetTeamID(int team_id){
        this.team_id = team_id;
    }
    public int GetTeamId(){
        return this.team_id;
    }
    
    public void SetTeamName(String team_name){
        this.team_name = team_name;
    }
    public String GetTeamName(){
        return this.team_name;
    }
    
    public void SetEmployeeTaskList(ArrayList<Task> employeeTaskList){
        this.employeeTaskList = employeeTaskList;
    }
    public ArrayList<Task> GetEmployeeTaskList(){
        return this.employeeTaskList;
    }
}
