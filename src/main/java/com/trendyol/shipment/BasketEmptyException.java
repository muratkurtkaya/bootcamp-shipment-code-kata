package com.trendyol.shipment;

public class BasketEmptyException extends RuntimeException {
    public BasketEmptyException() {
        super("Basket is empty!");
    }
}
