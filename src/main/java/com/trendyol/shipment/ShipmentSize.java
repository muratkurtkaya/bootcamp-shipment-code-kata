package com.trendyol.shipment;

public enum ShipmentSize {

    SMALL,
    MEDIUM,
    LARGE,
    X_LARGE;

    public ShipmentSize getNextSize() {
        if (this.ordinal() == values().length - 1) {
            return this;
        }
        return values()[this.ordinal() + 1];
    }
}
