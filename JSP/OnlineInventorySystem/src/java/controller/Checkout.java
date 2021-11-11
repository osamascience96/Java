/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Inventory;
import bean.Order;
import bean.User;
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
@WebServlet(name = "Checkout", urlPatterns = {"/checkout_controller"})
public class Checkout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        ArrayList<Inventory> inventoryArrayList = (ArrayList<Inventory>) httpSession.getAttribute("inventoryList");
        
        Order orderObj = new Order();
        orderObj.setInventoryArrayList(inventoryArrayList);
        orderObj.setUser((User)httpSession.getAttribute("userObj"));
        
        model.Order orderModel = new model.Order();
        try {
            orderModel.InsertOrder(orderObj);
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        httpSession.removeAttribute("inventoryList");
        
        resp.sendRedirect("index.jsp");
    }
    
}
