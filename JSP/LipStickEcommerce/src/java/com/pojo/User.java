/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */
package com.pojo;

// Benutzer pojo
public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private String address;
    private String email;
    private String password;
    private double price;
    
    // Initiieren Sie die beiden Konstruktoren
    public User(){
    }
    
    // Konstruktor mit Parametern
    public User(int id, String first_name, String last_name, String gender, String email, String password){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }
    
    // ID Getter und Setter
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    // Firstname getter und setter
    public void SetFirstName(String first_name){
        this.first_name = first_name;
    }
    public String GetFirstName(){
        return this.first_name;
    }
    
    // lastname getter und setter
    public void SetLastName(String last_name){
        this.last_name = last_name;
    }
    public String GetLastName(){
        return this.last_name;
    }
    
    // setgender getter und setter
    public void SetGender(String gender){
        this.gender = gender;
    }
    public String GetGender(){
        return this.gender;
    }
    
    // setaddress getter und setter
    public void SetAddress(String address){
        this.address = address;
    }
    public String GetAddress(){
        return this.address;
    }
    
    // setemail getter und setter
    public void SetEmail(String email){
        this.email = email;
    }
    public String GetEmail(){
        return this.email;
    }
    
    // setpassword getter und setter
    public void SetPassword(String password){
        this.password = password;
    }
    public String GetPassword(){
        return this.password;
    }
    
    // setprice getter und setter
    public void SetPrice(double price){
        this.price = price;
    }
    public double GetPrice(){
        return this.price;
    }
}
