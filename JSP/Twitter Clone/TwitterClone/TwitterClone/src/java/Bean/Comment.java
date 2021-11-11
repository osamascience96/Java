/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author osama
 */
public class Comment {
    private int id;
    private int user_id;
    private String comment_text;
    
    public Comment(){
    }
    
    public Comment(int id, int user_id, String comment_text){
        this.id = id;
        this.user_id = user_id;
        this.comment_text = comment_text;
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

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }
    
    
}
