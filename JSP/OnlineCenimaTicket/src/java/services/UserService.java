/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import helper.MD5;
import models.User;

/**
 *
 * @author osama
 */
public class UserService {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    
    private User userModel;

    public UserService(String email, String password) {
        this.email = email;
        this.password = password;
        
        this.userModel = new User();
    }
    
    

    public UserService(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        
        this.userModel = new User();
    }
    
    public String DoRegister(){
        this.firstName = this.firstName.trim();
        this.lastName = this.lastName != null ? this.lastName.trim() : null;
        this.username = this.username.trim();
        this.email = this.email.trim();
        this.password = this.password.trim();
        
        this.userModel.firstname = this.firstName;
        this.userModel.lastname = this.lastName;
        this.userModel.username = this.username;
        this.userModel.email = this.email;
        this.userModel.Password = MD5.GetMD5(this.password);
        
        return this.userModel.InsertUser() ? "Success" : "Failed";
    }
    
    public User DoLogin(){
        this.email = this.email.trim();
        this.password = this.password.trim();
        
        this.userModel.email = this.email;
        this.userModel.Password = MD5.GetMD5(this.password);
        
        return this.userModel.SelectByEmailPass();
    }
}
