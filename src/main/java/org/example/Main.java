package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    static String MAGNIT_URL = "https://magnit.ru/catalog?shopCode=";
    static String SHOP_ID = "992301";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(MAGNIT_URL + SHOP_ID)
                    .get();
            Files.write(Paths.get("output.html"), doc.html().getBytes());
            System.out.println("HTML содержимое успешно записано в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}