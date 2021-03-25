/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.Customer;
import com.pojo.Booking;
import com.pojo.Transaction;
import com.pojo.Ward;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class CustomerService {
    
    private Customer customerModel;
    
    public CustomerService(){
        this.customerModel = new Customer();
    }
    
    public ArrayList<Ward> GetAllWardsforUser(){
        ArrayList<Ward> arrayListWards = null;
        
        try {
            arrayListWards = this.customerModel.GetAllWardsFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListWards;
    }
    
    public int InsertBooking(String ward_id, String user_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.InsertBookingtoDB(ward_id, user_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount;
    }
    
    public boolean UpdateWardStatus(String ward_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.UpdateWardStatustoActive(ward_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean DeactiveWard(String ward_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.UpdateWardStatusDeactive(ward_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public ArrayList<Booking> GetAllUserBookings(String user_id){
        ArrayList<Booking> bookingsArrayList = null;
        
        try {
            bookingsArrayList = this.customerModel.GetAllUserBookings(user_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bookingsArrayList;
    }
    
    public ArrayList<Booking> GetAllUserBookingHistoryDB(String user_id){
        ArrayList<Booking> bookingsArrayList = null;
        
        try {
            bookingsArrayList = this.customerModel.GetAllUserBookingHistory(user_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bookingsArrayList;
    }
    
    public int GetWardPrice(String wardid){
        int price_per_day = 0;
        try {
            price_per_day = this.customerModel.GetWardPrice(wardid);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return price_per_day;
    }
    
    public boolean InsertTransaction(String booking_id, String price){
        int rowCount = 0;
        try {
            rowCount = this.customerModel.SetTransactionstoDB(booking_id, price);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean DeleteBookingfromDB(String booking_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.DeleteBooking(booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public ArrayList<Transaction> GetAllUserTransactions(String user_id){
        ArrayList<Transaction> arrayListsTransactions = null;
        
        try {
            arrayListsTransactions = this.customerModel.GetAllUserTransactions(user_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayListsTransactions;
    }
    
    public boolean DeleteTransactionfromDB(String booking_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.DeleteTransaction(booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean UpdateBookingCheckInDate(String check_in_date, String booking_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.CheckinBookingDB(check_in_date, booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean UpdateBookingCheckOutDate(String check_in_date, String check_out_date, String booking_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.CheckoutBookingDB(check_in_date, check_out_date, booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public int GetBookingPriceDB(String booking_id){
        int price = 0;
        
        try {
            price = this.customerModel.GetBookingPrice(booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return price;
    }
    
    public boolean UpdateTransaction(String booking_id, String price){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.UpdateTransactionsUser(booking_id, price);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public Booking GetUserBookingDataDB(String booking_id){
        Booking booking = null;
        
        try {
            booking = this.customerModel.GetUserBookingData(booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return booking;
    }
    
    public boolean UpdateTransactionPayedStatus(String booking_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.UpdateTransactionPaymentsDB(booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean UpdateWardStatusDeactiveDB(String booking_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.UpdateWardStatustoDeactive(booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean SubmitReview(String user_id, String message){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.SubmitQuery(user_id, message);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
    
    public boolean UpdateBookingStatusDB(String status, String booking_id){
        int rowCount = 0;
        
        try {
            rowCount = this.customerModel.UpdateBookingStatus(status, booking_id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowCount > 0;
    }
}
