/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.User;
import Model.Order;
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
@WebServlet(name = "Controller", urlPatterns = {"/checkout_servlet"})
public class Checkout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("firstname");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String creditCard = req.getParameter("cc");
        
        HttpSession httpSession = req.getSession();
        
        float rating = Float.parseFloat(req.getParameter("rate") != null ? req.getParameter("rate") : "0.0");
        
        Model.User userModel = new Model.User();
        
        User userObj = new User();
        userObj.setName(fullName);
        userObj.setAddress(address);
        userObj.setPhoneNumber(phone);
        userObj.setEmail(email);
        userObj.setCreditCardNumber(creditCard);
        userObj.setRating(rating);
        
        int userId = userModel.InsertUser(userObj);
        
        ArrayList<Bean.Product> productCartArrayList = (ArrayList<Bean.Product>) httpSession.getAttribute("productCartArrayList");
        
        String productIdArrayString = "";
        double totalPrice = 0;
        
        for(int i=0; i < productCartArrayList.size(); i++){
            totalPrice += productCartArrayList.get(i).getPrice();
            productIdArrayString += (String.valueOf(productCartArrayList.get(i).getId()).concat(","));
        }
        
        Order orderModel = new Order();
        
        Bean.Order orderObj = new Bean.Order();
        orderObj.setUserId(userId);
        orderObj.setProductSets(productIdArrayString);
        orderObj.setTotalPrice(totalPrice);
        
        int orderId = 0;
        
        try {
            orderId = orderModel.InsertOrder(orderObj);
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(rating > 0.0){
            try {
                // Add Rating to the database
                userModel.SetRating(userId, orderId, rating);
            } catch (SQLException ex) {
                Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // empty the cart list
        httpSession.removeAttribute("productCartArrayList");
        httpSession.invalidate();
        
        resp.sendRedirect("product_servlet?resposne=insert_success");
    }
    
}
