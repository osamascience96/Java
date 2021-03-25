/* Converted the text to the base64 encryption
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conf;

import java.util.Base64;

/**
 *
 * @author osama
 * Class to convert  any string to the base64 encryption, not a very strong encryption
 */
public class Base64Encryption {
    private String finalString;
    
    public Base64Encryption(String text){
        this.finalString = text;
    }
    
    public String GetEncodedString(){
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(this.finalString.getBytes());
    }
}
