package com.zaawansowana;

/**
 * Created by user on 08.03.2017.
 */
public class ProductNotFoundException extends Exception {
    private String msg;

    public ProductNotFoundException(String productWasNotFound) {
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
