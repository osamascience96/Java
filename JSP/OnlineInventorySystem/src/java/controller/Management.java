/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Inventory;
import com.google.gson.Gson;
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
@WebServlet(name = "Management", urlPatterns = {"/management_controller"})
public class Management extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        model.Product productModel = new model.Product();
        
        if(req.getParameter("is_del") != null){
            int id = Integer.parseInt(req.getParameter("id"));
            
            try {
                productModel.DeleteInventory(id);
            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ArrayList<Inventory> arrayListInventory = null;
        
        try {
            arrayListInventory = productModel.GetAllInventoryProducts();
        } catch (SQLException ex) {
            Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("inventory_managemet_list", arrayListInventory);
        
        resp.sendRedirect("manager.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        String actionType = req.getParameter("action_type");
        
        int id = 0;
        if(req.getParameter("id") != null){
            id = Integer.parseInt(req.getParameter("id"));
        }
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        
        Inventory inventoryObj = new Inventory();
        inventoryObj.setId(id);
        inventoryObj.setName(name);
        inventoryObj.setDescription(description);
        inventoryObj.setPrice(price);
        
        model.Product productModel = new model.Product();
        
        // check if the action type is insert 
        if(actionType.compareTo("insert") == 0){
            try {
                productModel.InsertProduct(inventoryObj);
            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
            response = "insert_successfully";
        }else if(actionType.compareTo("update") == 0){
            try {
                productModel.UpdateProduct(inventoryObj);
            } catch (SQLException ex) {
                Logger.getLogger(Management.class.getName()).log(Level.SEVERE, null, ex);
            }
            response = "update_successfully";
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
}
