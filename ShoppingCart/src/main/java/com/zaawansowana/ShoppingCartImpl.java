/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaawansowana;

import javax.swing.*;
import java.util.ArrayList;

import static javafx.scene.input.KeyCode.S;


public class ShoppingCartImpl implements ShoppingCart {

    private ArrayList<Product> products;
    public ShoppingCartImpl()
    {
        products = new ArrayList<Product>();
    }
    public int productCount() {
       return products.size();
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public void removeProduct(int productId) throws ShoppingCartEmptyException, ProductNotFoundException {
        if(productCount() == 0)
            throw new ShoppingCartEmptyException("Shopping Car tWasEmpty");

        products.remove(getProductById(productId));


    }
    private Product getProductById(int id) throws ProductNotFoundException {
        Product prod=null;
        for (Product product : products) {
            if(product.getId() == id)
            {
                prod = product;
            }
        }
        if (prod == null)
        {
            throw new ProductNotFoundException("ProductWasNotFound");
        }
        else
        {
            return prod;
        }

    }

}
