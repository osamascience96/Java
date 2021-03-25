/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pojo.Cart;
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
        
        String name = req.getParameter("name");
        ArrayList<Cart> cartArrayList = null;
        
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("cart_list") != null){
            cartArrayList = (ArrayList<Cart>) httpSession.getAttribute("cart_list");
        }else{
            cartArrayList = new ArrayList<Cart>();
            httpSession.setAttribute("cart_list", cartArrayList);
        }
        
        // check if the size of the list is 0
        if(cartArrayList.size() != 0){
            // take the stream of this current collection and if you found any match , then 
           if(cartArrayList.stream().anyMatch(obj -> obj.GetName().equals(name))){
               for(int i=0; i < cartArrayList.size(); i++){
                   if(cartArrayList.get(i).GetName().compareTo(name) == 0){
                       int currentCount = cartArrayList.get(i).GetCount();
                       cartArrayList.get(i).SetCount(++currentCount);
                   }
               }
           }else{
               cartArrayList.add(new Cart(name, 1));
           }
        }else{
            cartArrayList.add(new Cart(name, 1));
        }
        
        resp.sendRedirect("index.jsp");
    }
    
}
