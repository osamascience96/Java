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
public class Orders {
    private int id;
    private int user_id;
    private String product_sets;
    
    public Orders(){
    }
    
    public Orders(int id, int user_id, String product_sets){
        this.id = id;
        this.user_id = user_id;
        this.product_sets = product_sets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProduct_sets() {
        return product_sets;
    }

    public void setProduct_sets(String product_sets) {
        this.product_sets = product_sets;
    }
}
