/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.file;

import com.pojo.User;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Write {
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private PrintWriter pw = null;
    
    public Write(String path){
        try {
            this.fw = new FileWriter(path, true);
        } catch (IOException ex) {
            Logger.getLogger(Write.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.bw = new BufferedWriter(this.fw);
        this.pw = new PrintWriter(this.bw);
    }
    
    public void Register(User user){
        this.pw.println(user.GetUserId().concat(" ").concat(user.GetFirstName()).concat(" ").concat(user.GetLastName()).concat(" ").concat(user.GetEmail()).concat(" ").concat(user.GetPassword()).concat(" ").concat(user.GetMobile()).concat(" ").concat(user.GetRole()));
        try {
            this.pw.close();
            this.bw.close();
            this.fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Write.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
