/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class Tweet {
    public Connection connection;
    
    public Tweet(){
        this.connection = Connector.getConnectionInstance().getConnection();
    }
    
    public void InsertTweet(Bean.Tweet tweet) throws SQLException, IOException{
        // check if the image is set 
        if(tweet.getInputStream()!= null){
            String query = "INSERT INTO tweet(user_id, tweet_text, image) VALUES (?, ?, ?)";
            
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, tweet.getUser_id());
            ps.setString(2, tweet.getTweet_text());
            ps.setBlob(3, tweet.getInputStream());
            
            ps.executeUpdate();
        }else{
            String query = "INSERT INTO tweet(user_id, tweet_text) VALUES (?, ?)";
            
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, tweet.getUser_id());
            ps.setString(2, tweet.getTweet_text());
            
            ps.executeUpdate();
        }
    }
    
    public ArrayList<Bean.Tweet> GetAllTweets(int userid) throws SQLException{
        String query = "SELECT tweet.*, user.username, user.email, user.password FROM tweet LEFT JOIN user ON user.id = tweet.user_id WHERE user.id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, userid);
        ResultSet rs = pstmt.executeQuery();
        
        ArrayList<Bean.Tweet> arrayListTweets = new ArrayList<Bean.Tweet>();
        
        while(rs.next()){
            Bean.Tweet tweet = new Bean.Tweet();
            tweet.setId(rs.getInt("id"));
            tweet.setUser_id(rs.getInt("user_id"));
            tweet.setTweet_text(rs.getString("tweet_text"));
            tweet.setLikes_count(rs.getInt("likes_count"));
            tweet.setUnlikes_count(rs.getInt("unlikes_count"));
            tweet.setImage(rs.getBlob("image"));
            
            Bean.User userObj = new Bean.User();
            userObj.setUsername(rs.getString("username"));
            userObj.setEmail(rs.getString("email"));
            userObj.setPassword(rs.getString("password"));
            
            tweet.setUserObj(userObj);
            
            arrayListTweets.add(tweet);
        }
        
        query = "SELECT tweet.*, user.username, user.email, user.password FROM tweet LEFT JOIN user ON user.id = tweet.user_id JOIN followed ON followed.followed_userid = tweet.user_id WHERE followed.user_id = ?";
        pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, userid);
        
        rs = pstmt.executeQuery();
        
        while(rs.next()){
            Bean.Tweet tweet = new Bean.Tweet();
            tweet.setId(rs.getInt("id"));
            tweet.setUser_id(rs.getInt("user_id"));
            tweet.setTweet_text(rs.getString("tweet_text"));
            tweet.setLikes_count(rs.getInt("likes_count"));
            tweet.setUnlikes_count(rs.getInt("unlikes_count"));
            tweet.setImage(rs.getBlob("image"));
            
            Bean.User userObj = new Bean.User();
            userObj.setUsername(rs.getString("username"));
            userObj.setEmail(rs.getString("email"));
            userObj.setPassword(rs.getString("password"));
            
            tweet.setUserObj(userObj);
            
            arrayListTweets.add(tweet);
        }
        
        return arrayListTweets;
    } 
    
    public Bean.Tweet GetTweetRecord(int tweetid) throws SQLException{
        Bean.Tweet tweet = null;
        
        String query = "SELECT * FROM tweet WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, tweetid);
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            tweet = new Bean.Tweet();
            tweet.setId(rs.getInt("id"));
            tweet.setUser_id(rs.getInt("user_id"));
            tweet.setTweet_text(rs.getString("tweet_text"));
            tweet.setLikes_count(rs.getInt("likes_count"));
            tweet.setUnlikes_count(rs.getInt("unlikes_count"));
            tweet.setImage(rs.getBlob("image"));
        }
        
        return tweet;
    }
    
    public void SetLikesUpdateIncrement(int tweet_id) throws SQLException{
        String query = "UPDATE tweet SET likes_count = likes_count + 1 WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, tweet_id);
        pstmt.executeUpdate();
        
        // dislike decrement
        this.SetDislikesUpdateDecrement(tweet_id);
    }
    
    public void SetLikesUpdateDecrement(int tweet_id) throws SQLException{
        String query = "UPDATE tweet SET likes_count = likes_count - 1 WHERE id = ? AND likes_count != 0";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, tweet_id);
        pstmt.executeUpdate();
    }
    
    public void SetDislikesUpdateIncrement(int tweet_id) throws SQLException{
        String query = "UPDATE tweet SET unlikes_count = unlikes_count + 1 WHERE id = ?";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, tweet_id);
        pstmt.executeUpdate();
        
        this.SetLikesUpdateDecrement(tweet_id);
    }
    
    public void SetDislikesUpdateDecrement(int tweet_id) throws SQLException{
        String query = "UPDATE tweet SET unlikes_count = unlikes_count - 1 WHERE id = ? AND unlikes_count != 0";
        
        PreparedStatement pstmt = this.connection.prepareStatement(query);
        pstmt.setInt(1, tweet_id);
        pstmt.executeUpdate();
    }
    
    
}
