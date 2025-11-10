package com.travel.controller;

import com.travel.model.vo.*;
import java.util.List;

public interface TravelController {
    List<ContinentVO> showContinents();
    List<CountryVO> showCountries(String continentId);
    List<RestaurantVO> showRestaurants(String countryId);
    List<TouristVO> showTourists(String countryId);
    List<TravelTipVO> showTravelTips(String countryId); // 여행 Tip 메서드 추가
}