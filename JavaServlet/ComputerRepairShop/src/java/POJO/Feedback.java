/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author osama
 */
public class Feedback {
    private int id;
    private String name;
    private String country;
    private String phone;
    private String email;
    private String subject;
    private String type;
    private String message;
    private String creation_datetime;
    
    public Feedback(){
    }
    
    public Feedback(int id, String name, String country, String phone, String email, String subject, String type, String message, String creation_datetime){
        this.id = id;
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.subject = subject;
        this.type = type;
        this.message = message;
        this.creation_datetime = creation_datetime;
    }
    
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetName(String name){
        this.name = name;
    }
    public String GetName(){
        return this.name;
    }
    
    public void SetCountry(String country){
        this.country = country;
    }
    public String GetCountry(){
        return this.country;
    }
    
    public void SetPhone(String phone){
        this.phone = phone;
    }
    public String GetPhone(){
        return this.phone;
    }
    
    public void SetEmail(String email){
        this.email = email;
    }
    public String GetEmail(){
        return this.email;
    }
    
    public void SetSubject(String subject){
        this.subject = subject;
    }
    public String GetSubject(){
        return this.subject;
    }
    
    public void SetType(String type){
        this.type = type;
    }
    public String GetType(){
        return this.type;
    }
    
    public void SetMessage(String message){
        this.message = message;
    }
    public String GetMessage(){
        return this.message;
    }
    
    public void SetCreationDateTime(String creation_datetime){
        this.creation_datetime = creation_datetime;
    }
    public String GetCreationDateTime(){
        return this.creation_datetime;
    }
}
