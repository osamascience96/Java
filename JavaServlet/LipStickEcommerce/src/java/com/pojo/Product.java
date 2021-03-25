/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */
package com.pojo;

// Produkt POJO
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String type;
    private String color_type;
    private String skin_type;
    private String image_name;
    
    // Initialisieren Sie die beiden Konstruktoren
    public Product(){
    }
    
    // constructor with empty parameters
    public Product(int id, String name, double price, String description, String type, String color_type, String skin_type, String image_name){
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
        this.color_type = color_type;
        this.skin_type = skin_type;
        this.image_name = image_name;
    }
    
    // Id getter und setter
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    // setname getter und setter
    public void SetName(String name){
        this.name = name;
    }
    public String GetName(){
        return this.name;
    }
    
    // setprice getter und setter
    public void SetPrice(double price){
        this.price = price;
    }
    public double GetPrice(){
        return this.price;
    }
    
    // setdescription getter und setter
    public void SetDescription(String description){
        this.description = description;
    }
    public String GetDescription(){
        return this.description;
    }
    
    // settype getter und setter
    public void SetType(String type){
        this.type = type;
    }
    public String GetType(){
        return this.type;
    }
    
    // setcolortype getter und setter
    public void SetColorType(String color_type){
        this.color_type = color_type;
    }
    public String GetColorType(){
        return this.color_type;
    }
    
    // setskintype getter und setter
    public void SetSkinType(String skin_type){
        this.skin_type = skin_type;
    }
    public String GetSkinType(){
        return this.skin_type;
    }
    
    // setimage getter und setter
    public void SetImageName(String image_name){
        this.image_name = image_name;
    }
    public String GetImageName(){
        return this.image_name;
    }
}
