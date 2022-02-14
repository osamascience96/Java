/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author osama
 */
public class JsonOps {
    public static JSONObject GetLoginCredentials(Object jsondata, String username, String password){
        
        JSONObject finalUserObj = null;
        
        JSONArray jSONArray = (JSONArray) jsondata;
        for(Object jsonObj: jSONArray){
            JSONObject userJsonObj = (JSONObject) jsonObj;
            // compare lowercase to get the username
            if(userJsonObj.get("username").toString().toLowerCase().compareTo(username.toLowerCase()) == 0){
                finalUserObj = userJsonObj;
                break;
            }
        }
        
        if(finalUserObj != null){
            // compare the password
            if(finalUserObj.get("password").toString().compareTo(password) == 0){
                finalUserObj.put("response", "login_success");
            }else{
                finalUserObj.put("response", "login_failed");
            }
        }
        
        return finalUserObj;
    }
}
