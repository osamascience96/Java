/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */

import com.model.Cart;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Checkout-Servlet, das die Reihenfolge des Benutzers überprüft

@WebServlet(urlPatterns = {"/chcekout_servlet"})
public class CheckoutServlet extends HttpServlet {
    
    // Abrufen der Daten aus dem Benutzermodell und dem Cartmodel
    private Cart cartModel = null;
    private User userModel = null;

    // Die get-Methode, die die Daten des Benutzers abruft
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        this.cartModel = new Cart();
        this.userModel = new User();
        
        int id = Integer.parseInt(req.getParameter("user_id"));
        
        // Erhalten der Menge des Warenkorbs, des Gesamtpreises der Bestellung und des Restbetrags des Benutzers
        int quantityofCartsOrder = 0;
        int total_price = 0;
        int user_balance = 0;
        
        try {
            quantityofCartsOrder = this.cartModel.GetQuantityOfCarts(id);
            total_price = this.cartModel.GetPriceofCarts(id);
            user_balance = this.userModel.GetUserBalance(id);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Überprüfen des Guthabens des Benutzers
        int remaining_balance = 0;
        
        if(user_balance > total_price){
            remaining_balance = user_balance - total_price;
            try {
                // update the balance
                this.userModel.UpdateUser(id, remaining_balance);
                this.cartModel.SetDeleteCarts(id);
                this.cartModel.InsertOrder(id, quantityofCartsOrder, total_price);
            } catch (SQLException ex) {
                Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            link = "index.jsp?response=checkout_success";
        }else{
            link = "index.jsp?response=balance_error";
        }
        
        resp.sendRedirect(link);
    }

}
