/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author osama
 */
public class Comment {
    private String username;
    private String comment;
    
    public Comment(){
    }
    
    public Comment(String username, String comment){
        this.username = username;
        this.comment = comment;
    }
    
    public void SetUsername(String username){
        this.username = username;
    }
    public String GetUsername(){
        return this.username;
    }
    
    public void SetComment(String comment){
        this.comment = comment;
    }
    public String GetComment(){
        return this.comment;
    }
}
