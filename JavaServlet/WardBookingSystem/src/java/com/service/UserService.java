/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class UserService {
    private User userModel;
    
    public UserService(){
        this.userModel = new User();
    }
    
    public com.pojo.User GetUserData(String email){
        com.pojo.User user = null;
        try {
           user = this.userModel.GetUserFromDB(email);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    public com.pojo.User GetUserDataviaid(String user_id){
        com.pojo.User user = null;
        try {
           user = this.userModel.GetUserFromDBviaid(user_id);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    public boolean CheckUser(String email){
        ArrayList<com.pojo.User> usersArrayList = null;
        try {
            usersArrayList = this.userModel.CheckUser(email);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return usersArrayList.size() > 0;
    }
    
    public boolean InsertUser(String name, String email, String password){
        int rowCount = 0;
        
        try {
            rowCount = this.userModel.InsertdatatoUsers(name, email, password);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean CheckUserLoginData(String email, String password){
        ArrayList<com.pojo.User> usersArrayList = null;
        
        try {
            usersArrayList = this.userModel.CheckUserLoginData(email, password);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usersArrayList.size() > 0;
    }
}
