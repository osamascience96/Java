/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
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

/**
 *
 * @author osama
 */
@WebServlet(name = "Login", urlPatterns = {"/login_servlet"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "index.jsp";
        
        String email = req.getParameter("email_login");
        String password = req.getParameter("pass_login");
        
        Bean.User userObj = new Bean.User();
        userObj.setEmail(email);
        userObj.setPassword(password);
        
        User userModel = new User();
        Model.Car car = new Model.Car();
        
        try {
            userObj = userModel.GetUser(userObj);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(userObj != null){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("is_login", true);
            httpSession.setAttribute("UserObj", userObj);
            try {
                httpSession.setAttribute("carsList", car.GetCarArrayList());
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            link = link.concat("?response=login_success");
        }else{
            link = link.concat("?response=login_error");
        }
        
        resp.sendRedirect(link);
    }
    
}
