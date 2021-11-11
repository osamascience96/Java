/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Book;
import bean.Category;
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
@WebServlet(name = "member_servlet", urlPatterns = {"/member_servlet"})
public class member_servlet extends HttpServlet {
    
    private Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.connection = Connector.getConnectionInstance().getConnection();
        
        ArrayList<Book> booksArrayList = new ArrayList<Book>();
        
        HttpSession httpSession = req.getSession();
        
        String query = "SELECT books.book_id, books.book, \n" +
"                                                        books.author,books.category_id, \n" +
"                                                        books.ISBN, books.is_issued, categories.category \n" +
"                                                        FROM books LEFT JOIN categories on \n" +
"                                                        books.category_id=categories.category_id";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                    booksArrayList.add(new Book(rs.getInt("book_id"), new Category(rs.getInt("category_id"), rs.getString("category")), rs.getString("book"), rs.getString("author"), rs.getBigDecimal("ISBN"), rs.getInt("is_issued")));
                httpSession.setAttribute("bookArrayList", booksArrayList);
            }
            
            resp.sendRedirect("member.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(member_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
