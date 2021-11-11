/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condition;

/**
 *
 * @author osama
 */
public class main {
    public static void main(String args[]){
        int num1 = 40;
        int num2 = 20;
        int num3 = 40;
        
        if(num1 == num2){
            System.out.println("Statement 1 is true");
        }else if(num2 == num3){
            System.out.println("Statement 2 is true");
        }else{
            System.out.println("Default Statement is true");
        }
    }
}
