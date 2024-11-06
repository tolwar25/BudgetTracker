package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MagnitApiRequest {

    public static void main(String[] args) {
        try {
            // Инициализируем HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Создаём тело запроса
            Request requestBody = new Request();
            requestBody.setSort(new Sort("desc", "popularity"));
            requestBody.setPagination(new Pagination(50, 0));
            requestBody.setIncludeAdultGoods(true);
            requestBody.setStoreCode(ApiConstants.STORE_CODE);
            requestBody.setStoreType(ApiConstants.STORE_TYPE);
            requestBody.setCatalogType(ApiConstants.CATALOG_TYPE);

            // Сериализуем тело запроса в JSON
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(requestBody);

            // Формируем и отправляем HTTP-запрос
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ApiConstants.API_URL))
                    .header("Content-Type", ApiConstants.CONTENT_TYPE)
                    .header("Cookie", ApiConstants.COOKIE)
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            // Отправка запроса и получение ответа
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Код статуса: " + response.statusCode());
            System.out.println("Ответ сервера: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
