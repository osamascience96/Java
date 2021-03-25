/*
 * Um diesen Lizenzheader zu ändern, wählen Sie in den Projekteigenschaften Lizenzheader.
 * Um diese Vorlagendatei zu ändern, wählen Sie Extras | Vorlagen
 * und öffnen Sie die Vorlage im Editor.
 */
package com.pojo;

// Wunschliste POJO
public class WishList {
    private int id;
    private int user_id;
    private int product_id;
    private String product_name;
    private double product_price;
    private String product_image_name;
    
    // Initialisiere die beiden Konstruktoren
    public WishList(){
    }
    
    // Konstruktor mit Parametern
    public WishList(int id, int user_id, int product_id){
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
    }
    
    // Id Getter und Setter
    public void SetId(int id){
        this.id = id;
    }
    public int GetId(){
        return this.id;
    }
    
    // UserId Getter und Setter
    public void SetUserId(int user_id){
        this.user_id = user_id;
    }
    public int GetUserId(){
        return this.user_id;
    }
    
    // Produkt-ID Getter und Setter
    public void SetProductId(int product_id){
        this.product_id = product_id;
    }
    public int GetProductid(){
        return this.product_id;
    }
    
    // Produktname Getter und Setter
    public void SetProductName(String product_name){
        this.product_name = product_name;
    }
    public String GetProductName(){
        return this.product_name;
    }
    
    // Produktpreis Getter und Setter
    public void SetProductPrice(double product_price){
        this.product_price = product_price;
    }
    public double GetProductPrice(){
        return this.product_price;
    }
    
    // Produktbild Name Getter und Setter
    public void SetProductImageName(String product_image_name){
        this.product_image_name = product_image_name;
    }
    public String GetProductImageName(){
        return this.product_image_name;
    }
}
