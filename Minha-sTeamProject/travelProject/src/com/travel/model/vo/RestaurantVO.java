package com.travel.model.vo;


public class RestaurantVO implements TravelInfo {
    private String id;
    private String name;
    private String countryId; // FK
    private String location;
    private String recommendMenu;

    public RestaurantVO() {
        // 기본 생성자
    }

    public RestaurantVO(String id, String name, String countryId, String location, String recommendMenu) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
        this.location = location;
        this.recommendMenu = recommendMenu;
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

    public String getRecommendMenu() {
        return recommendMenu;
    }

    public void setRecommendMenu(String recommendMenu) {
        this.recommendMenu = recommendMenu;
    }

    @Override
    public String toString() {
        return " - " + name + " (위치: " + location + (recommendMenu != null && !recommendMenu.isEmpty() ? ", 추천: " + recommendMenu : "") + ")";
    }
}