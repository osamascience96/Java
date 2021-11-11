/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logout;

import com.database.Connector;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author osama
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout_servlet"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("name");
        httpSession.removeAttribute("email");
        httpSession.invalidate();
        
        try {
            // close the database connection on logout
            Connector.getConnectionInstance().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("/EnterpriseApplication/");
    }
    
}
