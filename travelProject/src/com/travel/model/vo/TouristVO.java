package com.travel.model.vo;


public class TouristVO implements TravelInfo {
    private String id;
    private String name;
    private String countryId; // FK
    private String location;

    public TouristVO() {
        // 기본 생성자
    }

    public TouristVO(String id, String name, String countryId, String location) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.location = location;
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

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return " - " + name + " (위치: " + location + ")";
    }
}