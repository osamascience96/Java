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
@WebServlet(name = "UpdateRegistration", urlPatterns = {"/UpdateRegistration"})
public class UpdateRegistration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int registerId = Integer.parseInt(req.getParameter("register_id"));
        int otp = Integer.parseInt(req.getParameter("otp_input"));
        
        Register registerDAO = new Register();
        int is_updated = registerDAO.UpdateRegistrationTable(registerId, otp);
        
        String response = "";
        
        if(is_updated > 0){
            response = "updated_success";
        }else{
            response = "updated_failed";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
