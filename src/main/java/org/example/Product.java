package org.example;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final String quantity;
    private final BigDecimal price;

    public Product(BigDecimal price, String name, String pricePerQuantity) {
        this.price = price;
        this.name = name;
        this.quantity = pricePerQuantity;
    }

    @Override
    public String toString() {
        return quantity.isEmpty() ?
                price + " " + name + "\n" :
                price + " " + name + " " + quantity + "\n";
    }
}
