/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Logout", urlPatterns = {"/logout_controller"})
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        httpSession.removeAttribute("is_login");
        httpSession.removeAttribute("userObj");
        httpSession.removeAttribute("inventoryList");
        httpSession.removeAttribute("inventory_managemet_list");
        httpSession.removeAttribute("users_admin_list");
        
        httpSession.invalidate();
        
        resp.sendRedirect("index.jsp");
    }
    
}
