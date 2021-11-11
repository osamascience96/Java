/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

/**
 *
 * @author osama
 */
public class User {
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    
    public User(){
    }
    
    public User(String first_name, String last_name, String username, String password){
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
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
    
    public void SetUserName(String username){
        this.username = username;
    }
    
    public String GetUserName(){
        return this.username;
    }
    
    public void SetPassword(String password){
        this.password = password;
    }
    
    public String GetPassword(){
        return this.password;
    }
    
}
