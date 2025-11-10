package com.travel.model.dao;

import com.travel.model.vo.*;
import java.util.List;

public interface TravelDAO {
    List<ContinentVO> getAllContinents();
    List<CountryVO> getCountriesByContinentId(String continentId);
    List<RestaurantVO> getRestaurantsByCountryId(String countryId);
    List<TouristVO> getTouristsByCountryId(String countryId);
    List<TravelTipVO> getTravelTipsByCountryId(String countryId); // 여행 Tip 메서드 추가

  
    
}