/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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

/**
 *
 * @author osama
 */
@WebServlet(name = "Product", urlPatterns = {"/product_controller"})
@MultipartConfig(maxFileSize = -1L)
public class Product extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        int category_id = Integer.parseInt(req.getParameter("category_selection"));
        String name = req.getParameter("product_name");
        String description = req.getParameter("product_description");
        double price = Double.parseDouble(req.getParameter("product_price"));
        InputStream is = req.getPart("product_upload").getInputStream();
        
        Bean.Product productObj = new Bean.Product();
        productObj.setCategoryId(category_id);
        productObj.setName(name);
        productObj.setDescription(description);
        productObj.setPrice(price);
        productObj.setInputStream(is);
        
        Model.Product productModel = new Model.Product();
        
        try {
            if(productModel.CheckProductExists(productObj)){
                link = "admin.jsp?response=product_exists";
            }else{
                productModel.InsertProduct(productObj);
                link = "admin.jsp?response=product_insert_success";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int category_id = Integer.parseInt(req.getParameter("cid"));
        Model.Product productModel = new Model.Product();
        HttpSession httpSession = req.getSession();
        try {
            httpSession.setAttribute("sub_product_list", productModel.GetProductArrayList(category_id));
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp.sendRedirect("subproducts.jsp");
    }
    
}
