/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EBCDIC;

/**
 *
 * @author osama
 */
public class Conversion {
    public static String ConvertToEBCDIC(String num){
        String returnedNum = "F0";
        
        switch(num){
            case "0":
                returnedNum = "F0";
                break;
            case "1":
                returnedNum = "F1";
                break;
            case "2":
                returnedNum = "F2";
                break;
            case "3":
                returnedNum = "F3";
                break;
            case "4":
                returnedNum = "F4";
                break;
            case "5":
                returnedNum = "F5";
                break;
            case "6":
                returnedNum = "F6";
                break;
            case "7":
                returnedNum = "F7";
                break;
            case "8":
                returnedNum = "F8";
                break;
            case "9":
                returnedNum = "F9";
                break;
            case " ":
                returnedNum = "40";
                break;
            default:
                break;
        }
        
        return returnedNum;
    }
    
    
    public static String ConvertToDecimal(String numberStr){
        String number = "0";
        switch(numberStr){
            case "40":
                number = " ";
                break;
            case "F0":
                number = "0";
                break;
            case "F1":
                number = "1";
                break;
            case "F2":
                number = "2";
                break;
            case "F3":
                number = "3";
                break;
            case "F4":
                number = "4";
                break;
            case "F5":
                number = "5";
                break;
            case "F6":
                number = "6";
                break;
            case "F7":
                number = "7";
                break;
            case "F8":
                number = "8";
                break;
            case "F9":
                number = "9";
                break;
            default:
                number = "0";
                break;
        }
        return number;
    }
}
