/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.file;

import com.pojo.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author osama
 */
public class Read {
    private File fileReadObj = null;
    
    public Read(String path){
        this.fileReadObj = new File(path);
    }
    
    public User CheckUserEsistance(String userId, String password) throws FileNotFoundException{
        User user = null;
        Scanner reader = new Scanner(this.fileReadObj);
        while(reader.hasNextLine()){
            String[] data = reader.nextLine().split(" ");
            if(userId.compareTo(data[0]) == 0 && password.compareTo(data[4]) == 0){
                user = new User(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                break;
            }
        }
        
        reader.close();
        
        return user;
    }
    
    public User CheckUserLogin(String user_id, String password) throws FileNotFoundException{
        User user = null;
        Scanner reader = new Scanner(this.fileReadObj);
        while(reader.hasNextLine()){
            String[] data = reader.nextLine().split(" ");
            if(user_id.compareTo(data[0]) == 0 && password.compareTo(data[4]) == 0){
                user = new User(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                break;
            }
        }
        reader.close();
        
        return user;
    }
}
