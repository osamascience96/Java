/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.model.Cart;
import com.pojo.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/cart_servlet"})
public class CartServlet extends HttpServlet {
    
    // Das Cartmodel-Objekt, das die Methoden aufruft, mit denen die Daten aus der Datenbank abgerufen werden
    private Cart cartModel = null;
    
    // Die Get-Methode, die die Benutzerdaten abruft 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.cartModel = new Cart();
        
        String link = "";
        String redir = req.getParameter("redir");
        
        // Überprüfen Sie, ob userObj gesetzt ist
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("userObj");
        
        if(user == null){
            link = "login.jsp";
        }else if(redir == null){
            if(httpSession.getAttribute("userObj") != null){
                int user_id = user.GetId();
                int product_id = Integer.parseInt(req.getParameter("product_id"));

                com.pojo.Cart cart = new com.pojo.Cart();
                cart.SetUserId(user_id);
                cart.SetProductId(product_id);

                try {
                    this.cartModel.InsertCart(cart);
                } catch (SQLException ex) {
                    Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                link = "products.jsp?response=cart_added";
            }else{
                link = "login.jsp?response=cart_login";
            }
        }else{
            int user_id = user.GetId();
            ArrayList<com.pojo.Cart> arrayCartList = null;
            
            try {
                arrayCartList = this.cartModel.GetAllCartProducts(user_id);
            } catch (SQLException ex) {
                Logger.getLogger(WishListServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            httpSession.setAttribute("cart_array_list", arrayCartList);
            link = "cart.jsp";
        }
        
        resp.sendRedirect(link);
    }
    
}
