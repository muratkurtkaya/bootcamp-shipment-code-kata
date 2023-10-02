package com.trendyol.shipment;

import java.util.*;
import java.util.stream.Collectors;

public class ShipmentHandler {

    private final static Integer BASKET_SHIPMENT_THRESHOLD_VALUE = 3;

    List<Product> products;

    public ShipmentHandler(Basket basket) {
        this.products = basket.getProducts();
    }

    public ShipmentSize getShipmentSize() throws BasketEmptyException {
        Optional<ShipmentSize> shipmentSizeAboveThreshold = getShipmentSizeAboveThreshold();
        return shipmentSizeAboveThreshold
                .map(ShipmentSize::getNextSize)
                .orElseGet(() -> products.stream()
                        .map(Product::getSize)
                        .max(ShipmentSize::compareTo)
                        .orElseThrow(BasketEmptyException::new));


    }

        private Optional<ShipmentSize> getShipmentSizeAboveThreshold() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getSize, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() >= BASKET_SHIPMENT_THRESHOLD_VALUE)
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
