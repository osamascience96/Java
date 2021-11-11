/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.math.BigDecimal;

/**
 *
 * @author osama
 */
public class Book {
    private int id;
    private Category category;
    private String name;
    private String author;
    private BigDecimal ISBN;
    private int is_issued;

    public Book() {
    }

    public Book(int id, Category category, String name, String author, BigDecimal ISBN, int is_issued) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.is_issued = is_issued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getISBN() {
        return ISBN;
    }

    public void setISBN(BigDecimal ISBN) {
        this.ISBN = ISBN;
    }

    public int getIs_issued() {
        return is_issued;
    }

    public void setIs_issued(int is_issued) {
        this.is_issued = is_issued;
    }
    
    
}
