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
    private String productSet;
    private double totalPrice;
    private String createdat;
    private User user;
    
    public Order(){
    }
    
    public Order(int id, int userId, String productSet, double totalPrice, String createdat){
        this.id = id;
        this.userId = userId;
        this.productSet = productSet;
        this.totalPrice = totalPrice;
        this.createdat = createdat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductSet() {
        return productSet;
    }

    public void setProductSet(String productSet) {
        this.productSet = productSet;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
