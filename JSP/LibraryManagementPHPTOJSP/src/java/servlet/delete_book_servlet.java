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
@WebServlet(name = "delete_book_servlet", urlPatterns = {"/delete_book_servlet"})
public class delete_book_servlet extends HttpServlet {
    
    private Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int bookId = Integer.parseInt(req.getParameter("book_id"));
            
            this.connection = Connector.getConnectionInstance().getConnection();
            
            
            String query = "DELETE FROM books WHERE book_id = ?";
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(delete_book_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("books_admin_servlet");
    }
    
}
