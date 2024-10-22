package org.example;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final String pricePerQuantity;
    private final BigDecimal price;

    public Product(BigDecimal price, String name, String pricePerQuantity) {
        this.price = price;
        this.name = name;
        this.pricePerQuantity = pricePerQuantity;
    }

    @Override
    public String toString() {
        return pricePerQuantity.isEmpty() ?
                price + " " + name + "\n" :
                price + " " + name + " " + pricePerQuantity + "\n";
    }
}
