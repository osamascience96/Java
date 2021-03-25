package com.pojo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author osama
 * Cart POJO
 */
public class Cart {
    private String name;
    private int count;
    
    public Cart(){
    }
    
    public Cart(String name, int count){
        this.name = name;
        this.count = count;
    }
    
    public void SetName(String name){
        this.name = name;
    }
    public String GetName(){
        return this.name;
    }
    
    public void SetCount(int count){
        this.count = count;
    }
    public int GetCount(){
        return this.count;
    }
}
