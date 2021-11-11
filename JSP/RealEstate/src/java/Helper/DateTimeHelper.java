/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author osama
 */
public class DateTimeHelper {
    public static final String GetCurrentDateTimeStamp(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormatter.format(now);
    }
}
