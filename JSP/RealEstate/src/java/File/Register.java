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
public class Register {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private File file;
    
    public Register(String path){
        this.file = new File(path);
    }
    
    public String InsertData(User user){
        String message = "";
        
        if(this.file.length() != 0){
            JSONParser jsonParser = new JSONParser();
            try {
                this.fileReader = new FileReader(this.file);
                JSONArray jsonArray = (JSONArray) jsonParser.parse(this.fileReader);
                JSONObject jsonObject = null;
                for(int i=0; i < jsonArray.size(); i++){
                    jsonObject = (JSONObject) jsonArray.get(i);
                    String email = (String) jsonObject.get("email");
                    String username = (String) jsonObject.get("username");
                    
                    // check if the user already exists 
                    if(email.compareTo(user.getEmail()) == 0 || username.compareTo(user.getUsername()) == 0){
                        message = "already_exists";
                        break;
                    }
                }
                
                // check if the message is empty 
                if(message.isEmpty()){
                    jsonObject = new JSONObject();
                    int id = jsonArray.size() + 1;
                    jsonObject.put("id", id);
                    jsonObject.put("name", user.getName());
                    jsonObject.put("username", user.getUsername());
                    jsonObject.put("email", user.getEmail());
                    jsonObject.put("password", user.getPassword());
                    jsonObject.put("type", user.getType());
                    jsonObject.put("date", user.getDate());
                    jsonArray.add(jsonObject);
                    
                    try {
                        this.fileWriter = new FileWriter(this.file);
                        this.fileWriter.write(jsonArray.toJSONString());
                    } catch (IOException ex) {
                        Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(ex.getMessage());
                    } finally{
                        this.Close();
                    }
                    
                    message = "inserted_user";
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", 1);
            jsonObject.put("name", user.getName());
            jsonObject.put("username", user.getUsername());
            jsonObject.put("email", user.getEmail());
            jsonObject.put("password", user.getPassword());
            jsonObject.put("type", user.getType());
            jsonObject.put("date", user.getDate());
            jsonArray.add(jsonObject);
            
            
            try {
                this.fileWriter = new FileWriter(this.file);
                this.fileWriter.write(jsonArray.toJSONString());
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            } finally{
                this.Close();
            }
            
            message = "inserted_user";
        }
        
        return message;
    }
    
    
    
    private void Close(){
        try {
            this.fileWriter.flush();
            this.fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
