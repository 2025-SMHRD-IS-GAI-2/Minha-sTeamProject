package com.travel.controller;

import com.travel.model.vo.*;
import java.util.List;

public interface TravelController {
    List<ContinentVO> showContinents();
    // 앗싸 오늘 월요일 5시 퇴근 집가서 씻고 넷플리스 보다가 디비 자야지!
    List<CountryVO> showCountries(String continentId);
    List<RestaurantVO> showRestaurants(String countryId);
    List<TouristVO> showTourists(String countryId);
    List<TravelTipVO> showTravelTips(String countryId); // 여행 Tip 메서드 추가
}