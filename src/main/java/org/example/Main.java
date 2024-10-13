package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    static String MAGNIT_URL = "https://magnit.ru/catalog?shopCode=";
    static String SHOP_ID = "992301";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(MAGNIT_URL + SHOP_ID).get();
            Elements titles = doc.select("article");
            for (Element title: titles){
                String price = title.select(".unit-catalog-product-preview-prices__top-row").text();
                String name = title.select(".unit-catalog-product-preview-title").text();
                System.out.println(price + " " + name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}