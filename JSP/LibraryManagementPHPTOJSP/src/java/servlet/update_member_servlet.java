/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.Connector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
@WebServlet(name = "update_member_servlet", urlPatterns = {"/update_member_servlet"})
public class update_member_servlet extends HttpServlet {
    
    private Connection connection = null;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int memberId = Integer.parseInt(req.getParameter("member_id"));
        
        String query = "";
        
        this.connection = Connector.getConnectionInstance().getConnection();
        
        if(action.compareTo("active") == 0){
            query = "UPDATE members SET is_active = 1 WHERE member_id = ?";
        }else if(action.compareTo("deactive") == 0){
            query = "UPDATE members SET is_active = 0 WHERE member_id = ?";
        }
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, memberId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(update_member_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("member_admin_servlet");
    }
}
