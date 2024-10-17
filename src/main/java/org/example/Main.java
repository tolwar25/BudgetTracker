package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    static String MAGNIT_URL = "https://magnit.ru/catalog?shopCode=";
    static String SHOP_ID = "992301";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(MAGNIT_URL + SHOP_ID).get();
            Elements titles = doc.select("article");
            FileWriter writer = new FileWriter("output.txt");
            for (Element title: titles){
                String price = title.select(".unit-catalog-product-preview-prices__regular").text();
                String numericPrice = price.replaceAll("[^\\d.,]", "").replace(",", ".");
                BigDecimal bigDecimalPrice = new BigDecimal(numericPrice);

                String name = title.select(".unit-catalog-product-preview-title").text();

                String pricePerQuantity = title.select(".unit-catalog-product-preview-unit-value").text();
                writer.write(bigDecimalPrice + " " + name + " " +pricePerQuantity + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}