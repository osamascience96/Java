/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author osama
 */
public class PDQ {
    private int pdq_num;
    private String location;
    private int response_rate;
    private int linenumber;
    
    public PDQ(){
    }
    
    public PDQ(int pdq_num, String location, int response_rate){
        this.pdq_num = pdq_num;
        this.location = location;
        this.response_rate = response_rate;
    }
    
    public void SetPDQNUM(int pdq_num){
        this.pdq_num = pdq_num;
    }
    public int GetPDQNUM(){
        return this.pdq_num;
    }
    
    public void SetLocation(String location){
        this.location = location;
    }
    public String GetLocation(){
        return this.location;
    }
    
    public void SetResponseRate(int response_rate){
        this.response_rate = response_rate;
    }
    public int GetResponseRate(){
        return this.response_rate;
    }
    
    public void SetLineNumber(int linenumber){
        this.linenumber = linenumber;
    }
    public int GetLineNumber(){
        return this.linenumber;
    }
}
