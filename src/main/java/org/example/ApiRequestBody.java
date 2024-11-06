package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
class Request {
    private Sort sort;
    private Pagination pagination;
    private boolean includeAdultGoods;
    private String storeCode;
    private String storeType;
    private String catalogType;

    // Конструкторы, геттеры и сеттеры
    public void setSort(Sort sort) { this.sort = sort; }
    public void setPagination(Pagination pagination) { this.pagination = pagination; }
    public void setIncludeAdultGoods(boolean includeAdultGoods) { this.includeAdultGoods = includeAdultGoods; }
    public void setStoreCode(String storeCode) { this.storeCode = storeCode; }
    public void setStoreType(String storeType) { this.storeType = storeType; }
    public void setCatalogType(String catalogType) { this.catalogType = catalogType; }

    public Sort getSort() {
        return sort;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public boolean isIncludeAdultGoods() {
        return includeAdultGoods;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public String getStoreType() {
        return storeType;
    }

    public String getCatalogType() {
        return catalogType;
    }
}

class Sort {
    private String order;
    private String type;

    public Sort(String order, String type) {
        this.order = order;
        this.type = type;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    // Геттеры и сеттеры
}

class Pagination {
    private int limit;
    private int offset;

    public Pagination(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    // Геттеры и сеттеры
}
