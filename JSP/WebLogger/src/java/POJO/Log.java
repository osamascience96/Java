/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

/**
 *
 * @author osama
 */
public class Log {
    private Date accessTime;
    private String authenticationType;
    private String username;
    private String userIpAddress;
    private String browser;
    private long milliseconds;
    
    public Log(){
    }
    
    public Log(Date accessTime, String authenticationType, String username, String userIpAddress, String browser){
        this.accessTime = accessTime;
        this.authenticationType = authenticationType;
        this.username = username;
        this.userIpAddress = userIpAddress;
        this.browser = browser;
    }
    
    public void SetAccessTime(Date accessTime){
        this.accessTime = accessTime;
    }
    public Date GetAccessTime(){
        return this.accessTime;
    }
    
    public void SetAuthenticationType(String authenticationTYpe){
        this.authenticationType = authenticationTYpe;
    }
    public String GetAuthenticationType(){
        return this.authenticationType;
    }
    
    public void SetUsername(String username){
        this.username = username;
    }
    public String GetUsername(){
        return this.username;
    }
    
    public void SetUserIpAddress(String userIpAddress){
        this.userIpAddress = userIpAddress;
    }
    public String GetUserIpAddress(){
        return this.userIpAddress;
    }
    
    public void SetBrowser(String browser){
        this.browser = browser;
    }
    public String GetBrowser(){
        return this.browser;
    }
    
    public void SetMilliseconds(long milliseconds){
        this.milliseconds = milliseconds;
    }
    public long GetMilliseconds(){
        return this.milliseconds;
    }
}
