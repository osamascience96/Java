/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.API;

import Bean.Product;
import Helper.CartHelper;
import com.google.gson.Gson;
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
@WebServlet(name = "Cart", urlPatterns = {"/cart_servlet_api_controller"})
public class Cart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int user_id = Integer.parseInt(req.getParameter("userid"));
        int product_id = Integer.parseInt(req.getParameter("productId"));
        
        ServletContext servletContext = req.getServletContext();
        
        // check if the list already initlized in the servlet context 
        ArrayList<Bean.Cart> cartArrayList = (ArrayList<Bean.Cart>) servletContext.getAttribute("cart_list");
        
        if(cartArrayList != null){
            int Index = CartHelper.GetUserIdIndex(cartArrayList, user_id);
            
            if(Index != -1){
                // user exists
                Bean.Cart cart = cartArrayList.get(Index);
                int prodIndex = CartHelper.GetProductIndex(cart.getArrayListProducts(), product_id);
                if(prodIndex != -1){
                    Product product = cart.getArrayListProducts().get(prodIndex);
                    int previousQuantity = product.getQuantity();
                    product.setQuantity(++previousQuantity);
                }else{
                    Product product = new Product();
                    product.setId(product_id);
                    product.setQuantity(1);
                    
                    cart.getArrayListProducts().add(product);
                }
            }else{
                Product product = new Product();
                product.setId(product_id);
                product.setQuantity(1);
                
                ArrayList<Product> arrayListProducts = new ArrayList<Product>();
                arrayListProducts.add(product);
                
                cartArrayList.add(new Bean.Cart(user_id, arrayListProducts));
            }
        }else{
            // create new list, add to the servlet
            cartArrayList = new ArrayList<Bean.Cart>();
            
            Bean.Cart cart = new Bean.Cart();
            cart.setUserId(user_id);
            
            Product product = new Product();
            product.setId(product_id);
            product.setQuantity(1);
            
            cart.setArrayListProducts(new ArrayList<Product>());
            cart.getArrayListProducts().add(product);
            
            cartArrayList.add(cart);
            
            servletContext.setAttribute("cart_list", cartArrayList);
        }
        
        Model.Product productModel = new Model.Product();
        
        // using model to get modify the whole productList
        ArrayList<Product> productArrayList = cartArrayList.get(CartHelper.GetUserIdIndex(cartArrayList, user_id)).getArrayListProducts();
        for(int i=0; i < productArrayList.size(); i++){
            Product product = productArrayList.get(i);
            try {
                product = productModel.GetModifiedProductBean(product);
            } catch (SQLException ex) {
                Logger.getLogger(Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        String productListResponse = new Gson().toJson(productArrayList);
        resp.getWriter().println(productListResponse);
    }
    
}
