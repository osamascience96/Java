/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AddCart", urlPatterns = {"/add_cart"})
public class AddCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession httpSession = req.getSession();
        
        ArrayList<Bean.Product> productCartArrayList = (ArrayList<Bean.Product>) httpSession.getAttribute("productCartArrayList");
        if(productCartArrayList != null){
            productCartArrayList.add((Bean.Product) httpSession.getAttribute("product"));
            // set the session to updatedlist
            httpSession.setAttribute("productCartArrayList", productCartArrayList);
        }else{
            productCartArrayList = new ArrayList<Bean.Product>();
            // check if any product is selected
            productCartArrayList.add((Bean.Product) httpSession.getAttribute("product"));
            // set the session 
            httpSession.setAttribute("productCartArrayList", productCartArrayList);
        }
        
        String response = new Gson().toJson(productCartArrayList);
        resp.getWriter().println(response);
    }
    
}
