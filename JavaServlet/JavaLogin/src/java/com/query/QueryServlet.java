/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.query;

import com.filehandling.QueryHandling;
import com.models.Query;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osama
 */
@WebServlet(name = "QueryServlet", urlPatterns = {"/queryservlet"})
public class QueryServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String queryMessage = req.getParameter("message");
        
        QueryHandling queryHandling = new QueryHandling(req.getServletContext().getRealPath("/").concat("WEB-INF\\classes\\com\\filehandling\\queries.txt"));
        boolean response = queryHandling.WriteQuery(new Query(name, email, queryMessage));
        
        resp.sendRedirect("contactus.jsp?response=".concat(String.valueOf(response)));
    }
}
