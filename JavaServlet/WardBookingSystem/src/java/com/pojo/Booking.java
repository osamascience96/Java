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
public class Booking {
    private int bookingId;
    private int userId;
    private int wardId;
    private String userName;
    private String userEmail;
    private Blob userImage;
    private String wardName;
    private String wardType;
    private Blob wardImage;
    private String price_per_day;
    private String check_in_date;
    private String check_out_date;
    private String payedStatus;
    private String status;
    private String date;
    private String time;
    
    public Booking(){
    }
    
    public Booking(int bookingId, int userId, int wardId, String userName, String userEmail, Blob userImage, String wardName, String wardType, Blob wardImage){
        this.bookingId = bookingId;
        this.userId = userId;
        this.wardId = wardId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userImage = userImage;
        this.wardName = wardName;
        this.wardType = wardType;
        this.wardImage = wardImage;
    }
    
    public void SetBookingId(int bookingId){
        this.bookingId = bookingId;
    }
    public int GetBookingId(){
        return this.bookingId;
    }
    
    public void SetUserId(int userID){
        this.userId = userID;
    }
    public int GetUserId(){
        return this.userId;
    }
    
    public void SetWardId(int wardId){
        this.wardId = wardId;
    }
    public int GetWardId(){
        return this.wardId;
    }
    
    public void SetUsername(String username){
        this.userName = username;
    }
    public String GetUsername(){
        return this.userName;
    }
    
    public void SetUserEmail(String userEmail){
        this.userEmail = userEmail;
    }
    public String GetUserEmail(){
        return this.userEmail;
    }
    
    public void SetUserImage(Blob userImage){
        this.userImage = userImage;
    }
    public Blob GetUserImage(){
        return this.userImage;
    }
    
    public void SetWardName(String wardName){
        this.wardName = wardName;
    }
    public String GetWardName(){
        return this.wardName;
    }
    
    public void SetWardType(String wardType){
        this.wardType = wardType;
    }
    public String GetWardType(){
        return this.wardType;
    }
    
    public void SetWardImage(Blob wardImage){
        this.wardImage = wardImage;
    }
    public Blob GetWardImage(){
        return this.wardImage;
    }
    
    public void SetWardPrice(String price_per_day){
        this.price_per_day = price_per_day;
    }
    public String GetWardPrice(){
        return this.price_per_day;
    }
    
    public void SetCheckInDate(String check_in_date){
        this.check_in_date = check_in_date;
    }
    public String GetCheckInDate(){
        return this.check_in_date;
    }
    
    public void SetCheckOutDate(String check_out_date){
        this.check_out_date = check_out_date;
    }
    public String GetCheckOutDate(){
        return this.check_out_date;
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
    
    public void SetPaymentStatus(int payed_status){
        if(payed_status == 1){
            this.payedStatus = "Payed";
        }else{
            this.payedStatus = "Not Payed";
        }
    }
    
    public String GetPaymentStatus(){
        return this.payedStatus;
    }
    
    public void SetStatus(String status){
        this.status = status;
    }
    public String GetStatus(){
        return this.status;
    }
    
    
    
}
