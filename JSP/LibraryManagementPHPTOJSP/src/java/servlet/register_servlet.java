/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.Connector;
import helper.AES;
import helper.MD5;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "register_servlet", urlPatterns = {"/register_servlet"})
public class register_servlet extends HttpServlet {
    private Connection connection = null;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "register.jsp";
        
        // init the member variables
        String memberName = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        // connection stance using the singleton connector class
        this.connection = Connector.getConnectionInstance().getConnection();
        
        String query1 = "SELECT personnel_id FROM personnel WHERE personnel_login = ?";
        String query2 = "SELECT member_id FROM members WHERE username = ?";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query1);
            pstmt.setString(1, username);
            
            ResultSet rs1 = pstmt.executeQuery();
            
            pstmt = this.connection.prepareStatement(query2);
            pstmt.setString(1, username);
            
            ResultSet rs2 = pstmt.executeQuery();
            
            if(rs1.next() || rs2.next()){
                link = link.concat("?message=Username already taken.");
            }else{
                String query = "INSERT INTO members (member_name, username, password) VALUES (?, ?, ?)";
                pstmt = this.connection.prepareStatement(query);
                try {
                    pstmt.setString(1, AES.Encrypt(memberName));
                    pstmt.setString(2, username);
                    pstmt.setString(3, MD5.getMd5(password));
                } catch (Exception ex) {
                    Logger.getLogger(register_servlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                pstmt.executeUpdate();
            }
            
            resp.sendRedirect(link);
            
        } catch (SQLException ex) {
            Logger.getLogger(register_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
