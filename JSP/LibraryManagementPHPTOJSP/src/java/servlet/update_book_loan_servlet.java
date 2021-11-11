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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "update_book_loan_servlet", urlPatterns = {"/update_book_loan_servlet"})
public class update_book_loan_servlet extends HttpServlet {
    
    private Connection connection = null;
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            int bookId = Integer.parseInt(req.getParameter("bookId"));
            int transactionId = Integer.parseInt(req.getParameter("transaction_id"));
            
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.now();
            String dateTime = dateTimeFormatter.format(localDateTime);
            
            this.connection = Connector.getConnectionInstance().getConnection();
            
            String query1 = "UPDATE books SET is_issued = 0 WHERE book_id = ?";
            PreparedStatement pstmt = this.connection.prepareStatement(query1);
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
            
            String query2 = "UPDATE loaned_books SET date_of_return = ? WHERE transaction_id = ?";
            pstmt = this.connection.prepareStatement(query2);
            pstmt.setString(1, dateTime);
            pstmt.setInt(2, transactionId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(update_book_loan_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("borrow_servlet");
    }
    
}
