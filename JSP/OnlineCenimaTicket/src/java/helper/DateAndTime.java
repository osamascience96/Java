/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.time.LocalDate;

/**
 *
 * @author osama
 */
public class DateAndTime {
    public static String GetDate(){
        LocalDate localDate = LocalDate.now();
        return localDate.toString();
    }
}
