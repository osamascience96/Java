/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Product;
import Bean.User;
import File.Property;
import Helper.DateTimeHelper;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Admin", urlPatterns = {"/admin_servlet"})
public class Admin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String propertyName = req.getParameter("property_name");
        String propertyLocation = req.getParameter("property_location");
        double propertyPrice = Integer.parseInt(req.getParameter("property_price"));
        String date = DateTimeHelper.GetCurrentDateTimeStamp();
        
        Product productObj = new Product();
        productObj.setUserId(((User)req.getSession().getAttribute("user_session")).getId());
        productObj.setPropertyName(propertyName);
        productObj.setLocation(propertyLocation);
        productObj.setPrice(propertyPrice);
        productObj.setDate(date);
        
        String path = req.getServletContext().getRealPath("/files/property.json").toString();
        System.out.println(path);
        Property property = new Property(path);
        property.InsertData(productObj);
        
        resp.sendRedirect("admin_servlet?response=property_added");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "admin.jsp";
        
        HttpSession httpSession = req.getSession();
        
        User userObj = (User) httpSession.getAttribute("user_session");
        
        String response = req.getParameter("response");
        
        String path = req.getServletContext().getRealPath("/files/property.json").toString();
        System.out.println(path);
        Property property = new Property(path);
        // check if the delete item request is added 
        if(req.getParameter("isdel") != null){
            boolean is_del = Boolean.parseBoolean(req.getParameter("isdel"));
            if(is_del){
                int id = Integer.parseInt(req.getParameter("propertyid"));
                property.DeleteProperty(id);
                response = "delete_success";
            }
        }
        httpSession.setAttribute("property_user_list", property.GetUserProperty(userObj.getId()));
        
        if(response != null){
            link = link.concat("?response=").concat(response);
        }
        
        resp.sendRedirect(link);
    }
    
}
