/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import database.Connector;
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
@WebServlet(name = "member_loan_servlet", urlPatterns = {"/member_loan_servlet"})
public class member_loan_servlet extends HttpServlet {
    
    private Connection connection = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String response = "";
        
        this.connection = Connector.getConnectionInstance().getConnection();
        
        int bookId = Integer.parseInt(req.getParameter("book_id"));
        int personnelId = Integer.parseInt(req.getParameter("personnel_id"));
        int memberId = Integer.parseInt(req.getParameter("member_id"));
        String datetime = req.getParameter("date_time");
        
        String query = "INSERT INTO loaned_books(book_id, personnel_id, member_id, date_of_issue) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, personnelId);
            pstmt.setInt(3, memberId);
            pstmt.setString(4, datetime);
            int rowCount = pstmt.executeUpdate();
            
            HttpSession httpSession = req.getSession();
            
            if(httpSession.getAttribute("admin") != null){
                // set for the admin interface
            }else{
                if(rowCount > 0){
                    query = "UPDATE books SET is_issued = 1 WHERE book_id = ?";
                    pstmt = this.connection.prepareStatement(query);
                    pstmt.setInt(1, bookId);
                    pstmt.executeUpdate();
                    
                    response = "member_loan_success";
                }else{
                    response = "member_loan_failed";
                }
            }
            
            response = new Gson().toJson(response);
            resp.getWriter().println(response);
        } catch (SQLException ex) {
            Logger.getLogger(member_loan_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
