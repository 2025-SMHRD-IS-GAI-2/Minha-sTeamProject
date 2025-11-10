package com.travel.model.dao;

import com.travel.model.vo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TravelDAOImplement implements TravelDAO {

    // (필수) 이 부분은 실제 사용하시는 Oracle DB 접속 정보로 변경해야 합니다.
    // 예를 들어 Oracle XE를 설치하셨다면 SID는 XE 또는 XEPDB1일 가능성이 높습니다.
    private final String DB_URL = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:XE"; // Oracle XE SID 방식 예시
    private final String DB_USER = "campus_25IS_GA2_P1_3"; // 위에서 생성한 Oracle 유저명
    private final String DB_PASS = "smhrd3"; // 해당 유저의 비밀번호

    public TravelDAOImplement() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Loaded!");
        } catch (ClassNotFoundException e) {
            System.err.println("오류: Oracle JDBC Driver를 찾을 수 없습니다. ojdbcX.jar 파일을 확인해주세요: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    @Override
    public List<ContinentVO> getAllContinents() {
        List<ContinentVO> continentList = new ArrayList<>();
        String sql = "SELECT continent_id, continent_name FROM Continent ORDER BY continent_id";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                continentList.add(new ContinentVO(rs.getString("continent_id"), rs.getString("continent_name")));
            }
        } catch (SQLException e) {
            System.err.println("오류: 대륙 조회 중 데이터베이스 접근 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        return continentList;
    }

    @Override
    public List<CountryVO> getCountriesByContinentId(String continentId) {
        List<CountryVO> countryList = new ArrayList<>();
        String sql = "SELECT country_id, country_name, continent_id FROM Country WHERE continent_id = ? ORDER BY country_name";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, continentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    countryList.add(new CountryVO(
                        rs.getString("country_id"),
                        rs.getString("country_name"),
                        rs.getString("continent_id")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("오류: 국가 조회 중 데이터베이스 접근 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        return countryList;
    }

    @Override
    public List<RestaurantVO> getRestaurantsByCountryId(String countryId) {
        List<RestaurantVO> restaurantList = new ArrayList<>();
        String sql = "SELECT restaurant_id, restaurant_name, country_id, address, menu FROM Restaurant WHERE country_id = ? ORDER BY restaurant_name";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, countryId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    restaurantList.add(new RestaurantVO(
                        rs.getString("restaurant_id"),
                        rs.getString("restaurant_name"),
                        rs.getString("country_id"),
                        rs.getString("address"),
                        rs.getString("menu")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("오류: 맛집 조회 중 데이터베이스 접근 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        return restaurantList;
    }

    @Override
    public List<TouristVO> getTouristsByCountryId(String countryId) {
        List<TouristVO> touristList = new ArrayList<>();
        String sql = "SELECT tourist_id, tourist_name, country_id, location FROM Tourist WHERE country_id = ? ORDER BY tourist_name";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, countryId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    touristList.add(new TouristVO(
                        rs.getString("tourist_id"),
                        rs.getString("tourist_name"),
                        rs.getString("country_id"),
                        rs.getString("location")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("오류: 관광지 조회 중 데이터베이스 접근 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        return touristList;
    }

    // --- 추가: getTravelTipsByCountryId() 메서드 구현 ---
    @Override
    public List<TravelTipVO> getTravelTipsByCountryId(String countryId) {
        List<TravelTipVO> list = new ArrayList<>();
        String sql = "SELECT tip_id, country_id, entry_info, flight_info, time_diff, payment_info, transport, food_info, stay_info, shopping, weather, safety, etc FROM TravelTip WHERE country_id = ? ORDER BY tip_id";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, countryId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    TravelTipVO tip = new TravelTipVO();
                    tip.setId(rs.getString("tip_id"));
                    tip.setCountryId(rs.getString("country_id"));
                    tip.setEntryInfo(rs.getString("entry_info"));
                    tip.setFlightInfo(rs.getString("flight_info"));
                    tip.setTimeDiff(rs.getString("time_diff"));
                    tip.setPaymentInfo(rs.getString("payment_info"));
                    tip.setTransport(rs.getString("transport"));
                    tip.setFoodInfo(rs.getString("food_info"));
                    tip.setStayInfo(rs.getString("stay_info"));
                    tip.setShopping(rs.getString("shopping"));
                    tip.setWeather(rs.getString("weather"));
                    tip.setSafety(rs.getString("safety"));
                    tip.setEtc(rs.getString("etc"));
                    list.add(tip);
                }
            }
        } catch (SQLException e) {
            System.err.println("여행 Tip 조회 오류: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    

    
}
