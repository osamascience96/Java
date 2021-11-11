/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Bean.Product;
import Bean.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
public class Property {
    private FileWriter fileWriter;
    private FileReader fileReader;
    private File file;
    
    public Property(String pathname){
        this.file = new File(pathname);
    }
    
    public String InsertData(Product product){
        String message = "";
        
        if(this.file.length() != 0){
            JSONParser jsonParser = new JSONParser();
            try {
                this.fileReader = new FileReader(this.file);
                JSONArray jsonArray = (JSONArray) jsonParser.parse(this.fileReader);
                JSONObject jsonObject = new JSONObject();
                
                int id = jsonArray.size() + 1;
                jsonObject.put("id", id);
                jsonObject.put("userid", product.getUserId());
                jsonObject.put("name", product.getPropertyName());
                jsonObject.put("price", product.getPrice());
                jsonObject.put("location", product.getLocation());
                jsonObject.put("date", product.getDate());
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

                message = "inserted_property";
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
            jsonObject.put("userid", product.getUserId());
            jsonObject.put("name", product.getPropertyName());
            jsonObject.put("price", product.getPrice());
            jsonObject.put("location", product.getLocation());
            jsonObject.put("date", product.getDate());
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
            
            message = "inserted_property";
        }
        
        return message;
    }
    
    public ArrayList<Product> GetUserProperty(int userid){
        ArrayList<Product> arrayListProperty = new ArrayList<Product>();
        if(this.file.length() != 0 ){
            JSONParser jsonParser = new JSONParser();
            try {
                this.fileReader = new FileReader(this.file);
                JSONArray jsonArray = (JSONArray) jsonParser.parse(this.fileReader);
                JSONObject jsonObject = null;

                // loop through the jsonArray
                for(int i=0; i < jsonArray.size(); i++){
                    jsonObject = (JSONObject) jsonArray.get(i);
                    if(userid == ((Long) jsonObject.get("userid")).intValue()){
                        arrayListProperty.add(new Product(((Long) jsonObject.get("id")).intValue(), ((Long) jsonObject.get("userid")).intValue(), (String) jsonObject.get("name"), (String) jsonObject.get("location"), (String) jsonObject.get("date"), (double)jsonObject.get("price")));
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return arrayListProperty;
    }
    
    public void DeleteProperty(int id){
        if(this.file.length() != 0){
            JSONParser jSONParser = new JSONParser();
            try {
                this.fileReader = new FileReader(this.file);
                JSONArray jsonArray = (JSONArray) jSONParser.parse(this.fileReader);
                // remove the jsonobject index - 1
                jsonArray.remove(id - 1);
                
                this.fileWriter = new FileWriter(this.file);
                this.fileWriter.write(jsonArray.toJSONString());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Property.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                this.Close();
            }
        }
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
