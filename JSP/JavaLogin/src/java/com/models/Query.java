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
public class Query {
    private String name;
    private String email;
    private String message;
    
    public Query(){
    }
    
    public Query(String name, String email, String message){
        this.name = name;
        this.email = email;
        this.message = message;
    }
    
    public void SetName(String name){
        this.name = name;
    }
    public String GetName(){
        return this.name;
    }
    
    public void SetEmail(String email){
        this.email = email;
    }
    public String GetEmail(){
        return this.email;
    }
    
    public void SetMessage(String message){
        this.message = message;
    }
    public String GetMessage(){
        return this.message;
    }
}
