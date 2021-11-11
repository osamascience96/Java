/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bean.Book;
import bean.Category;
import bean.LoanBook;
import bean.Member;
import bean.Personnel;
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
@WebServlet(name = "borrow_servlet", urlPatterns = {"/borrow_servlet"})
public class borrow_servlet extends HttpServlet {
    
    private Connection connection = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.connection = Connector.getConnectionInstance().getConnection();
        
        HttpSession httpSession = req.getSession();
        
        ArrayList<LoanBook> loanbookArrayList = new ArrayList<LoanBook>();
        ArrayList<Member> memberArrayList = new ArrayList<Member>();
        ArrayList<Book> booksArrayList = new ArrayList<Book>();
        
        String query = "SELECT loaned_books.transaction_id, loaned_books.book_id, loaned_books.personnel_id, loaned_books.member_id, loaned_books.date_of_issue, loaned_books.date_of_return, books.book, members.member_name, personnel.personnel_login FROM loaned_books LEFT JOIN members on loaned_books.member_id = members.member_id LEFT JOIN books on loaned_books.book_id = books.book_id LEFT JOIN personnel on loaned_books.personnel_id = personnel.personnel_id WHERE books.is_issued = 1 AND loaned_books.date_of_return IS null";
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Personnel personnel = new Personnel();
                personnel.setId(rs.getInt("personnel_id"));
                personnel.setPersonnel_login(rs.getString("personnel_login"));
                
                Member member = new Member();
                member.setId(rs.getInt("member_id"));
                try {
                    member.setMember_name(AES.Decrypt(rs.getString("member_name")));
                } catch (Exception ex) {
                    Logger.getLogger(borrow_servlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Book book = new Book();
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("book"));
                
                loanbookArrayList.add(new LoanBook(rs.getInt("transaction_id"), personnel, member, book, rs.getString("date_of_issue"), rs.getString("date_of_return")));
            }
            
            query = "SELECT * FROM members WHERE is_active = 1";
            pstmt = this.connection.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                memberArrayList.add(new Member(rs.getInt("member_id"), rs.getString("member_name"), rs.getString("username"), rs.getString("password"), rs.getInt("is_active")));
            }
            
            query = "SELECT books.book_id, books.book, \n" +
"                                                        books.author,books.category_id, \n" +
"                                                        books.ISBN, books.is_issued, categories.category \n" +
"                                                        FROM books LEFT JOIN categories on \n" +
"                                                        books.category_id=categories.category_id";
            
            pstmt = this.connection.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                booksArrayList.add(new Book(rs.getInt("book_id"), new Category(rs.getInt("category_id"), rs.getString("category")), rs.getString("book"), rs.getString("author"), rs.getBigDecimal("ISBN"), rs.getInt("is_issued")));
            }
            
            httpSession.setAttribute("borrow_admin_list", loanbookArrayList);
            httpSession.setAttribute("member_admin_active_list", memberArrayList);
            httpSession.setAttribute("booksadminlist", booksArrayList);
            
        } catch (SQLException ex) {
            Logger.getLogger(borrow_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("borrows.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int memberId = Integer.parseInt(req.getParameter("inputMemberID"));
        int bookId = Integer.parseInt(req.getParameter("inputBookID"));
        String datetimeString = req.getParameter("datetimeinput");
        
        this.connection = Connector.getConnectionInstance().getConnection();
        
        String query = "INSERT INTO loaned_books(book_id, personnel_id, member_id, date_of_issue) VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, 1);
            pstmt.setInt(3, memberId);
            pstmt.setString(4, datetimeString);
            pstmt.executeUpdate();
            
            query = "UPDATE books Set is_issued = 1 WHERE books.book_id = ?";
            pstmt = this.connection.prepareStatement(query);
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(borrow_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("borrow_servlet");
    }
    
}
