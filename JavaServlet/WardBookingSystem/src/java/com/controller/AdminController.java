/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


import com.pojo.Booking;
import com.service.AdminService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet("/admin-controller-servlet")
public class AdminController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("admin-mode");
        AdminService adminService = new AdminService();
        HttpSession httpSession = req.getSession();
        
        if(mode.equals("admin")){
            // getting today's date
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String todaydate = formatter.format(new Date());
            ArrayList<Booking> arrayListBookings = adminService.GettingTodayBookingsDB(todaydate);
            httpSession.setAttribute("BookingList", arrayListBookings);
            resp.sendRedirect("admin.jsp");
        }else if (mode.equals("ward")){
            httpSession.setAttribute("wards", adminService.GetAllWardDetails());
            resp.sendRedirect("wards.jsp");
        }else if(mode.equals("users")){
            httpSession.setAttribute("users", adminService.GetAllUsersDetails());
            resp.sendRedirect("users.jsp");
        }else if(mode.equals("bookings")){
            httpSession.setAttribute("bookings", adminService.GetAllBookingsDetails());
            resp.sendRedirect("bookings.jsp");
        }else if(mode.equals("reports")){
            httpSession.setAttribute("admin-reports", adminService.GetAllReportsDB());
            resp.sendRedirect("reports.jsp");
        }else if(mode.equals("reviews")){
            httpSession.setAttribute("reviewscustomer", adminService.GetAllCustomerReiviews());
            resp.sendRedirect("reviews.jsp");
        }
        
        // All Delete modes
        if(mode.equals("delete")){
            String del_mode = req.getParameter("del_mode");
            if(del_mode.equals("booking")){
                String booking_id = req.getParameter("booking");
                String ward_id = req.getParameter("ward_id");
                boolean response = adminService.DeleteBooking(booking_id);
                response = adminService.DeactiveWard(ward_id);
                response = adminService.DeleteTransactionfromDB(booking_id);
                if(req.getParameter("current_module").equals("todaybooking")){
                    resp.sendRedirect("admin-controller-servlet?admin-mode=admin");
                }else if(req.getParameter("current_module").equals("allbookigs")){
                    resp.sendRedirect("admin-controller-servlet?admin-mode=bookings");
                }
            }else if(del_mode.equals("user")){
                String user_id = req.getParameter("user");
                boolean response = adminService.DeleteUser(user_id);
                if(req.getParameter("current_module").equals("users")){
                    resp.sendRedirect("admin-controller-servlet?admin-mode=users");
                }
            }else if(del_mode.equals("wards")){
                String ward_id = req.getParameter("ward");
                boolean response = adminService.DeleteWard(ward_id);
                if(req.getParameter("current_module").equals("wards")){
                    resp.sendRedirect("admin-controller-servlet?admin-mode=ward");
                }
            }
        }else if(mode.equals("edit")){
            String edit_mode = req.getParameter("edit_mode");
            if(edit_mode.equals("user")){
                String user_id = req.getParameter("user");
                httpSession.setAttribute("user-edit", adminService.GetUserfromDB(user_id));
                resp.sendRedirect("edituser.jsp");
            }else if(edit_mode.equals("wards")){
                String ward_id = req.getParameter("ward");
                httpSession.setAttribute("ward-edit", adminService.GetWardfromDB(ward_id));
                resp.sendRedirect("editward.jsp");
            }else if(edit_mode.equals("booking")){
                String booking_id = req.getParameter("booking_id");
                httpSession.setAttribute("bookingdatauser", adminService.GetUserBookingDataDB(booking_id));
                resp.sendRedirect("editbooking.jsp");
            }
        }
        
    }
    
}
