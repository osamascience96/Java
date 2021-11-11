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
@WebServlet(name = "Category", urlPatterns = {"/category_servlet"})
@MultipartConfig(maxFileSize = -1L)
public class Category extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "admin_servlet";
        
        String categoryName = req.getParameter("category_name");
        String categoryDescription = req.getParameter("category_description");
        Part part = req.getPart("category_image");
        InputStream inputStream = part.getInputStream();
        
        bean.Category categoryObj = new bean.Category();
        categoryObj.setName(categoryName);
        categoryObj.setDescription(categoryDescription);
        categoryObj.setInputStream(inputStream);
        
        Model.Category categoryModel = new Model.Category();
        
        try {
            if(categoryModel.CheckCategoryExists(categoryObj)){
                link = link.concat("?response=already_exists");
            }else{
                categoryModel.InsertCategory(categoryObj);
                link = link.concat("?response=category_inserted");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model.Category categoryModel = new Model.Category();
        HttpSession httpSession = req.getSession();
        
        try {
            ArrayList<bean.Category> categoryArrayList = categoryModel.GetCategoryLists();
            httpSession.setAttribute("categoryShowCaseList", categoryArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("category.jsp");
    }
    
}
