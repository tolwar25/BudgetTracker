package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
class MagnitGoodsRequest {
    private Sort sort;
    private Pagination pagination;
    private boolean includeAdultGoods;
    private String storeCode;
    private String storeType;
    private String catalogType;
}

@Data
@AllArgsConstructor
class Sort {
    private String order;
    private String type;
}

@Data
@AllArgsConstructor
class Pagination {
    private int limit;
    private int offset;
}
