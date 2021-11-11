/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Model.Order;
import bean.Orders;
import bean.User;
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
@WebServlet(name = "Checkout", urlPatterns = {"/checkout_servlet"})
public class Checkout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "checkout.jsp";
        
        HttpSession httpSession = req.getSession();
        
        ArrayList<bean.Product> arrayListProducts = (ArrayList<bean.Product>)httpSession.getAttribute("cart_product_arraylist");
        if(arrayListProducts != null){
            if(arrayListProducts.size() > 0){
                Model.Product productModel = new Model.Product();
                // updaing the cart list with data 
                for(int i=0; i < arrayListProducts.size(); i++){
                    try {
                        bean.Product product = productModel.GetProduct(arrayListProducts.get(i).getId());
                        arrayListProducts.set(i, product);
                    } catch (SQLException ex) {
                        Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else{
                link = "index.jsp";
            }
        }else{
            link = "index.jsp";
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        boolean doCheckout = Boolean.parseBoolean(req.getParameter("checkout"));
        
        HttpSession httpSession = req.getSession();
        
        User userObj = (User)(httpSession.getAttribute("user_obj"));
        
        String product_sets = "";
        ArrayList<bean.Product> arrayListProducts = (ArrayList<bean.Product>)httpSession.getAttribute("cart_product_arraylist");
        for(int i=0; i < arrayListProducts.size(); i++){
            product_sets += String.valueOf(arrayListProducts.get(i).getId()).concat(",");
        }
        
        Order orderModel = new Order();
        
        Orders orderObj = new Orders();
        orderObj.setUser_id(userObj.getId());
        orderObj.setProduct_sets(product_sets);
        
        if(doCheckout){
            try {
                orderModel.InsertOrder(orderObj);
            } catch (SQLException ex) {
                Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
            }
            response = "insert_success";
        }else{
            response = "no_list";
        }
        
        httpSession.removeAttribute("cart_product_arraylist");
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
    
}
