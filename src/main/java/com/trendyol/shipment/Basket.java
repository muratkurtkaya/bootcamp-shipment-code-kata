package com.trendyol.shipment;

import java.util.Collections;
import java.util.List;

public class Basket {

    private List<Product> products = Collections.emptyList();

    public ShipmentSize getShipmentSize() throws BasketEmptyException {
        ShipmentHandler shipmentHandler = new ShipmentHandler(this);
        return shipmentHandler.getShipmentSize();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
