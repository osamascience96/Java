/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osama
 */
public class ImageBase64 {
    public static String GetImageData(Blob imageData){
        InputStream inputStream = null;
        try {
            inputStream = imageData.getBinaryStream();
        } catch (SQLException ex) {
            Logger.getLogger(ImageBase64.class.getName()).log(Level.SEVERE, null, ex);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        try {
            while((bytesRead = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            Logger.getLogger(ImageBase64.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] imagesBytes = outputStream.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(imagesBytes);
        try {
            inputStream.close();
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(ImageBase64.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return base64Image;
    }
}
