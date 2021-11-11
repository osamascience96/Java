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
        String link = "";
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        Bean.User userObj = new Bean.User();
        userObj.setUsername(username);
        userObj.setPassword(password);
        
        User user = new User();
        Model.Tweet tweet = new Model.Tweet();
        
        try {
            userObj = user.CheckUser(userObj);
            if(userObj != null){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("userObj", userObj);
                httpSession.setAttribute("userlist", user.GetAllUserList());
                httpSession.setAttribute("is_login", true);
                httpSession.setAttribute("followuserlist", user.GetAllFollowedUsers(userObj.getId()));
                httpSession.setAttribute("tweetList", tweet.GetAllTweets(userObj.getId()));
                link = "tweet.jsp";
            }else{
                link = "index.jsp?response=wrong_credentials";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        resp.sendRedirect(link);
    }
    
}
