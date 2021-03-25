/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        ArrayList<String> urlList = null;
        
        if(httpSession.getAttribute("session_list") != null){
            urlList = (ArrayList<String>) httpSession.getAttribute("session_list");
        }else{
            urlList = new ArrayList<String>();
            httpSession.setAttribute("session_list", urlList);
        }
        
        String url = req.getHeader("referer");
        
        if(!urlList.contains(url)){
            urlList.add(url);
        }
        
        resp.sendRedirect(url);
    }
    
}
