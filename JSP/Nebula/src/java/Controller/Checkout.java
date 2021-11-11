/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.User;
import Helper.CartHelper;
import Model.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "Checkout", urlPatterns = {"/checkout_servlet"})
public class Checkout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        
        ArrayList<Bean.Cart> cartArrayList = (ArrayList<Bean.Cart>) servletContext.getAttribute("cart_list");
        User userobj = (User) req.getSession().getAttribute("user_session");
        
        Order orderModel = new Order();
        Bean.Order orderObj = new Bean.Order();
        int index = CartHelper.GetUserIdIndex(cartArrayList, userobj.getId());
        ArrayList<Bean.Product> productArrayList = cartArrayList.get(index).getArrayListProducts();
        cartArrayList.remove(index);
        
        String productIdSet = "";
        double totalPrice = 0;
        for(int i=0; i < productArrayList.size(); i++){
            productIdSet = productIdSet.concat(String.valueOf(productArrayList.get(i).getId()) + ",");
            totalPrice += (productArrayList.get(i).getPrice() * productArrayList.get(i).getQuantity());
        }
        
        orderObj.setUserId(userobj.getId());
        orderObj.setProductSet(productIdSet);
        orderObj.setTotalPrice(totalPrice);
        
        try {
            orderModel.InsertOrder(orderObj);
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("products.jsp?response=order_placed");
    }
    
}
