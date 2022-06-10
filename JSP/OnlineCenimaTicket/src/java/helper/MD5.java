/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class MD5 {
    public static String GetMD5(String text){
        
        String encryptedText = "";
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(text.getBytes());
            
            BigInteger bigInteger = new BigInteger(1, messageDigest);
            
            String hashText = bigInteger.toString(16);
            while(hashText.length() < 32){
                hashText = "0" + hashText;
            }
            
            encryptedText = hashText;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return encryptedText;
    }
}
