/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.database.Connector;
import com.pojo.Booking;
import com.pojo.Transaction;
import com.pojo.Ward;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class Customer {
    
    private Connection connection = null;
    
    public Customer(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<Ward> GetAllWardsFromDB() throws SQLException{
        ArrayList<Ward> arrayListWards = new ArrayList<Ward>();
        String query = "SELECT * FROM `wards` WHERE status = 0";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {            
            String datetimeArray[] = rs.getString("created_at").split(" ");
            Ward ward = new Ward(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getBlob("image"), datetimeArray[0], datetimeArray[1]);
            ward.SetStatus(rs.getInt("status"));
            ward.SetPrice(rs.getString("price_per_day"));
            
            arrayListWards.add(ward);
        }
        
        return arrayListWards;
    }
    
    public int InsertBookingtoDB(String ward_id, String user_id) throws SQLException{
        String query = "INSERT INTO `bookings`(user_id, ward_id) VALUES (" + user_id + ", " + ward_id + ")";
        PreparedStatement ps = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        if(rs.next()){
            generatedKey = rs.getInt(1);
        }
        
        return generatedKey;
    }
    
    public int UpdateWardStatustoActive(String ward_id) throws SQLException{
        String query = "UPDATE `wards` SET status = 1 WHERE id = " + ward_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public int UpdateWardStatusDeactive(String ward_id) throws SQLException{
        String query = "UPDATE `wards` SET status = 0 WHERE id = " + ward_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public ArrayList<Booking> GetAllUserBookings(String user_id) throws SQLException{
        ArrayList<Booking> bookingsArrayList = new ArrayList<Booking>();
        String query = "SELECT bookings.id as BookingId, users.id as UserId, wards.id as WardId, users.name as username, wards.name as WardName, wards.type as wardtype, wards.image as wardimage, wards.price_per_day as price_per_day, bookings.created_at as timestamp, bookings.check_in_date, bookings.check_out_date, transactions.paid_status as payment_status, bookings.status as status FROM bookings JOIN users ON bookings.user_id = users.id JOIN wards ON bookings.ward_id = wards.id JOIN transactions ON transactions.booking_id = bookings.id WHERE bookings.user_id = " + user_id + "  AND (bookings.status LIKE '%pending%' OR bookings.status LIKE '%accepted%')";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            Booking booking = new Booking();
            booking.SetBookingId(rs.getInt("BookingId"));
            booking.SetUserId(rs.getInt("UserId"));
            booking.SetWardId(rs.getInt("WardId"));
            booking.SetUsername(rs.getString("username"));
            booking.SetWardName(rs.getString("WardName"));
            booking.SetWardType(rs.getString("wardtype"));
            booking.SetWardImage(rs.getBlob("wardimage"));
            booking.SetWardPrice(rs.getString("price_per_day"));
            booking.SetCheckInDate(rs.getString("check_in_date"));
            booking.SetCheckOutDate(rs.getString("check_out_date"));
            booking.SetDate(rs.getString("timestamp").split(" ")[0]);
            booking.SetTime(rs.getString("timestamp").split(" ")[1]);
            booking.SetPaymentStatus(rs.getInt("payment_status"));
            booking.SetStatus(rs.getString("status"));
            
            bookingsArrayList.add(booking);
        }
        
        return bookingsArrayList;
    }
    
    public ArrayList<Booking> GetAllUserBookingHistory(String user_id) throws SQLException{
        ArrayList<Booking> bookingsArrayList = new ArrayList<Booking>();
        String query = "SELECT bookings.id as BookingId, users.id as UserId, wards.id as WardId, users.name as username, wards.name as WardName, wards.type as wardtype, wards.image as wardimage, wards.price_per_day as price_per_day, bookings.created_at as timestamp, transactions.paid_status as payment_status, bookings.check_in_date, bookings.check_out_date FROM bookings JOIN users ON bookings.user_id = users.id JOIN wards ON bookings.ward_id = wards.id JOIN transactions ON transactions.booking_id = bookings.id WHERE bookings.user_id = " + user_id;
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            Booking booking = new Booking();
            booking.SetBookingId(rs.getInt("BookingId"));
            booking.SetUserId(rs.getInt("UserId"));
            booking.SetWardId(rs.getInt("WardId"));
            booking.SetUsername(rs.getString("username"));
            booking.SetWardName(rs.getString("WardName"));
            booking.SetWardType(rs.getString("wardtype"));
            booking.SetWardImage(rs.getBlob("wardimage"));
            booking.SetWardPrice(rs.getString("price_per_day"));
            booking.SetDate(rs.getString("timestamp").split(" ")[0]);
            booking.SetTime(rs.getString("timestamp").split(" ")[1]);
            booking.SetPaymentStatus(rs.getInt("payment_status"));
            booking.SetCheckInDate(rs.getString("check_in_date"));
            booking.SetCheckOutDate(rs.getString("check_out_date"));
            bookingsArrayList.add(booking);
        }
        
        return bookingsArrayList;
    }
    
    public int SetTransactionstoDB(String bookingid, String price) throws SQLException{
        String query = "INSERT INTO `transactions`(booking_id, price) VALUES (" + bookingid + ", " + price + ")"; 
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public int GetWardPrice(String wardid) throws SQLException{
        int price = 0;
        String query = "SELECT price_per_day FROM `wards` WHERE id = " + wardid;
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {            
            price = rs.getInt("price_per_day");
        }
        
        return price;
    }
    
    public int DeleteBooking(String booking_id) throws SQLException{
        String query = "DELETE FROM `bookings` WHERE id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public ArrayList<Transaction> GetAllUserTransactions(String user_id) throws SQLException{
        ArrayList<Transaction> arrayListTransactions = new ArrayList<Transaction>();
            String query = "SELECT transactions.booking_id, transactions.price, transactions.paid_status FROM bookings LEFT JOIN transactions ON bookings.id = transactions.booking_id WHERE bookings.user_id = " + user_id;
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            arrayListTransactions.add(new Transaction(rs.getInt("booking_id"), String.valueOf(rs.getInt("price")), rs.getInt("paid_status")));
        }
        
        return arrayListTransactions;
    }
    
    public int DeleteTransaction(String booking_id) throws SQLException{
        String query = "DELETE FROM `transactions` WHERE booking_id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public int CheckinBookingDB(String check_in_date, String booking_id) throws SQLException{
        String query = "UPDATE `bookings` SET check_in_date = '" + check_in_date + "' WHERE id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public int CheckoutBookingDB(String check_in_date, String check_out_date, String booking_id) throws SQLException{
        String query = "UPDATE `bookings` SET check_in_date = '"+check_in_date+"', check_out_date = '"+check_out_date+"' WHERE id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public int GetBookingPrice(String booking_id) throws SQLException{
        String query = "SELECT price FROM `transactions` WHERE booking_id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int price = 0;
        if(rs.next()){
            price = rs.getInt("price");
        }
        
        return price;
    }
    
    public int UpdateTransactionsUser(String booking_id, String price) throws SQLException{
        String query = "UPDATE `transactions` SET price = " + price + " WHERE booking_id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public Booking GetUserBookingData(String booking_id) throws SQLException{
        String query = "SELECT bookings.id as BookingId, users.name as Name, users.email as Email, wards.name as WardName, wards.type as WardType, wards.price_per_day as PricePerDay, bookings.check_in_date as CheckInDate, bookings.check_out_date as CheckOutDate FROM bookings JOIN users ON bookings.user_id = users.id JOIN wards ON bookings.ward_id = wards.id WHERE bookings.id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        Booking booking = new Booking();
        if(rs.next()){
            booking.SetBookingId(rs.getInt("BookingId"));
            booking.SetUsername(rs.getString("Name"));
            booking.SetUserEmail(rs.getString("Email"));
            booking.SetWardName(rs.getString("WardName"));
            booking.SetWardType(rs.getString("WardType"));
            booking.SetWardPrice(rs.getString("PricePerDay"));
            booking.SetCheckInDate(rs.getString("CheckInDate"));
            booking.SetCheckOutDate(rs.getString("CheckOutDate"));
        }
        
        return booking;
    }
    
    public int UpdateTransactionPaymentsDB(String booking_id) throws SQLException{
        String query = "UPDATE `transactions` SET paid_status = 1 WHERE booking_id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public int UpdateWardStatustoDeactive(String booking_id) throws SQLException{
        String query = "SELECT ward_id FROM `bookings` WHERE id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int ward_id = rs.next() ? rs.getInt("ward_id") : 0;
        
        // set the status of wardid to 0
        query = "UPDATE `wards` SET status = 0 WHERE id = " + ward_id;
        return stmt.executeUpdate(query);
    }
    
    public int SubmitQuery(String user_id, String message) throws SQLException{
        String query = "INSERT INTO `reviews`(user_id, review) VALUES (" + user_id + ", '" + message + "')";
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public int UpdateBookingStatus(String status, String booking_id) throws SQLException{
        String query = "UPDATE `bookings` SET status = '"+status+"' WHERE `bookings`.`id` = " + booking_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
}
