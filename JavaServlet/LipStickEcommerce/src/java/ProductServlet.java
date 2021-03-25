/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */

import com.model.Product;
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

// Produkt Servlet
@WebServlet(urlPatterns = {"/product_servlet"})
public class ProductServlet extends HttpServlet {
    
    // Produktmodell, das die Daten aus der Datenbank abruft
    Product productModel = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        this.productModel = new Product();
        
        // Abrufen der Daten aus dem Servlet unter gleichzeitiger Bearbeitung der Filteranforderung
        ArrayList<com.pojo.Product> productArrayList = null;
        
        try {
            if(req.getParameter("skin_type_filter") != null){
                String skin_type = req.getParameter("skin_type_filter");
                productArrayList = this.productModel.GetAllProductsFilterSkinType(skin_type);
            }else if(req.getParameter("type") != null){
                String type = req.getParameter("type");
                productArrayList = this.productModel.GetAllProductsFilterType(type);
            }else if(req.getParameter("color_type") != null){
                String color_type = req.getParameter("color_type");
                productArrayList = this.productModel.GetAllProductsFilterColorType(color_type);
            }else{
                productArrayList = this.productModel.GetAllProducts();
            }
            link = "products.jsp";
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Einstellen der Daten in der Sitzung
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("product_list", productArrayList);
        
        resp.sendRedirect(link);
    }
    
}
