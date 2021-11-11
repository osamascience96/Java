/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author osama
 */
@WebServlet(name = "Car", urlPatterns = {"/car_servlet"})
@MultipartConfig(maxFileSize = -1L)
public class Car extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "index.jsp";
        
        String action = req.getParameter("action");
        
        String manufacturer = req.getParameter("manufacturer");
        String model = req.getParameter("model");
        String type = req.getParameter("type");
        int yearOfManufacturer = Integer.parseInt(req.getParameter("year_of_manufacturer"));
        int milesDriven = Integer.parseInt(req.getParameter("miles"));
        float price = Float.parseFloat(req.getParameter("price"));
        String hasAC = req.getParameter("hasAC");
        String hasDVD = req.getParameter("hasDVD");
        String comments = req.getParameter("comments");
        Part part = req.getPart("upload");
        
        HttpSession httpSession = req.getSession();
        
        User userObj = (User) httpSession.getAttribute("UserObj");
        
        Model.Car carModel = new Model.Car();
        
        if(action.compareTo("add") == 0){
            InputStream inputStream = part.getInputStream();
            
            Bean.Car car = new Bean.Car();
            car.setManufacturer(manufacturer);
            car.setUser(userObj);
            car.setModel(model);
            car.setType(type);
            car.setYear_of_manufacturer(yearOfManufacturer);
            car.setMiles(milesDriven);
            car.setPrice(price);
            car.setHasAC(hasAC.charAt(0));
            car.setHasDVD(hasDVD.charAt(0));
            car.setComments(comments);
            car.setInputStream(inputStream);
            
            try {
                carModel.InsertCartoSaleDB(car);
                httpSession.setAttribute("carsList", carModel.GetCarArrayList());
            } catch (SQLException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            link = link.concat("?response=caradded_success");
        }
        
        resp.sendRedirect(link);
    }
    
}
