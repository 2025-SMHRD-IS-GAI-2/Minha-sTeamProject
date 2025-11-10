package com.travel.controller;

import com.travel.model.dao.TravelDAO;
import com.travel.model.dao.TravelDAOImplement;
import com.travel.model.vo.*;
import java.util.List;

public class TravelControllerImplement implements TravelController {

    private TravelDAO dao;

    public TravelControllerImplement() {
        this.dao = new TravelDAOImplement();
    }

    @Override
    public List<ContinentVO> showContinents() { return dao.getAllContinents(); }

    @Override
    public List<CountryVO> showCountries(String continentId) { return dao.getCountriesByContinentId(continentId); }

    @Override
    public List<RestaurantVO> showRestaurants(String countryId) { return dao.getRestaurantsByCountryId(countryId); }

    @Override
    public List<TouristVO> showTourists(String countryId) { return dao.getTouristsByCountryId(countryId); }

    // --- 추가: showTravelTips() 메서드 구현 ---
    @Override
    public List<TravelTipVO> showTravelTips(String countryId) {
        return dao.getTravelTipsByCountryId(countryId);
    }
}