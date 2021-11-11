/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Inventory;
import bean.User;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Cart", urlPatterns = {"/cart_controller"})
public class Cart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        
        HttpSession httpSession = req.getSession();
        
        ArrayList<Inventory> inventoryArrayList = (ArrayList<Inventory>) httpSession.getAttribute("inventoryList");
        
        if(inventoryArrayList != null){
            Inventory inventory = new Inventory();
            inventory.setId(id);
            inventory.setName(name);
            inventory.setPrice(price);
            
            inventoryArrayList.add(inventory);
        }else{
            inventoryArrayList = new ArrayList<Inventory>();
            
            Inventory inventory = new Inventory();
            inventory.setId(id);
            inventory.setName(name);
            inventory.setPrice(price);
            
            inventoryArrayList.add(inventory);
            
            httpSession.setAttribute("inventoryList", inventoryArrayList);
        }
        
        String response = new Gson().toJson(inventoryArrayList);
        resp.getWriter().println(response);
    }
    
}
