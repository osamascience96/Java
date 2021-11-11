/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.pojo.User;
import com.service.CustomerService;
import com.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author osama
 */
@WebServlet("/customer-controller-servlet")
public class CustomerController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        
        HttpSession httpSession = req.getSession();
        
        String customerMode = req.getParameter("customer-mode");
        User user = (User) httpSession.getAttribute("User");
        
        if (customerMode.equals("default")){
            httpSession.setAttribute("wardsList", customerService.GetAllWardsforUser());
            resp.sendRedirect("customer.jsp");
        }else if(customerMode.equals("bookings")){
            String user_id = String.valueOf(user.GetId());
            httpSession.setAttribute("customerbookinglist", customerService.GetAllUserBookings(user_id));
            resp.sendRedirect("customerbookings.jsp");
        }else if(customerMode.equals("history")){
            String user_id = String.valueOf(user.GetId());
            httpSession.setAttribute("customerbookinghistorylist", customerService.GetAllUserBookingHistoryDB(user_id));
            resp.sendRedirect("history.jsp");
        }
        else if(customerMode.equals("transactions")){
            String user_id = String.valueOf(user.GetId());
            httpSession.setAttribute("userTransactionsList", customerService.GetAllUserTransactions(user_id));
            resp.sendRedirect("customertransactions.jsp");
        }else if(customerMode.equals("ward-book")){
            String ward_id = req.getParameter("ward_id");
            String user_id = String.valueOf(user.GetId());
            // inert booking
            int bookingid = customerService.InsertBooking(ward_id, user_id);
            // updating ward status booked to booked
            boolean response = customerService.UpdateWardStatus(ward_id);
            // Get Ward price 
            int wardUnitPrice = customerService.GetWardPrice(ward_id);
            // insert transaction 
            response = customerService.InsertTransaction(String.valueOf(bookingid), String.valueOf(wardUnitPrice));
            resp.sendRedirect("customer-controller-servlet?customer-mode=edit-booking&booking_id=" + bookingid);
        }else if(customerMode.equals("delete-book")){
            String booking_id = req.getParameter("booking_id");
            String ward_id = req.getParameter("ward_id");
            // delete the booking 
            boolean response = customerService.DeleteBookingfromDB(booking_id);
            // deactivate ward
            response = customerService.DeactiveWard(ward_id);
            // delete transactions
            response = customerService.DeleteTransactionfromDB(booking_id);
            resp.sendRedirect("customer-controller-servlet?customer-mode=bookings");
        }else if(customerMode.equals("edit-booking")){
            String booking_id = req.getParameter("booking_id");
            httpSession.setAttribute("bookingdatacustomer", customerService.GetUserBookingDataDB(booking_id));
            resp.sendRedirect("editcustomerbooking.jsp");
        }else if(customerMode.equals("edit-payment")){
            String booking_id = req.getParameter("booking_id");
            boolean response = customerService.UpdateTransactionPayedStatus(booking_id);
            resp.sendRedirect("admin-controller-servlet?admin-mode=bookings");
        }else if(customerMode.equals("edit-ward-status")){
            String booking_id = req.getParameter("booking_id");
            boolean response = customerService.UpdateWardStatusDeactiveDB(booking_id);
            resp.sendRedirect("admin-controller-servlet?admin-mode=bookings");
        }else if(customerMode.equals("contactus")){
            resp.sendRedirect("contactus.jsp");
        }else if(customerMode.equals("profile")){
            UserService userService = new UserService();
            User userdata = userService.GetUserDataviaid(String.valueOf(user.GetId()));
            httpSession.setAttribute("User", userdata);
            resp.sendRedirect("profile.jsp");
        }else if(customerMode.equals("edit-booking-status")){
            String booking_status = req.getParameter("booking_Status");
            String booking_id = req.getParameter("booking_id");
            boolean response = customerService.UpdateBookingStatusDB(booking_status, booking_id);
            resp.sendRedirect("admin-controller-servlet?admin-mode=bookings");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user_id = req.getParameter("user_id");
        String message = req.getParameter("user-review");
        
        CustomerService customerService = new CustomerService();
        boolean response = customerService.SubmitReview(user_id, message);
        if(response){
            resp.sendRedirect("customer.jsp?submitqueryresponse=submit");
        }else{
            resp.sendRedirect("customer.jsp?submitqueryresponse=not-submit");
        }
    }
}
