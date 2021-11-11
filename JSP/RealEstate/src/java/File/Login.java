/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Bean.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author osama
 */
public class Login {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private File file;
    
    public Login(String path){
        this.file = new File(path);
    }
    
    public User CheckLoginCredentials(User user){
        User userObj = null;
        
        JSONParser jsonParser = new JSONParser();
        try {
            this.fileReader = new FileReader(this.file);
            JSONArray jaonArray = (JSONArray) jsonParser.parse(fileReader);
            JSONObject jsonObject = null;
            for(int i=0; i < jaonArray.size(); i++){
                jsonObject = (JSONObject) jaonArray.get(i);
                
                int id = ((Long) jsonObject.get("id")).intValue();
                String name = (String) jsonObject.get("name");
                String email = (String) jsonObject.get("email");
                String username = (String) jsonObject.get("username");
                String password = (String) jsonObject.get("password");
                String type = (String) jsonObject.get("type");
                String created_at = (String) jsonObject.get("date");

                // check if the user already exists 
                if( (email.compareTo(user.getEmail()) == 0 || username.compareTo(user.getUsername()) == 0) && password.compareTo(user.getPassword()) == 0){
                    userObj = new User(id, name, username, email, password, type, created_at);
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userObj;
    }
}
