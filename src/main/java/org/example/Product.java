package org.example;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final BigDecimal price;
    private final String id;

    public Product(String id, String name, String quantity, BigDecimal price) {
        this.price = price;
        this.name = name + " " + quantity;
        this.id = id;
    }

    public Product(String id, String name, BigDecimal price) {
        this.price = price;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + "\n";
    }
}
