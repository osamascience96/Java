/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class Tweet {
    private int id;
    private int user_id;
    private String tweet_text;
    private int likes_count;
    private int unlikes_count;
    private Blob image;
    private InputStream inputStream;
    private ArrayList<Comment> arrayListComments;
    private User userObj;
    
    public Tweet(){
    }
    
    public Tweet(int id, int user_id, int likes_count, int unlikes_count, Blob image, ArrayList<Comment> arrayListComments){
        this.id = id;
        this.user_id = user_id;
        this.likes_count = likes_count;
        this.unlikes_count = unlikes_count;
        this.image = image;
        this.arrayListComments = arrayListComments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getUnlikes_count() {
        return unlikes_count;
    }

    public void setUnlikes_count(int unlikes_count) {
        this.unlikes_count = unlikes_count;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public ArrayList<Comment> getArrayListComments() {
        return arrayListComments;
    }

    public void setArrayListComments(ArrayList<Comment> arrayListComments) {
        this.arrayListComments = arrayListComments;
    }

    public String getTweet_text() {
        return tweet_text;
    }

    public void setTweet_text(String tweet_text) {
        this.tweet_text = tweet_text;
    }   

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public User getUserObj() {
        return userObj;
    }

    public void setUserObj(User userObj) {
        this.userObj = userObj;
    }
}
