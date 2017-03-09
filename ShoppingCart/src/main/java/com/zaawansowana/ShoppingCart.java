/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaawansowana;

/**
 *
 * @author miszel
 */
public interface ShoppingCart {

    int productCount();

    void add(Product product);

    void removeProduct(int validProductId) throws ShoppingCartEmptyException, ProductNotFoundException;
}
