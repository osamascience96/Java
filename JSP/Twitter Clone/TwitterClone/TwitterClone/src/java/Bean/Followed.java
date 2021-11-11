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
public class Followed {
    private int id;
    private int user_id;
    private int followed_userid;
    
    public Followed(){
    }
    
    public Followed(int id, int user_id, int followed_userid){
        this.id = id;
        this.user_id = user_id;
        this.followed_userid = followed_userid;
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

    public int getFollowed_userid() {
        return followed_userid;
    }

    public void setFollowed_userid(int followed_userid) {
        this.followed_userid = followed_userid;
    }
    
    
}
