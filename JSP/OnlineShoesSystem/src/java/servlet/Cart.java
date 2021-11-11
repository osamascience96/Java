/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
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
@WebServlet(name = "Cart", urlPatterns = {"/cart_controller"})
public class Cart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        int id = Integer.parseInt(req.getParameter("id"));
        
        HttpSession httpSession = req.getSession();
        
        boolean isLogin = (Boolean)(httpSession.getAttribute("is_login") != null ? httpSession.getAttribute("is_login") : false);
        if(isLogin){
            
            ArrayList<bean.Product> arrayListProducts = (ArrayList<bean.Product>)httpSession.getAttribute("cart_product_arraylist");
            
            if(arrayListProducts != null){
                bean.Product product = new bean.Product();
                product.setId(id);
                
                arrayListProducts.add(product);
            }else{
                arrayListProducts = new ArrayList<bean.Product>();
                
                bean.Product product = new bean.Product();
                product.setId(id);
                
                arrayListProducts.add(product);
                
                httpSession.setAttribute("cart_product_arraylist", arrayListProducts);
            }
            response = new Gson().toJson(arrayListProducts);
        }else{
            response = new Gson().toJson("session_timeout");
        }
        
        resp.getWriter().println(response);
    }
    
}
