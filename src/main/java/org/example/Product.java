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

    public Product(Item item) {
            this.name = item.getName() + (item.getWeighted().getShelfLabel() != null ? " " + item.getWeighted().getShelfLabel() : "");
            this.price = BigDecimal.valueOf(item.getPrice());
            this.id = item.getId();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + "\n";
    }
}
