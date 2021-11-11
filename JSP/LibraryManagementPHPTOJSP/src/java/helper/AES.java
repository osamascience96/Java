/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// The Class that encrypts the string into AES-128-ECB algorithm
package helper;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author osama
 * Copied the class from https://www.programmersought.com/article/3530689469/   
 */
public class AES {
    private static String sKey = "1234567890123456";
    
    // encryption
    public static String Encrypt(String sSrc) throws Exception {
        if (sKey == null) {
            System.out.print("Key is null");
            return null;
        }
        
        // Determine if the Key is 16
        if (sKey.length() != 16) {
            System.out.print("Key length is not 16");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"Algorithm/Mode/Complementary Method"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        return new Base64().encodeToString(encrypted);//This uses BASE64 for transcoding and can play 2 encryptions at the same time.
    }
    
    public static String Decrypt(String sSrc) throws Exception {
        try {
            // Determine if the Key is correct
            if (sKey == null) {
                System.out.print("Key is null");
                return null;
            }
            // Determine if the Key is 16
            if (sKey.length() != 16) {
                System.out.print("Key length is not 16");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc); //First decrypt with base64
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
