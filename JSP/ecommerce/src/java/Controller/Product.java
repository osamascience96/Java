/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
@WebServlet(name = "Product", urlPatterns = {"/product_servlet"})
public class Product extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        Model.Product productModel = new Model.Product();
        Model.Order orderModel = new Model.Order();
        
        String soloProduct = req.getParameter("solo_prod");
        
        HttpSession httpSession = req.getSession();
        
        if(soloProduct != null){
            if(soloProduct.compareTo("true") == 0){
                try {
                    int id = Integer.parseInt(req.getParameter("id"));
                    Bean.Product product = productModel.GetSingleProduct(id);
                    httpSession.setAttribute("product", product);
                } catch (SQLException ex) {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                }
                link = "product.jsp";
            }
        }else{
            try {
                ArrayList<Bean.Product> arrayListProducts = productModel.GetProductArrayList();
                httpSession.setAttribute("product_list", arrayListProducts);
                httpSession.setAttribute("average_rating", orderModel.GetAverageOrdersRating());
            } catch (SQLException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            link = "index.jsp";
        }
        
        if(req.getParameter("resposne") != null){
            link = link.concat("?response=").concat(req.getParameter("resposne"));
        }
        
        resp.sendRedirect(link);
    }
    
}
