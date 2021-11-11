/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "logout_servlet_library", urlPatterns = {"/logout_servlet_library"})
public class logout_servlet_library extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.removeAttribute("admin");
        httpSession.removeAttribute("member");
        httpSession.removeAttribute("booksadminlist");
        httpSession.removeAttribute("categorieslist");
        httpSession.removeAttribute("member_admin_list");
        httpSession.removeAttribute("borrow_admin_list");
        httpSession.removeAttribute("member_admin_active_list");
        httpSession.invalidate();
        resp.sendRedirect("index.jsp");
    }
    
}
