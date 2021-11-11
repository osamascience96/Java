/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author osama
 */
public class DateTimeHelper {
    
    public static String GetDayofWeekbyDate(String date){
        String[] dateArray  = date.split("-");
        
        Date dateObj = new Date(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        
        return simpleDateFormat.format(dateObj);
    }
    
    public static boolean IsOnDay(String day){
        boolean is_on_day = false;
        
        if(day.compareToIgnoreCase("Monday") == 0 || day.compareToIgnoreCase("Tuesday") == 0 || day.compareToIgnoreCase("Wednesday") == 0 || day.compareToIgnoreCase("Thursday") == 0 || day.compareToIgnoreCase("Friday") == 0){
            is_on_day = true;
        }
        
        return is_on_day;
    }
    
    public static boolean IsOnTime(String time){
        boolean is_on_time = false;
        
        String[] timeArray = time.split(":");
        
        int hour = Integer.parseInt(timeArray[0]);
        
        if(hour >= 8 && hour < 17){
            is_on_time = true;
        }
        
        return is_on_time;
    }
}
