package com.zaawansowana;

/**
 * Created by user on 08.03.2017.
 */
public class ShoppingCartEmptyException extends Exception {
    private String msg;
    public ShoppingCartEmptyException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}

