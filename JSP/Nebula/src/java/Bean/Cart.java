/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class Cart {
    private int userId;
    private ArrayList<Product> arrayListProducts;
    
    public Cart(){
    }
    
    public Cart(int userId, ArrayList<Product> arrayListProducts){
        this.userId = userId;
        this.arrayListProducts = arrayListProducts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Product> getArrayListProducts() {
        return arrayListProducts;
    }

    public void setArrayListProducts(ArrayList<Product> arrayListProducts) {
        this.arrayListProducts = arrayListProducts;
    }
    
    
}
