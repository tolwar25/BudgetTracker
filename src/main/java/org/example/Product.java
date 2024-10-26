package org.example;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final String quantity;
    private final BigDecimal price;
    private final String productId;

    public Product(BigDecimal price, String name, String quantity, String productId) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return quantity.isEmpty() ?
                price + " " + name + " " + productId + "\n" :
                price + " " + name + " " + quantity + " " + productId + "\n";
    }
}
