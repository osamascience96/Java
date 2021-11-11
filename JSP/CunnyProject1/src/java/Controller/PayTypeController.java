/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.PaymentLog;
import Model.Payment;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "PayTypeController", urlPatterns = {"/pay_type_controller"})
public class PayTypeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int timesheetId = Integer.parseInt(req.getParameter("timesheetid"));
        
        Payment paymentModel = new Payment();
        
        try {
            PaymentLog paymentLog = paymentModel.GetPaymentLog(timesheetId);
            ArrayList<Bean.Payment> arrayListPayments = paymentModel.GetAllPaymentList();
            
            HttpSession httpSession = req.getSession();
            
            httpSession.setAttribute("paymentLog", paymentLog);
            httpSession.setAttribute("paymentList", arrayListPayments);
            
        } catch (SQLException ex) {
            Logger.getLogger(PayTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("payment.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int paymentTypeID = Integer.parseInt(req.getParameter("paymentType"));
        int timeSheetID = Integer.parseInt(req.getParameter("timesheetID"));
        
        Payment paymentModel = new Payment();
        try {
            paymentModel.UpdatePaymentMethod(timeSheetID, paymentTypeID);
        } catch (SQLException ex) {
            Logger.getLogger(PayTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String response = new Gson().toJson("payment_method_update_done");
        resp.getWriter().println(response);
    }
    
}
