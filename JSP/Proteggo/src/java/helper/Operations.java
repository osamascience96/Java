/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author osama
 */
public class Operations {
    public static boolean IsNullOrEmpty(String value){
        boolean is_valid = true;
        
        if(value != null){
            if(!(value.compareTo("") == 0)){
                is_valid = false;
            }
        }
        
        return is_valid;
    }
}
