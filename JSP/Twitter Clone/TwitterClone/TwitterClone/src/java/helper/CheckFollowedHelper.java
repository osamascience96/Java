/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import Bean.Followed;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class CheckFollowedHelper {
    
    public static boolean CheckFollowedUserExists(ArrayList<Followed> followedList, int id){
        boolean is_exists = false;
        
        for(int i=0; i < followedList.size(); i++){
            if(id == followedList.get(i).getFollowed_userid()){
                is_exists = true;
                break;
            }
        }
        
        return is_exists;
    }
}
