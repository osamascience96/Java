/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
@WebServlet(name = "Admin", urlPatterns = {"/admin_servlet"})
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "admin.jsp";
        String response = req.getParameter("response");
        
        HttpSession httpSession = req.getSession();
        
        Model.Category categoryModel = new Model.Category();
        
        try {
            ArrayList<bean.Category> categoryArrayList = categoryModel.GetCategoryLists();
            httpSession.setAttribute("categoryList", categoryArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (response != null){
            link = link.concat("?response=").concat(response);
        }
        
        resp.sendRedirect(link);
    }
    
}
