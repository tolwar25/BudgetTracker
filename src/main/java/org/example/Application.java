package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int LIMIT = 33;

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();
            int offset = 0;
            List<Item> allItems = new ArrayList<>();

            while (true) {
                MagnitGoodsRequest requestBody = MagnitGoodsRequest
                        .builder()
                        .sort(new Sort("desc", "popularity"))
                        .pagination(new Pagination(LIMIT, offset))
                        .includeAdultGoods(true)
                        .storeCode(ApiConstants.STORE_CODE)
                        .storeType(ApiConstants.STORE_TYPE)
                        .catalogType(ApiConstants.CATALOG_TYPE)
                        .build();

                String json = mapper.writeValueAsString(requestBody);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(ApiConstants.API_URL))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                        .POST(HttpRequest.BodyPublishers.ofString(json))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Код статуса: " + response.statusCode());

                MagnitGoodsResponse magnitGoodsResponse = mapper.readValue(response.body(), MagnitGoodsResponse.class);

                List<Item> items = magnitGoodsResponse.getItems();

                if (items == null || items.isEmpty()) {
                    break;
                }

                allItems.addAll(items);

                offset += LIMIT;
            }

            int productNumber = 1;
            for (Product product : allItems.stream().map(Product::new).toList()) {
                System.out.println(productNumber++ + " " + product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
