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
public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String phone;
    private Blob image;
    private String status;
    private String nationality;
    private String date_of_bith;
    private String time_stamp;

    public User(){    
    }
    
    public User(int id, String name, String email, String password, String gender, String phone, String status, String nationality, String date_of_bith) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.status = status;
        this.nationality = nationality;
        this.date_of_bith = date_of_bith;
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
    
    public void SetGender(String gender){
        this.gender = gender;
    }
    public String GetGender(){
        return this.gender;
    }
    
    public void SetPhone(String phone){
        this.phone = phone;
    }
    public String GetPhone(){
        return this.phone;
    }
    
    public void SetStatus(String status){
        this.status = status;
    }
    public String GetStatus(){
        return this.status;
    }
    
    public void SetNationality(String nationality){
        this.nationality = nationality;
    }
    public String GetNationality(){
        return this.nationality;
    }
    
    public void SetDateOfBirth(String date_of_birth){
        this.date_of_bith = date_of_birth;
    }
    public String GetDateOfBirth(){
        return this.date_of_bith;
    }
    
    public void SetTimeStamp(String time_stamp){
        this.time_stamp = time_stamp;
    }
    public String GetTimeStamp(){
        return this.time_stamp;
    }
    
    public void SetImage(Blob image){
        this.image = image;
    }
    public Blob GetImage(){
        return this.image;
    }
}
