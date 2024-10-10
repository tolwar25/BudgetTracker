package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            // Отправляем GET-запрос и получаем HTML
            Document doc = Jsoup.connect("https://magnit.ru/catalog?shopCode=992301")
                    .userAgent("Mozilla/5.0")
                    .timeout(5000)
                    .get();

            // Записываем содержимое в файл с помощью NIO (Files.write)
            Files.write(Paths.get("output.html"), doc.html().getBytes());

            System.out.println("HTML содержимое успешно записано в файл");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}