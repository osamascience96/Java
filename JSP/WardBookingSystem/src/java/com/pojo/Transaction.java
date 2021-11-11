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
public class Transaction {
    private int bookingId;
    private String price;
    private int paid_status;
    
    public Transaction(){
    }
    
    public Transaction(int bookingId, String price, int paid_status){
        this.bookingId = bookingId;
        this.price = price;
        this.paid_status = paid_status;
    }
    
    public void SetBookingId(int bookingId){
        this.bookingId = bookingId;
    }
    public int GetBookingId(){
        return this.bookingId;
    }
    
    public void SetPrice(String price){
        this.price = price;
    }
    public String GetPrice(){
        return this.price;
    }
    
    public void SetPaidStatus(int paid_status){
        this.paid_status = paid_status;
    }
    public String GetPaidStatus(){
        String paid_status = "";
        if(this.paid_status == 0){
            paid_status = "Not Payed";
        }else{
            paid_status = "Payed";
        }
        
        return paid_status;
    }
}
