/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author osama
 */
public class Order {
    private int id;
    private int productId;
    private String sessionId;
    private String CustomerName;
    private String ContactNo;
    private String Address;
    private double price;
    private int quantity;
    private String notes;
    private String created_at;
    
    public Order(){
    }
    
    public Order(int id, int productId, String sessionId, String CustomerName, String ContactNo, String Address, double Price, int quantity, String notes, String created_at){
        this.id = id;
        this.productId = productId;
        this.sessionId = sessionId;
        this.CustomerName = CustomerName;
        this.ContactNo = ContactNo;
        this.Address = Address;
        this.price = Price;
        this.quantity = quantity;
        this.notes = notes;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
