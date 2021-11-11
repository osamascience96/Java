/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.Followed;
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

/**
 *
 * @author osama
 */
@WebServlet(name = "Follow", urlPatterns = {"/follow_servlet"})
public class Follow extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        int follow_userId = Integer.parseInt(req.getParameter("followuserid"));
        
        User userModel = new User();
        
        // follow the user 
        if(req.getSession().getAttribute("is_login") != null){
            Followed followed = new Followed();
            followed.setUser_id(userId);
            followed.setFollowed_userid(follow_userId);
            
            try {
                userModel.followuser(followed);
            } catch (SQLException ex) {
                Logger.getLogger(Follow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
