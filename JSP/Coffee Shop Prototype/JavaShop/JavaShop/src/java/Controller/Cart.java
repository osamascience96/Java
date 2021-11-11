/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import bean.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Cart", urlPatterns = {"/cart_servlet"})
public class Cart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        ArrayList<Order> arrayOrderList = (ArrayList<Order>) httpSession.getAttribute("cart_list");
        
        int product_id = Integer.parseInt(req.getParameter("product_Id"));
        String session_id =  httpSession.getId();
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String notes = null;
        
        if(req.getParameter("cream_add_on") != null){
            if(!req.getParameter("cream_add_on").isEmpty()){
                notes = req.getParameter("cream_add_on").concat("\n");
            }
        }
        
        if(req.getParameter("extra_notes") != null){
            if(!req.getParameter("extra_notes").isEmpty()){
                notes = notes.concat(req.getParameter("extra_notes")).concat("\n");
            }
        }
        
        if(arrayOrderList != null){
            // add the provided files in the list 
            Order order = new Order();
            order.setSessionId(session_id);
            order.setProductId(product_id);
            order.setQuantity(quantity);
            order.setPrice(price * quantity);
            
            if(notes != null){
                order.setNotes(notes);
            }
            
            arrayOrderList.add(order);
        }else{
            arrayOrderList = new ArrayList<Order>();
            
            // add the provided files in the list 
            Order order = new Order();
            order.setSessionId(session_id);
            order.setProductId(product_id);
            order.setQuantity(quantity);
            order.setPrice(price * quantity);
            
            if(notes != null){
                order.setNotes(notes);
            }
            
            arrayOrderList.add(order);
            
            httpSession.setAttribute("cart_list", arrayOrderList);
        }
        
        resp.sendRedirect("product_servlet");
    }
    
}
