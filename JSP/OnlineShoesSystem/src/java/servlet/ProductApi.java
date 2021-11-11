/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "ProductApi", urlPatterns = {"/product_api_servlet"})
public class ProductApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("category_Id"));
        
        Model.Product productModel = new Model.Product();
        
        String response = "";
        
        try {
            response = new Gson().toJson(productModel.GetAllCategoryProducts(categoryId));
        } catch (SQLException ex) {
            Logger.getLogger(ProductApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.getWriter().println(response);
    }
}
