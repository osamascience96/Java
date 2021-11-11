/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class File {

    private java.io.File fileObj = null;
    
    public File(String filename) {
        this.fileObj = new java.io.File(filename);
    }
    
    public boolean createFile(){
        if(!this.fileObj.exists()){
            try {
                this.fileObj.createNewFile();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        
        return true;
    }
    
    public boolean WritetoFile(String formattedString){
        try {
            FileWriter fileWriter = new FileWriter(fileObj);
            fileWriter.write(formattedString);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    public String ReadFile(){
        try {
            Scanner scanner = new Scanner(this.fileObj);
            while(scanner.hasNextLine()){
                String data = scanner.nextLine();
                return data;
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public java.io.File GetFile(){
        return this.fileObj;
    }
}
