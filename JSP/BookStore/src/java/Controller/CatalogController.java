/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Beans.CatalogBean;
import Model.Catalog;
import java.io.IOException;
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
@WebServlet(name = "CatalogController", urlPatterns = {"/catalog_controller"})
public class CatalogController extends HttpServlet {

    private CatalogBean catalogBean = null;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("accessed_catalog", true);
        
        catalogBean = new CatalogBean();
        
        if(action == null || action.isEmpty()){
            ArrayList<Catalog> catalogArrayList = catalogBean.GetAllCatalog();
            httpSession.setAttribute("allcataloglist", catalogArrayList);
            resp.sendRedirect("/BookStore/");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("book_title");
        String author = req.getParameter("book_author");
        String price = req.getParameter("book_price");
        
        this.catalogBean = new CatalogBean();
        
        HttpSession httpSession = req.getSession();
        
        
        if(title != null && author != null && price != null){
            int is_inserted = catalogBean.InsertCatalog(new Catalog(title, author, Double.parseDouble(price)));
        }
        
        resp.sendRedirect("catalog_controller");
    }
    
}
