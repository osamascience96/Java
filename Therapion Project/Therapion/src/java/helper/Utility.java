/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class Utility {
    public static boolean IsStringEmptyorNull(String value){
        boolean flag = true;
        
        if(value != null){
            if(value.compareTo("") != 0){
                flag = false;
            }
        }
        
        return flag;
    }
    
    public static String GetAlert(String type, String title, String message){
        return "<div class=\"alert alert-"+type+" alert-dismissible fade show\" role=\"alert\">\n" +
                "  <strong>"+title+"</strong> "+message+"\n" +
                "  <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n" +
                "</div>";
    }
    
    public static String GetSHA256(String value){
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] bytesArr = messageDigest.digest(value.getBytes(StandardCharsets.UTF_8));
        
        StringBuilder sb = new StringBuilder();
        for(byte b: bytesArr){
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }
}
