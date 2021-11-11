/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.database.Connector;
import com.pojo.Booking;
import com.pojo.Report;
import com.pojo.Review;
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
public class Admin {
    private Connection connection = null;
    
    public Admin(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public ArrayList<Booking> GettingTodayBookingsDB(String date) throws SQLException{
        
        ArrayList<Booking> arrayListBooking = new ArrayList<Booking>();
        
        String query = "SELECT bookings.id as BookingId, users.id as UserID, users.name as UserName, users.email as UserMail, users.image as UserImage, wards.id as WardId, wards.name as WardName, wards.type as WardType, wards.image as WardsImage, transactions.paid_status as Payed_Status, bookings.status as status FROM bookings JOIN `users` ON bookings.user_id = users.id JOIN `wards` ON wards.id = bookings.ward_id JOIN `transactions` ON bookings.id = transactions.booking_id WHERE bookings.created_at LIKE '%"+ date +"%'";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            Booking booking = new Booking(rs.getInt("BookingId"), rs.getInt("UserID"), rs.getInt("WardId"), rs.getString("UserName"), rs.getString("UserMail"), rs.getBlob("UserImage"), rs.getString("WardName"), rs.getString("WardType"), rs.getBlob("WardsImage"));
            booking.SetPaymentStatus(rs.getInt("Payed_Status"));
            booking.SetStatus(rs.getString("status"));
            arrayListBooking.add(booking);
        }
        
        return arrayListBooking;
    }
    
    public ArrayList<Ward> GetAllWards() throws SQLException{
        ArrayList<Ward> wardsArrayList = new ArrayList<Ward>();
        String query = "SELECT * FROM `wards`";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        String datetimeArray[] = null;
        
        while(rs.next()){
            datetimeArray = rs.getString("created_at").split(" ");
            Ward ward = new Ward(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getBlob("image"), datetimeArray[0], datetimeArray[1]);
            ward.SetStatus(rs.getInt("status"));
            ward.SetPrice(rs.getString("price_per_day"));
            wardsArrayList.add(ward);
        }
        
        return wardsArrayList;
    }
    
