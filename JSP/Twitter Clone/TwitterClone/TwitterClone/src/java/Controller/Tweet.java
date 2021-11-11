/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "Tweet", urlPatterns = {"/tweet_controller"})
@MultipartConfig(maxFileSize = -1L)
public class Tweet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String link = "";
        
        int userId = Integer.parseInt(req.getParameter("userid"));
        String tweetPost = req.getParameter("twet_text");
        
        String tweetAction = req.getParameter("tweet_action");
        
        Model.Tweet tweetModel = new Model.Tweet();
        User userModel = new User();
        
        if(tweetAction.compareTo("add") == 0){
            Part part = req.getPart("media");
            
            InputStream is = part.getInputStream();
            
            Bean.Tweet tweet = new Bean.Tweet();
            tweet.setUser_id(userId);
            tweet.setTweet_text(tweetPost);
            tweet.setInputStream(is);
            
            try {
                tweetModel.InsertTweet(tweet);
            } catch (SQLException ex) {
                Logger.getLogger(Tweet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                ArrayList<Bean.Tweet> arrayListTweets = tweetModel.GetAllTweets(userId);
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("followuserlist", userModel.GetAllFollowedUsers(userId));
                httpSession.setAttribute("tweetList", arrayListTweets);
            } catch (SQLException ex) {
                Logger.getLogger(Tweet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            link = "tweet.jsp";
        }
        
        resp.sendRedirect(link);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model.Tweet tweetModel = new Model.Tweet();
        User userModel = new User();
        HttpSession httpSession = req.getSession();
        Bean.User userObj = (Bean.User) httpSession.getAttribute("userObj");
        
        try {
            ArrayList<Bean.Tweet> arrayListTweets = tweetModel.GetAllTweets(userObj.getId());
            if(req.getParameter("user_id_response") != null){
                int userId = Integer.parseInt(req.getParameter("user_id_response"));
                httpSession.setAttribute("followuserlist", userModel.GetAllFollowedUsers(userId));
            }
            httpSession.setAttribute("tweetList", arrayListTweets);
        } catch (SQLException ex) {
            Logger.getLogger(Tweet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        resp.sendRedirect("tweet.jsp");
    }
    
}
