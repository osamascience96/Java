/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Member;
import bean.Personnel;
import com.google.gson.Gson;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author osama
 */
@WebServlet(name = "login_servlet_library", urlPatterns = {"/login_servlet_library"})
public class login_servlet_library extends HttpServlet {
    private Connection connection = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        this.connection = Connector.getConnectionInstance().getConnection();
        
        String logincredentials = req.getParameter("username");
        String password = MD5.getMd5(req.getParameter("password"));
        
        String query1 = "SELECT * FROM personnel WHERE personnel_login = ? and personnel_password = ?";
        String query2 = "SELECT *, is_active FROM members WHERE username = ? and password = ?";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query1);
            pstmt.setString(1, logincredentials);
            pstmt.setString(2, password);
            ResultSet rs1 = pstmt.executeQuery();
            
            pstmt = this.connection.prepareStatement(query2);
            pstmt.setString(1, logincredentials);
            pstmt.setString(2, password);
            ResultSet rs2 = pstmt.executeQuery();
            
            HttpSession httpSession = req.getSession();
            
            if(rs1.next()){
                httpSession.setAttribute("admin", new Personnel(rs1.getInt("personnel_id"), rs1.getString("personnel_login"), rs1.getString("personnel_password")));
                response = "admin_login_success";
            }else if(rs2.next()){
                int isActive = rs2.getInt("is_active");
                
                if(isActive == 1){
                    try {
                        httpSession.setAttribute("member", new Member(rs2.getInt("member_id"), AES.Decrypt(rs2.getString("member_name")), rs2.getString("username"), rs2.getString("password"), isActive));
                    } catch (Exception ex) {
                        Logger.getLogger(login_servlet_library.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    response = "member_login_success";
                }else if(isActive == 0){
                    response = "membership_inactive";
                }
            }else{
                response = "invalid_credentials";
            }
        } catch (SQLException ex) {
            Logger.getLogger(login_servlet_library.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response = new Gson().toJson(response);
        resp.getWriter().println(response);
    }
}
