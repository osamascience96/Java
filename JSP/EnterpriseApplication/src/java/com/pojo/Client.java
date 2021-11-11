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
public class Client {
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String createdAt;
    private String updatedAt;
    
    public Client(){
        
    }
    
    public Client(int id, String name, String address, String createdAt, String updatedAt){
        this.id = id;
        this.name = name;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
    
    public void SetAddress(String address){
        this.address = address;
    }
    public String GetAddress(){
        return this.address;
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
    
    public void SetCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }
    public String GetCreatedAT(){
        return this.createdAt;
    }
    
    public void SetUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }
    public String GetUpdatedAt(){
        return this.updatedAt;
    }
}
