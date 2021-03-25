/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.service.CustomerService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author osama
 */
@WebServlet("/editbookingcontroller")
public class EditBookingController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String booking_id = req.getParameter("booking_id");
        String check_in_date = req.getParameter("check-in-date");
        String check_out_date = req.getParameter("check-out-date");
        
        CustomerService customerService = new CustomerService();
        
        // both must not be null
        if(check_in_date != null && check_out_date != null){
            LocalDate startDate = LocalDate.parse(check_in_date);
            LocalDate endDate = LocalDate.parse(check_out_date);

            int days = Days.daysBetween(startDate, endDate).getDays();

            // update checkout date in bookins 
            customerService.UpdateBookingCheckOutDate(check_in_date, check_out_date, booking_id);
            // Get Booking Price from DB
            int price = customerService.GetBookingPriceDB(booking_id);
            // calculating the price wrt to days counted
            price = price * days;
//            // updating the price to the transaction table 
            boolean response = customerService.UpdateTransaction(booking_id, String.valueOf(price));
            resp.sendRedirect("admin-controller-servlet?admin-mode=bookings");
        }else{
            resp.sendRedirect("admin-controller-servlet?admin-mode=admin");
        }
    }
}
