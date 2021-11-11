/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.User;
import com.google.gson.Gson;
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

/**
 *
 * @author osama
 */
@WebServlet(name = "GetAllTweetsAPI", urlPatterns = {"/getalltweets_servlet"})
public class GetAllTweetsAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model.Tweet tweetModel = new Model.Tweet();
        
        ArrayList<Bean.Tweet> arrayListTweets = null;
        
        User userObj = (User) req.getSession().getAttribute("userObj");
        
        if(userObj != null){
            try {
                arrayListTweets = tweetModel.GetAllTweets(userObj.getId());
            } catch (SQLException ex) {
                Logger.getLogger(GetAllTweetsAPI.class.getName()).log(Level.SEVERE, null, ex);
            }

            String tweetsArrayList = new Gson().toJson(arrayListTweets);

            resp.getWriter().println(tweetsArrayList);
        }else{
            resp.getWriter().println("Session Outdated");
        }
    }
    
}
