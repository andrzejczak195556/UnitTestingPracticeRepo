/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zaawansowana;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.*;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 *
 * @author miszel
 */
@RunWith(JUnitParamsRunner.class)
public class ShopingCartTest {
    private ShoppingCart shoppingcart;
    private final static int PRODUCT_ID = 1;
    private final static int INVALID_PRODUCT_ID = 100;
    
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
    @Parameters(method = "getNumberOfProducts")
    public void testAddProductToCart(int numberOfProducts){

        for (int i=0;i<numberOfProducts;i++)
        {
            shoppingcart.add(new Product());
        }


        assertThat(shoppingcart.productCount()).isEqualTo(numberOfProducts);
    }

    private Object[] getNumberOfProducts()
   {
       return $(
                 $(1),$(2),$(5),$(10)
       );


   }

    @Test(expected = ShoppingCartEmptyException.class)
    public void testRemoveFromTheCart() throws ShoppingCartEmptyException, ProductNotFoundException {
        shoppingcart.removeProduct(PRODUCT_ID);
    }

    @Test(expected = ProductNotFoundException.class)
    public void productWasNotFoundInTheCart() throws ShoppingCartEmptyException, ProductNotFoundException {

        shoppingcart.add(new Product(PRODUCT_ID,"Milk"));

        shoppingcart.removeProduct(INVALID_PRODUCT_ID);
    }

    @Test
    public void productWasSuccessfullyRemoved() throws ShoppingCartEmptyException, ProductNotFoundException {
        shoppingcart.add(new Product(PRODUCT_ID,"Milk"));

        shoppingcart.removeProduct(PRODUCT_ID);

        assertThat(shoppingcart.productCount()).isEqualTo(0);
    }
}
