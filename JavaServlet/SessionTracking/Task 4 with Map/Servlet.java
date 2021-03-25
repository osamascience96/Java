/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
        
        String name = req.getParameter("name");
        Map<String, Integer> mapCartList = null;
        
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("cart_list") != null){
            mapCartList = (Map<String, Integer>)httpSession.getAttribute("cart_list");
        }else{
            mapCartList = new HashMap<String, Integer>();
            httpSession.setAttribute("cart_list", mapCartList);
        }
        
        // check if the size of the list is 0
        if(mapCartList.size() != 0){
            // take the stream of this current collection and if you found any match , then 
           if(mapCartList.containsKey(name)){
               // getting the currentCount 
               int currentCount = mapCartList.get(name);
               // update the currentCount of the value
               mapCartList.put(name, ++currentCount);
           }else{
               mapCartList.put(name, new Integer(1));
           }
        }else{
            mapCartList.put(name, new Integer(1));
        }
        
        resp.sendRedirect("index.jsp");
    }
    
}
