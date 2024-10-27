package org.example;

import java.math.BigDecimal;

public class Product {
    private final String id;
    private final String name;
    private final BigDecimal price;

    public Product(String id, String name, String quantity, BigDecimal price) {
        this.id = id;
        this.name = name + " " + quantity;
        this.price = price;
    }

    public Product(String id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + "\n";
    }
}
