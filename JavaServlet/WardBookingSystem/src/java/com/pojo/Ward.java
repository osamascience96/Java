/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author osama
 */
public class Ward {
    private int id;
    private String name;
    private String type;
    private String status;
    private Blob wardImage;
    private String price;
    private String date;
    private String time;
    private InputStream wardImageInputStream;
    
    public Ward(){
    }
    
    public Ward(int id, String name, String type, Blob wardimage, String date, String time){
        this.id = id;
        this.name = name;
        this.type = type;
        this.wardImage = wardimage;
        this.date = date;
        this.time = time;
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
    
    public void SetType(String type){
        this.type = type;
    }
    public String GetType(){
        return this.type;
    }
    
    public void SetStatus(int status){
        if(status == 0){
            this.status = "Not Booked";
        }else{
            this.status = "Booked";
        }
    }
    public String GetStatus(){
        return this.status;
    }
    
    public void SetImage(Blob wardImage){
        this.wardImage = wardImage;
    }
    public Blob GetImage(){
        return this.wardImage;
    }
    
    public void SetDate(String date){
        this.date = date;
    }
    public String GetDate(){
        return this.date;
    }
    
    public void SetTime(String time){
        this.time = time;
    }
    public String GetTime(){
        return this.time;
    }
    
    public void SetPrice(String price){
        this.price = price;
    }
    public String GetPrice(){
        return this.price;
    }
    
    public void SetImageInputStream(InputStream wardImageInputstream){
        this.wardImageInputStream = wardImageInputstream;
    }
    public InputStream GetImageInputStream(){
        return this.wardImageInputStream;
    }
}
