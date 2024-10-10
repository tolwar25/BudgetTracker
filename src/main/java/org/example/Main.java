package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // Отправляем GET-запрос к веб-странице
            Document doc = Jsoup.connect("https://magnit.ru/catalog?shopCode=992301")
                    .userAgent("Mozilla/5.0")  // Задаем User-Agent (может помочь при блокировке ботов)
                    .timeout(5000)  // Устанавливаем тайм-аут соединения
                    .get();  // Выполняем GET-запрос

            // Выводим содержимое страницы в консоль
            System.out.println(doc.html());  // Выводим HTML-код страницы

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}