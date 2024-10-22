package org.example;

import java.math.BigDecimal;

public class Product {
    private String name;
    private String pricePerQuantity;
    private BigDecimal price;

    public Product(BigDecimal price, String name, String pricePerQuantity) {
        this.price = price;
        this.name = name;
        this.pricePerQuantity = pricePerQuantity;
    }

    public String getName(String name) {
        return name;
    }

    public String getPricePerQuantity(String pricePerQuantity) {
        return pricePerQuantity;
    }

    public BigDecimal getPrice(BigDecimal price) {
        return price;
    }

    @Override
    public String toString() {
        return pricePerQuantity.isEmpty() ?
                price + " " + name + "\n" :
                price + " " + name + " " + pricePerQuantity + "\n";
    }
}
