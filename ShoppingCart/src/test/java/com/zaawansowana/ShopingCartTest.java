/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaawansowana;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.Before;

/**
 *
 * @author miszel
 */
public class ShopingCartTest {
    private ShoppingCart shoppingcart;
    
    @Before
    public void setUp()
    {
        this.shoppingcart = new ShoppingCartImpl();
    }
    @Test
    public void tesIfCartIsEmpty(){
        assertThat(shoppingcart.productCount()).isEqualTo(0);
        
    }
    @Test
    public void testAddProductToCart(){
        
    }

   
    
}
