/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author osama
 */
public class Order {
    private int id;
    private int userId;
    private String productSets;
    private double totalPrice;
    private String createdAt;
    
    public Order(){
    }
    
    public Order(int id, int userId, String productSets, double totalPrice, String createdAt){
        this.id = id;
        this.userId = userId;
        this.productSets = productSets;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductSets() {
        return productSets;
    }

    public void setProductSets(String productSets) {
        this.productSets = productSets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
