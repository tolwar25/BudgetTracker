package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class MagnitApiRequest {

    private static final int LIMIT = 33;

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();
            int offset = 0;
            List<Item> allItems = new ArrayList<>();

            while (true) {
                Request requestBody = new Request();
                requestBody.setSort(new Sort("desc", "popularity"));
                requestBody.setPagination(new Pagination(LIMIT, offset));
                requestBody.setIncludeAdultGoods(true);
                requestBody.setStoreCode(ApiConstants.STORE_CODE);
                requestBody.setStoreType(ApiConstants.STORE_TYPE);
                requestBody.setCatalogType(ApiConstants.CATALOG_TYPE);

                String json = mapper.writeValueAsString(requestBody);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(ApiConstants.API_URL))
                        .header("Content-Type", ApiConstants.CONTENT_TYPE)
                        .header("Cookie", ApiConstants.COOKIE)
                        .POST(HttpRequest.BodyPublishers.ofString(json))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Код статуса: " + response.statusCode());

                ApiResponse apiResponse = mapper.readValue(response.body(), ApiResponse.class);

                List<Item> items = apiResponse.getItems();

                if (items == null || items.isEmpty()) {
                    break;
                }

                allItems.addAll(items);

                offset += LIMIT;
            }

            int productNumber = 1;
            for (Item item : allItems) {
                System.out.println(productNumber);
                System.out.println("Название товара: " + item.getName() + (item.getWeighted().getShelfLabel() != null ? " " + item.getWeighted().getShelfLabel() : ""));
                System.out.println("Цена: " + item.getPrice());
                System.out.println("ID товара " + item.getId());
                System.out.println("-------------------------");
                productNumber++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
