package com.inventory.catalog.bean;

public class MapEntry {
    private String key;
    private Long value;

    public MapEntry(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }
}
