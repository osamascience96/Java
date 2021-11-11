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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String holdingNumber = req.getParameter("holdingnum");
        String zone = req.getParameter("zone");
        String zone_owner = req.getParameter("zone_owner");
        String mobile_number = req.getParameter("mobile_num");
        String alter_mobile_number = req.getParameter("alter_mobile_num");
        String email = req.getParameter("email");
        
        Register registerDAO = new Register();
        
        EJB.Register register = new EJB.Register();
        register.setAssesseId(12345);
        register.setEmail(email);
        register.setBillNo(null);
        register.setRemarks(null);
        register.setMobileNo1(mobile_number);
        register.setMobileNo2(alter_mobile_number);
        
        // check if the registrtion table has the credentials
        EJB.Register registerObj = registerDAO.CheckRegistration(email);
        if(registerObj != null){
            response = String.valueOf(registerObj.getId());
        }else{
            int is_registered = registerDAO.InsertRegisteration(register);
            if(is_registered > 0){
                response = String.valueOf(is_registered);
            }else{
                response = "user_not_registered";
            }
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
