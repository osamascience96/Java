/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */

import com.model.Product;
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
import javax.servlet.http.HttpSession;

// Produkt-Servlet erstellen, das die Daten des einzelnen Produkts abruft, das vom Benutzer zum Auschecken oder für andere Zwecke ausgewählt wurde.
@WebServlet(urlPatterns = {"/product_user_servlet"})
public class ProductUserServlet extends HttpServlet {

    // Methode des Produktservlets abrufen
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("product_template_id"));
        
        Product productModel = new Product();
        
        HttpSession httpSession = req.getSession();
        try {
            httpSession.setAttribute("product_data", productModel.GetProduct(id));
        } catch (SQLException ex) {
            Logger.getLogger(ProductUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect("productTemplate.jsp");
    }
    
}
