package com.travel.model.vo;


public class CountryVO implements TravelInfo {
    private String id;
    private String name;
    private String continentId; // FK

    public CountryVO() {
        // 기본 생성자
    }

    public CountryVO(String id, String name, String continentId) {
        this.id = id;
        this.name = name;
        this.continentId = continentId;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinentId() {
        return continentId;
    }

    public void setContinentId(String continentId) {
        this.continentId = continentId;
    }

    @Override
    public String toString() {
        return name;
    }
}