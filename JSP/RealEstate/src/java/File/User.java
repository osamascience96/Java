/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import Bean.Product;
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
public class User {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private File file;
    
    public User(String path){
        this.file = new File(path);
    }
    
    public ArrayList<Product> GetAllProperties(){
        ArrayList<Product> arrayListProduct = new ArrayList<Product>();
        
        if(this.file.length() != 0){
            JSONParser jsonParser = new JSONParser();
            try {
                this.fileReader = new FileReader(this.file);
                JSONArray jsonArray = (JSONArray) jsonParser.parse(this.fileReader);
                JSONObject jsonObject = null;
                for(int i=0; i < jsonArray.size(); i++){
                    jsonObject = (JSONObject) jsonArray.get(i); 
                    arrayListProduct.add(new Product(((Long) jsonObject.get("id")).intValue(), ((Long) jsonObject.get("userid")).intValue(), (String) jsonObject.get("name"), (String) jsonObject.get("location"), (String) jsonObject.get("date"), (double)jsonObject.get("price")));
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return arrayListProduct;
    }
}
