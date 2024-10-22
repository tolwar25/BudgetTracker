package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    final static String MAGNIT_URL = "https://magnit.ru/catalog?shopCode=";
    final static String SHOP_ID = "992301";
    final static String OUTPUT = "output.txt";

    static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter(OUTPUT)) {
            Document doc = Jsoup.connect(MAGNIT_URL + SHOP_ID).get();
            Elements titles = doc.select("article");
            for (Element title : titles) {
                String priceString = title.select(".unit-catalog-product-preview-prices__regular")
                        .text()
                        .replaceAll("[^\\d.,]", "")
                        .replace(",", ".");
                BigDecimal price = new BigDecimal(priceString);

                String name = title.select(".unit-catalog-product-preview-title").text();

                String pricePerQuantity = title.select(".unit-catalog-product-preview-unit-value").text();

                products.add(new Product(price, name, pricePerQuantity));
            }

            for (Product product : products) {
                System.out.println(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}