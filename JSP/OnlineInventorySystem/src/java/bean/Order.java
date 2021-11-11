/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class Order {
    private int id;
    private ArrayList<Inventory> inventoryArrayList;
    private User user;
    private String created_at;
    
    public Order(){
    }
    
    public Order(int id, ArrayList<Inventory> inventoryArrayList, User user, String created_at){
        this.id = id;
        this.inventoryArrayList = inventoryArrayList;
        this.user = user;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Inventory> getInventoryArrayList() {
        return inventoryArrayList;
    }

    public void setInventoryArrayList(ArrayList<Inventory> inventoryArrayList) {
        this.inventoryArrayList = inventoryArrayList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    
    
}
