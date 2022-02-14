/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileHandling {
    public static Object GetUserJson(String defaultPath){
        Object object = null;
        JSONParser jsonParser = new JSONParser();
        
        File file = new File(defaultPath);
        String path = file.getAbsolutePath().concat("/main/userlog.json");
        
        try {
            FileReader reader = new FileReader(path);
            object = jsonParser.parse(reader);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileHandling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileHandling.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FileHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return object;
    }
}
