/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import bean.Order;
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
@WebServlet(name = "Checkout", urlPatterns = {"/checkout_servlet"})
public class Checkout extends HttpServlet {
    
    private model.Order orderModel = new model.Order();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "product_servlet";
        
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        
        HttpSession httpSession = req.getSession();
        
        if(httpSession.getAttribute("product_list") != null && httpSession.getAttribute("cart_list") != null){
            ArrayList<Order> arrayListOrders = (ArrayList<Order>) httpSession.getAttribute("cart_list");
            
            for(int i=0; i < arrayListOrders.size(); i++){
                Order order = arrayListOrders.get(i);
                
                // insert user information
                order.setCustomerName(username);
                order.setContactNo(phone);
                order.setAddress(address);
                
                try {
                    this.orderModel.InsertOrder(order);
                } catch (SQLException ex) {
                    Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            // remove the cart_list
            httpSession.removeAttribute("cart_list");
            
            link = link.concat("?response=submit-order-success");
        }else{
            link = link.concat("?response=failed");
        }
        
        resp.sendRedirect(link);
    }
    
}
