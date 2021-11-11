/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Book;
import bean.Member;
import database.Connector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "admin_servlet", urlPatterns = {"/admin_servlet"})
public class admin_servlet extends HttpServlet {
    
    private Connection connection = null;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        
        if(httpSession.getAttribute("admin") != null){
            this.connection = Connector.getConnectionInstance().getConnection();
            // fetch the count of all the books, 
            try {
                String query1 = "SELECT count(*) from books";
                PreparedStatement pstmt = this.connection.prepareStatement(query1);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    req.setAttribute("bookcount", rs.getInt(1));
                }
                
                String query2 = "SELECT Count(*) FROM books WHERE is_issued = 1";
                pstmt = this.connection.prepareStatement(query2);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    req.setAttribute("booksloaned", rs.getInt(1));
                }
                
                String query3 = "SELECT Count(*) FROM members";
                pstmt = this.connection.prepareStatement(query3);
                rs = pstmt.executeQuery();
                if(rs.next()){
                    req.setAttribute("membercount", rs.getInt(1));
                }
                
                RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
                rd.forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(admin_servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            resp.sendRedirect("index.jsp");
        }
    }
}
