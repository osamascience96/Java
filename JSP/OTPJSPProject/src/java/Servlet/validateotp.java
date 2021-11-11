/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.Register;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "validateotp", urlPatterns = {"/validateotp"})
public class validateotp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        int registerationKey = Integer.parseInt(req.getParameter("registration_key"));
        int otpcode = Integer.parseInt(req.getParameter("otpcode"));
        
        Register register = new Register();
        if(register.CheckOTPValidity(registerationKey, otpcode)){
            response = "otpvalidated";
        }else{
            response = "otpinvalidinput";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
