/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filehandling;

import com.models.User;
import java.io.File;
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
public class UserHandling {
    private String filename;
    
    public UserHandling(String filename){
        this.filename = filename;
    }
    
    public boolean WriteUserFile(User user){
        boolean data_written_flag = false;
        
        try {
            FileWriter fileWriter = new FileWriter(this.filename, true);
            fileWriter.append(user.GetFirstName().concat("\n"));
            fileWriter.append(user.GetLastName().concat("\n"));
            fileWriter.append(user.GetUserName().concat("\n"));
            fileWriter.append(user.GetPassword().concat("\n"));
            fileWriter.append("\n");
            fileWriter.close();
            data_written_flag = true;
        } catch (IOException ex) {
            Logger.getLogger(UserHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data_written_flag;
    }
    
    public boolean UserExists(User user){
        boolean flag = false;
        
        try {
            File readFile = new File(this.filename);
            Scanner scanner = new Scanner(readFile);
            while(scanner.hasNextLine()){
                if(scanner.nextLine().compareTo(user.GetUserName()) == 0){
                    flag = true;
                    scanner.close();
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return flag;
    }
    
    public boolean UserLoginValidation(User user){
        boolean user_validate = false;
        
        File readFile = new File(this.filename);
        
        try {
            Scanner scanner = new Scanner(readFile);
            while(scanner.hasNextLine()){
                if((scanner.nextLine().compareTo(user.GetUserName()) == 0) && (scanner.nextLine().compareTo(user.GetPassword()) == 0)){
                    user_validate = true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user_validate;
    }
    
    public String GetUserName(User user){    
        File readFile = new File(this.filename);
        String first_name = "";
        String last_name = "";
        try {
            Scanner scanner = new Scanner(readFile);
            while(scanner.hasNextLine()){
                first_name = scanner.nextLine();
                last_name = scanner.nextLine();
                String email = scanner.nextLine();
                if(email.compareTo(user.GetUserName()) == 0){
                    return first_name.concat(" ").concat(last_name);
                }else{
                    scanner.nextLine();
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserHandling.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }
}
