package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    final static String MAGNIT_URL = "https://magnit.ru/catalog?shopCode=%s&page=%d";
    final static String SHOP_ID = "992301";
    final static String OUTPUT = "output.txt";

    public static List<Product> products = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            Document doc = Jsoup.connect(String.format(MAGNIT_URL, SHOP_ID, 1)).get();

            Elements countPages = doc.select(".pl-pagination__pager");
            String lastPageString = countPages.select(".pl-button__icon").last().text();
            int lastPage = new Integer(lastPageString);

            for (int page = 1; page <= lastPage; page++) {
                Document doc2 = Jsoup.connect(String.format(MAGNIT_URL, SHOP_ID, page)).get();

                Elements titles = doc2.select("article");
                for (Element title : titles) {
                    String priceString = title.select(".unit-catalog-product-preview-prices__regular")
                            .text()
                            .replaceAll("[^\\d.,]", "")
                            .replace(",", ".");
                    BigDecimal price = new BigDecimal(priceString);

                    String name = title.select(".unit-catalog-product-preview-title").text();

                    String quantity = title.select(".unit-catalog-product-preview-unit-value").text();

                    products.add(new Product(price, name, quantity));
                }
            }
            for (Product product : products) {
                writer.write(product.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}