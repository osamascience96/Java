/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Bean.Cart;
import Bean.Product;
import java.util.ArrayList;

/**
 *
 * @author osama
 */
public class CartHelper {
    public static final int GetUserIdIndex(ArrayList<Cart> arrayListCart, int userId){
        int index = -1;
        
        for(int i=0; i < arrayListCart.size(); i++){
            if(userId == arrayListCart.get(i).getUserId()){
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    public static final int GetProductIndex(ArrayList<Product> arrayListProduct, int productId){
        int index = -1;
        
        for(int i=0; i < arrayListProduct.size(); i++){
            if(productId == arrayListProduct.get(i).getId()){
                index = i;
                break;
            }
        }
        
        return index;
    }
}
