/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author osama
 */
@WebServlet(name = "Product", urlPatterns = {"/product_servlet"})
@MultipartConfig(maxFileSize = -1L)
public class Product extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        Model.Product productModel = new Model.Product();
        try {
            httpSession.setAttribute("product_list_customer", productModel.GetAllProductList());
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("product.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "admin_servlet";
        
        int categoryId = req.getParameter("categoryIdSelect") != null ? Integer.parseInt(req.getParameter("categoryIdSelect")) : 0;
        String productName = req.getParameter("product_name");
        String productDescription = req.getParameter("product_description");
        double productPrice = Double.parseDouble(req.getParameter("product_price"));
        Part part = req.getPart("product_image");
        InputStream is = part.getInputStream();
        
        bean.Product productObj = new bean.Product();
        productObj.setCategory_id(categoryId);
        productObj.setName(productName);
        productObj.setDescription(productDescription);
        productObj.setPrice(productPrice);
        productObj.setInputStream(is);
        
        Model.Product productModel = new Model.Product();
        // check if the category id is 0
        if(categoryId != 0){
            try {
                // check if the product already exists
                if(productModel.IsProductAlreadyExists(productObj)){
                    link = link.concat("?response=").concat("product_already_exists");
                }else{
                    productModel.InsertProduct(productObj);
                    link = link.concat("?response=").concat("product_inserted_successfully");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            link = link.concat("?response=").concat("categoryid_not_set");
        }
        
        resp.sendRedirect(link);
    }
    
}