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
import javax.servlet.http.Part;

/**
 *
 * @author osama
 */
@WebServlet(name = "Category", urlPatterns = {"/category_controller"})
@MultipartConfig(maxFileSize = -1L)
public class Category extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        String categoryName = req.getParameter("category_name");
        String categoryDescription = req.getParameter("category_description");
        Part part = req.getPart("category_upload");
        InputStream is = part.getInputStream();
        
        HttpSession httpSession = req.getSession();
        
        Bean.Category categoryObj = new Bean.Category();
        categoryObj.setName(categoryName);
        categoryObj.setDescription(categoryDescription);
        categoryObj.setInputStream(is);
        
        Model.Category categoryModel = new Model.Category();
        
        try {
            // check if the category exists
            if(categoryModel.CheckCategoryExists(categoryObj)){
                link = "admin.jsp?response=category_exists";
            }else{
                // insert the category in the db 
                int id = categoryModel.InsertCategory(categoryObj);
                categoryObj.setId(id);
                
                ArrayList<Bean.Category> categoryArrayList = (ArrayList<Bean.Category>) httpSession.getAttribute("category_list_session");
                categoryArrayList.add(categoryObj);
                
                link = "admin.jsp?response=category_inserted";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get all the categories from the database 
        Model.Category categoryModel = new Model.Category();
        
        HttpSession httpSession = req.getSession();
        try {
            httpSession.setAttribute("category_list_session", categoryModel.GetCategoryArrayList());
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("products.jsp");
    }
    
}
