package com.travel.model.vo;


public class ContinentVO implements TravelInfo {
    private String id;
    private String name;

    public ContinentVO() {
        // 기본 생성자
    }

    public ContinentVO(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }
}