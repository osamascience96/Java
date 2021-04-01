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
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String mobile;
    private String role;
    
    public User(){
        
    }
    
    public User(String userId, String firstName, String lastName, String email, String password, String mobile, String role){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.role = role;
    }
    
    public void SetUserId(String userId){
        this.userId = userId;
    }
    public String GetUserId(){
        return this.userId;
    }
    
    public void SetFirstName(String firstName){
        this.firstName = firstName;
    }
    public String GetFirstName(){
        return this.firstName;
    }
    
    public void SetLastName(String lastName){
        this.lastName = lastName;
    }
    public String GetLastName(){
        return this.lastName;
    }
    
    public void SetEmail(String email){
        this.email = email;
    }
    public String GetEmail(){
        return this.email;
    }
    
    public void SetPassword(String password){
        this.password = password;
    }
    public String GetPassword(){
        return this.password;
    }
    
    public void SetMobile(String mobile){
        this.mobile = mobile;
    }
    public String GetMobile(){
        return this.mobile;
    }
    
    public void SetRole(String role){
        this.role = role;
    }
    public String GetRole(){
        return this.role;
    }
}
