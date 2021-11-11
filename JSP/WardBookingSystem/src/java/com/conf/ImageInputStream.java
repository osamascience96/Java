/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author osama
 */
public class ImageInputStream {
    public static InputStream GetImageInputStream(Part reference){
        InputStream inputStream = null;
        try {
            inputStream = reference.getInputStream();
        } catch (IOException ex) {
            Logger.getLogger(ImageInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inputStream;
    }
}
