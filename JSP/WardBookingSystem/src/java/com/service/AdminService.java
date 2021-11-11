/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Admin;
import com.pojo.Booking;
import com.pojo.Report;
import com.pojo.Review;
import com.pojo.User;
import com.pojo.Ward;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class AdminService {
    
    private Admin adminModel = null;
    
    // constructor
    public AdminService(){
        this.adminModel = new Admin();
    }
    
    // Adding Getting today's booking
    public ArrayList<Booking> GettingTodayBookingsDB(String date){
        ArrayList<Booking> arrayListBooking = null;
        
        try {
            arrayListBooking = this.adminModel.GettingTodayBookingsDB(date);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListBooking;
    }
    
    public ArrayList<Ward> GetAllWardDetails(){
        ArrayList<Ward> arrayListWards = null;
        try {
            arrayListWards = this.adminModel.GetAllWards();
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListWards;
    }
    
    public ArrayList<com.pojo.User> GetAllUsersDetails(){
        ArrayList<com.pojo.User> arrayListUsers = null;
        try {
            arrayListUsers =  this.adminModel.GetAllUsersDB();
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListUsers;
    }
    
    public ArrayList<Booking> GetAllBookingsDetails(){
        ArrayList<Booking> arrayListBookings = null;
        
        try {
            arrayListBookings = this.adminModel.GetAllBookingsDB();
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListBookings;
    }
    
    public boolean DeleteBooking(String bookId){
        int result = 0;
        try {
            result = this.adminModel.DeleteBooking(bookId);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result > 0;
    }
    
    public boolean DeleteUser(String userid){
        int result = 0;
        try {
            result = this.adminModel.DeleteUser(userid);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    
    public boolean DeleteWard(String wardId){
        int result = 0;
        try {
            result = this.adminModel.DeleteWard(wardId);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;
    }
    
    public User GetUserfromDB(String user_id){
        User user = null;
        try {
            user = this.adminModel.GetUser(user_id);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    public boolean EditUser(User user){
        int rowCount = 0;
        try {
            rowCount = this.adminModel.EditUserDB(user);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowCount > 0;
    }
    
    public Ward GetWardfromDB(String ward_id){
        Ward ward = null;
        try {
            ward = this.adminModel.GetWard(ward_id);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ward;
    }
    
    public boolean EditWard(Ward ward){
        int rowCount = 0;
        
        try {
            rowCount = this.adminModel.EditWardDB(ward);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean InsertWard(Ward ward){
        int rowCount = 0;
        
        try {
            rowCount = this.adminModel.InsertWardDB(ward);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean ActiveWard(String ward_id){
        int rowCount = 0;
        
        try {
            rowCount = this.adminModel.UpdateWardStatustoActive(ward_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean DeactiveWard(String ward_id){
        int rowCount = 0;
        
        try {
            rowCount = this.adminModel.UpdateWardStatusDeactive(ward_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean DeleteTransactionfromDB(String booking_id){
        int rowCount = 0;
        
        try {
            rowCount = this.adminModel.DeleteTransaction(booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public Booking GetUserBookingDataDB(String booking_id){
        Booking booking = null;
        
        try {
            booking = this.adminModel.GetUserBookingData(booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return booking;
    }
    
    public ArrayList<Report> GetAllReportsDB(){
        ArrayList<Report> arrayListReports = null;
        
        try {
            arrayListReports = this.adminModel.GetAllReports();
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListReports;
    }
    
    public ArrayList<Review> GetAllCustomerReiviews(){
        ArrayList<Review> arrayListReviews = null;
        
        try {
            arrayListReviews = this.adminModel.GetAllCustomerReviews();
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListReviews;
    }
    
    public boolean UpdateUserProfileDB(User user){
        int rowCount = 0;
        
        try {
            rowCount = this.adminModel.UpdateUserProfile(user);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
}
