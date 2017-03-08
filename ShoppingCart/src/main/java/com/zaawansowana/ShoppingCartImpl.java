/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaawansowana;

import java.util.ArrayList;


public class ShoppingCartImpl implements ShoppingCart {

    private ArrayList<Product> products;
    public ShoppingCartImpl()
    {
        products = new ArrayList<Product>();
    }
    public int productCount() {
       return products.size();
    }
    
}
