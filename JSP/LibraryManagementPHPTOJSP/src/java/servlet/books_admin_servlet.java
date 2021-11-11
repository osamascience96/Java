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
import java.math.BigInteger;
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
@WebServlet(name = "books_admin_servlet", urlPatterns = {"/books_admin_servlet"})
public class books_admin_servlet extends HttpServlet {
    
    private Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        this.connection = Connector.getConnectionInstance().getConnection();
        
        HttpSession httpSession = req.getSession();
        
        if(httpSession.getAttribute("admin") != null){
            String query = "SELECT books.book_id, books.book, \n" +
"                                                        books.author,books.category_id, \n" +
"                                                        books.ISBN, books.is_issued, categories.category \n" +
"                                                        FROM books LEFT JOIN categories on \n" +
"                                                        books.category_id=categories.category_id";
            
            try {
                ArrayList<Book> booksArrayList = new ArrayList<Book>();
                
                PreparedStatement pstmt = this.connection.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();
                
                while(rs.next()){
                    booksArrayList.add(new Book(rs.getInt("book_id"), new Category(rs.getInt("category_id"), rs.getString("category")), rs.getString("book"), rs.getString("author"), rs.getBigDecimal("ISBN"), rs.getInt("is_issued")));
                }
                
                httpSession.setAttribute("booksadminlist", booksArrayList);
                
                query = "SELECT * FROM categories";
                
                ArrayList<Category> categoryArrayList = new ArrayList<Category>();
                pstmt = this.connection.prepareStatement(query);
                rs = pstmt.executeQuery();
                
                while(rs.next()){
                    categoryArrayList.add(new Category(rs.getInt("category_id"), rs.getString("category")));
                }
                
                httpSession.setAttribute("categorieslist", categoryArrayList);
                
                link = "books.jsp";
            } catch (SQLException ex) {
                Logger.getLogger(books_admin_servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            link = "index.jsp";
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String bookName = req.getParameter("inputBook");
            String bookAuthor = req.getParameter("inputAuthor");
            int categoryId = Integer.parseInt(req.getParameter("inputCategory"));
            String ISBN = req.getParameter("inputISBN");
            
            this.connection = Connector.getConnectionInstance().getConnection();
            
            String query = "INSERT INTO books(category_id, book, author, ISBN) VALUES(?, ?, ?, "+ISBN+")";
            
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, categoryId);
            pstmt.setString(2, bookName);
            pstmt.setString(3, bookAuthor);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(books_admin_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("books_admin_servlet");
    }
}
