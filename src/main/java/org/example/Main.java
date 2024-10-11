package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    static String MAGNIT_URL = "https://magnit.ru/catalog?shopCode=";
    static String SHOP_ID = "992301";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(MAGNIT_URL + SHOP_ID)
                    .get();
            System.out.println(doc.html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}