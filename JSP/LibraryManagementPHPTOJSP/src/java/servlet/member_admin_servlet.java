/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Member;
import database.Connector;
import helper.AES;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "member_admin_servlet", urlPatterns = {"/member_admin_servlet"})
public class member_admin_servlet extends HttpServlet {
    
    private Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.connection = Connector.getConnectionInstance().getConnection();
        
        HttpSession httpSession = req.getSession();
        
        ArrayList<Member> memberArrayList = new ArrayList<Member>();
        
        String query = "SELECT * FROM members";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                memberArrayList.add(new Member(rs.getInt("member_id"), rs.getString("member_name"), rs.getString("username"), rs.getString("password"), rs.getInt("is_active")));
            }
            
            httpSession.setAttribute("member_admin_list", memberArrayList);
        } catch (SQLException ex) {
            Logger.getLogger(member_admin_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("memberadmin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberName = req.getParameter("member_name");
        
        this.connection = Connector.getConnectionInstance().getConnection();
        
        String query = "INSERT INTO members SET member_name = ?";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setString(1, AES.Encrypt(memberName));
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(member_admin_servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(member_admin_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("member_admin_servlet");
    }
    
}
