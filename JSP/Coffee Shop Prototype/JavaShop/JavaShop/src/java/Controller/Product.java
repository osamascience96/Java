/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
    
    private model.Product productModel = new model.Product();
    
    String link = "index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<bean.Product> productArrayList = null;
        
        HttpSession httpSession = req.getSession();
        
        try {
            productArrayList = this.productModel.GetAllProducts();
            httpSession.setAttribute("product_list", productArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(req.getParameter("response") != null){
            link = "index.jsp";
            link = link.concat("?respond=").concat(req.getParameter("response"));
        }
        
        resp.sendRedirect(link);
    }
    
}
