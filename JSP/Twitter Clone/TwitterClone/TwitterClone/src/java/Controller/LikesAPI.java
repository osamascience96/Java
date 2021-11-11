/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.google.gson.Gson;
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
@WebServlet(name = "LikesAPI", urlPatterns = {"/likes_api"})
public class LikesAPI extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // set the parameters to update the like from the databasae
        int tweet_id = Integer.parseInt(req.getParameter("tweet_id"));
        String ratio_type = req.getParameter("ratio_type");
        
        Model.Tweet tweetModel = new Model.Tweet();
        
        if(ratio_type.compareTo("increment") == 0){
            try {
                tweetModel.SetLikesUpdateIncrement(tweet_id);
            } catch (SQLException ex) {
                Logger.getLogger(LikesAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            try {
                tweetModel.SetLikesUpdateDecrement(tweet_id);
            } catch (SQLException ex) {
                Logger.getLogger(LikesAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Bean.Tweet tweet = null;
        
        try {
            tweet = tweetModel.GetTweetRecord(tweet_id);
        } catch (SQLException ex) {
            Logger.getLogger(LikesAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String userjson = new Gson().toJson(tweet);
        resp.getWriter().println(userjson);
    }
    
}
