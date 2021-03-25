/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */

import com.model.WishList;
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

@WebServlet(urlPatterns = {"/wish_servlet"})
public class WishListServlet extends HttpServlet {
    
    private WishList wishListModel = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.wishListModel = new WishList();
        
        String link = "";
        // Überprüfen Sie, ob userObj gesetzt ist
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("userObj");
        
        // Einstellen der Weiterleitung des Benutzers 
        String redir = req.getParameter("redir");
        
        if(user == null){
            link = "login.jsp";
        }else if(redir == null){
            // Legen Sie das Wunschliste-Produkt ein
            if(httpSession.getAttribute("userObj") != null){
                int user_id = user.GetId();
                int product_id = Integer.parseInt(req.getParameter("product_id"));

                com.pojo.WishList wishList = new com.pojo.WishList();
                wishList.SetUserId(user_id);
                wishList.SetProductId(product_id);

                try {
                    this.wishListModel.InsertWishList(wishList);
                } catch (SQLException ex) {
                    Logger.getLogger(WishListServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                link = "products.jsp?response=wish_list_added";
            }else{
                link = "login.jsp?response=wish_list_login";
            }
        }else{
            // Holen Sie sich alle Wunschliste Produkte
            int user_id = user.GetId();
            ArrayList<com.pojo.WishList> arrayWishList = null;
            
            try {
                arrayWishList = this.wishListModel.GetAllWishProducts(user_id);
            } catch (SQLException ex) {
                Logger.getLogger(WishListServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            httpSession.setAttribute("wish_array_list", arrayWishList);
            link = "wishlist.jsp";
        }
        
        resp.sendRedirect(link);
    }
    
}
