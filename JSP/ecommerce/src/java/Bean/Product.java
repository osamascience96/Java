/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.Blob;

/**
 *
 * @author osama
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private Blob image;
    private String created_at;
    
    public Product(){
    }
    
    public Product(int id, String name, String description , double price, Blob image, String created_at){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
    
}
