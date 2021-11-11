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
public class Catalog {
    private int id;
    private String title;
    private String author;
    private double price;
    private String createdAt;
    
    public Catalog(){
    }
    
    public Catalog(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public Catalog(int id, String title, String author, double price, String createdAt){
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