    public ArrayList<com.pojo.User> GetAllUsersDB() throws SQLException{
        ArrayList<com.pojo.User> usersArrayList = new ArrayList<com.pojo.User>();
        String query = "SELECT * FROM `users`";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            com.pojo.User user = new com.pojo.User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phone"), rs.getString("status"), rs.getString("nationality"), rs.getString("date_of_birth"));
            user.SetTimeStamp(rs.getString("created_at"));
            user.SetImage(rs.getBlob("image"));
            
            usersArrayList.add(user);
        }
        
        
        return usersArrayList;
    }
    
    public ArrayList<Booking> GetAllBookingsDB() throws SQLException{
        ArrayList<Booking> bookingsArrayList = new ArrayList<>();
        String query = "SELECT bookings.id as BookId, users.id as UserId, users.name as UName, users.email as UEmail, users.image as UImage, wards.id as WId, wards.name as WName, wards.type as WType, wards.image as WImage, bookings.created_at as datetime, transactions.paid_status as payedstatus, bookings.status FROM bookings JOIN users ON bookings.user_id = users.id JOIN wards ON bookings.ward_id = wards.id JOIN transactions ON transactions.booking_id = bookings.id";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            String datetimeArray[] = rs.getString("datetime").split(" ");
            Booking booking = new Booking(rs.getInt("BookId"), rs.getInt("UserId"), rs.getInt("WId"), rs.getString("UName"), rs.getString("UEmail"), rs.getBlob("UImage"), rs.getString("WName"), rs.getString("WType"), rs.getBlob("WImage"));
            booking.SetDate(datetimeArray[0]);
            booking.SetTime(datetimeArray[1]);
            booking.SetPaymentStatus(rs.getInt("payedstatus"));
            booking.SetStatus(rs.getString("status"));
            
            bookingsArrayList.add(booking);
        }
        
        return bookingsArrayList;
    }
    
    public int DeleteBooking(String bookingId) throws SQLException{
        String query = "DELETE FROM bookings WHERE id = " + bookingId;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public int DeleteUser(String userid) throws SQLException{
        String query = "DELETE FROM `users` WHERE id = " + userid;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public int DeleteWard(String wardId) throws SQLException{
        String query = "DELETE FROM `wards` WHERE id = " + wardId;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    
    public com.pojo.User GetUser(String user_id) throws SQLException{
        String query = "SELECT * FROM `users` WHERE id = " + user_id;
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        com.pojo.User user = null;
        
        while(rs.next()){
            user = new com.pojo.User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("phone"), rs.getString("status"), rs.getString("nationality"), rs.getString("date_of_birth"));
            user.SetImage(rs.getBlob("image"));
            user.SetTimeStamp(rs.getString("created_at"));
        }
        
        return user;
    }
    
    public int EditUserDB(com.pojo.User user) throws SQLException{
        String query = "UPDATE `users` SET name = '"+user.GetName()+"', email = '"+user.GetEmail()+"', phone = '"+user.GetPhone()+"', nationality = '"+user.GetNationality()+"', gender = '"+user.GetGender()+"', status = '"+user.GetStatus()+"', date_of_birth = '"+user.GetDateOfBirth()+"' WHERE id = " + user.GetId();
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public Ward GetWard(String ward_id) throws SQLException{
        String query = "SELECT * FROM `wards` WHERE id = " + ward_id;
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        Ward ward = null;
        while(rs.next()){
            ward = new Ward(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getBlob("image"), rs.getString("created_at").split(" ")[0], rs.getString("created_at").split(" ")[1]);
            ward.SetStatus(rs.getInt("status"));
            ward.SetPrice(rs.getString("price_per_day"));
        }
        
        return ward;
    }
    
    public int EditWardDB(Ward ward) throws SQLException{
        String status = ward.GetStatus().equals("Booked") ? "1" : "0";
        String query = "UPDATE `wards` SET name = '"+ward.GetName()+"', type='"+ward.GetType()+"', status='"+status+"', price_per_day='"+ward.GetPrice()+"' WHERE id = " + ward.GetId();
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
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
    
    public int InsertWardDB(Ward ward) throws SQLException{
        String query = "INSERT INTO `wards`(name, type, price_per_day) VALUES ('"+ward.GetName()+"','"+ward.GetType()+"', '"+ward.GetPrice()+"')";
        PreparedStatement stmt = this.connection.prepareStatement(query);
        return stmt.executeUpdate(query);
    }
    
    public int DeleteTransaction(String booking_id) throws SQLException{
        String query = "DELETE FROM `transactions` WHERE booking_id = " + booking_id;
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
    
    public Booking GetUserBookingData(String booking_id) throws SQLException{
        String query = "SELECT bookings.id as BookingId, users.name as Name, users.email as Email, wards.name as WardName, wards.type as WardType, wards.price_per_day as PricePerDay, bookings.status as status, bookings.check_in_date as CheckInDate, bookings.check_out_date as CheckOutDate FROM bookings JOIN users ON bookings.user_id = users.id JOIN wards ON bookings.ward_id = wards.id WHERE bookings.id =" + booking_id;
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
            booking.SetStatus(rs.getString("status"));
        }
        
        return booking;
    }
    
    public ArrayList<Report> GetAllReports() throws SQLException{
        String reportQuery_1 = "SELECT COUNT(*) FROM bookings";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(reportQuery_1);
        
        ArrayList<Report> arrayListReports = new ArrayList<Report>();
        while(rs.next()){
            arrayListReports.add(new Report(rs.getInt("COUNT(*)")));
        }
        
        return arrayListReports;
    }
    
    public ArrayList<Review> GetAllCustomerReviews() throws SQLException{
        ArrayList<Review> arrayListReviews = new ArrayList<Review>();
        
        String query = "SELECT users.name, users.email, users.phone, users.image, reviews.review as message FROM reviews JOIN users ON reviews.user_id = users.id";
        Statement stmt = this.connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next()){
            arrayListReviews.add(new Review(rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getBlob("image"), rs.getString("message")));
        }
        
        return arrayListReviews;
    }
    
    public int UpdateUserProfile(com.pojo.User user) throws SQLException{
        String query = "UPDATE `users` SET name = '"+user.GetName()+"', phone = '"+user.GetPhone()+"', gender = '"+user.GetGender()+"', status = '"+user.GetStatus()+"', nationality = '"+user.GetNationality()+"', date_of_birth = '"+user.GetDateOfBirth()+"' WHERE id = " + user.GetId();
        Statement stmt = this.connection.createStatement();
        return stmt.executeUpdate(query);
    }
}
