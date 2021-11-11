/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.sql.Blob;

/**
 *
 * @author osama
 */
public class Review {
    private String name;
    private String email;
    private String phone;
    private Blob image;
    private String message;
    
    public Review(String name, String email, String phone, Blob image, String message){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.image = image;
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
    
    public void SetPhone(String phone){
        this.phone = phone;
    }
    public String GetPhone(){
        return this.phone;
    }
    
    public void SetImage(Blob image){
        this.image = image;
    }
    public Blob GetImage(){
        return this.image;
    }
    
    public void SetMessage(String message){
        this.message = message;
    }
    public String GetMessage(){
        return this.message;
    }
    
}
