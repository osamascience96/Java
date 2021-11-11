/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author osama
 */
public class Car {
    private int id;
    private User user;
    private String manufacturer;
    private String model;
    private String type;
    private int year_of_manufacturer;
    private int miles;
    private float price;
    private char hasAC;
    private char hasDVD;
    private String comments;
    private Blob image;
    private InputStream inputStream;
    private String created_at;
    
    public Car(){
    }
    
    public Car(int id, User user, String manufacturer, String model, String type, int year_of_manufacturer, int miles, float price, char hasAC, char hasDVD, String comments, Blob image, String created_at){
        this.id = id;
        this.user = user;
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.year_of_manufacturer = year_of_manufacturer;
        this.miles = miles;
        this.price = price;
        this.hasAC = hasAC;
        this.hasDVD = hasDVD;
        this.comments = comments;
        this.image = image;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear_of_manufacturer() {
        return year_of_manufacturer;
    }

    public void setYear_of_manufacturer(int year_of_manufacturer) {
        this.year_of_manufacturer = year_of_manufacturer;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public char getHasAC() {
        return hasAC;
    }

    public void setHasAC(char hasAC) {
        this.hasAC = hasAC;
    }

    public char getHasDVD() {
        return hasDVD;
    }

    public void setHasDVD(char hasDVD) {
        this.hasDVD = hasDVD;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    
}
