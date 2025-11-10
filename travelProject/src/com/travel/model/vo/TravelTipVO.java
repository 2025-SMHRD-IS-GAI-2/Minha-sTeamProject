package com.travel.model.vo;

public class TravelTipVO implements TravelInfo {
    private String id;           // TIP_ID
    private String countryId;    // COUNTRY_ID
    private String entryInfo;    // ENTRY_INFO
    private String flightInfo;   // FLIGHT_INFO
    private String timeDiff;     // TIME_DIFF
    private String paymentInfo;  // PAYMENT_INFO
    private String transport;    // TRANSPORT
    private String foodInfo;     // FOOD_INFO
    private String stayInfo;     // STAY_INFO
    private String shopping;     // SHOPPING
    private String weather;      // WEATHER
    private String safety;       // SAFETY
    private String etc;          // ETC

    // 기본 생성자
    public TravelTipVO() {}

    // 전체 필드 생성자 (필요 시 가감 가능)
    public TravelTipVO(String id, String countryId, String entryInfo, String flightInfo, String timeDiff,
                       String paymentInfo, String transport, String foodInfo, String stayInfo,
                       String shopping, String weather, String safety, String etc) {
        this.id = id;
        this.countryId = countryId;
        this.entryInfo = entryInfo;
        this.flightInfo = flightInfo;
        this.timeDiff = timeDiff;
        this.paymentInfo = paymentInfo;
        this.transport = transport;
        this.foodInfo = foodInfo;
        this.stayInfo = stayInfo;
        this.shopping = shopping;
        this.weather = weather;
        this.safety = safety;
        this.etc = etc;
    }

    @Override
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @Override
    public String getName() {
        // 이름 대신 대표 정보를 리턴하는 예시(필요시 다른 메서드 추가)
        return "여행 Tip " + id;
    }

    public String getCountryId() { return countryId; }
    public void setCountryId(String countryId) { this.countryId = countryId; }

    public String getEntryInfo() { return entryInfo; }
    public void setEntryInfo(String entryInfo) { this.entryInfo = entryInfo; }

    public String getFlightInfo() { return flightInfo; }
    public void setFlightInfo(String flightInfo) { this.flightInfo = flightInfo; }

    public String getTimeDiff() { return timeDiff; }
    public void setTimeDiff(String timeDiff) { this.timeDiff = timeDiff; }

    public String getPaymentInfo() { return paymentInfo; }
    public void setPaymentInfo(String paymentInfo) { this.paymentInfo = paymentInfo; }

    public String getTransport() { return transport; }
    public void setTransport(String transport) { this.transport = transport; }

    public String getFoodInfo() { return foodInfo; }
    public void setFoodInfo(String foodInfo) { this.foodInfo = foodInfo; }

    public String getStayInfo() { return stayInfo; }
    public void setStayInfo(String stayInfo) { this.stayInfo = stayInfo; }

    public String getShopping() { return shopping; }
    public void setShopping(String shopping) { this.shopping = shopping; }

    public String getWeather() { return weather; }
    public void setWeather(String weather) { this.weather = weather; }

    public String getSafety() { return safety; }
    public void setSafety(String safety) { this.safety = safety; }

    public String getEtc() { return etc; }
    public void setEtc(String etc) { this.etc = etc; }

    // 여행 Tip 전체 요약 출력용 toString 오버라이드 (필요시 조정)
    @Override
    public String toString(){
        return 
                "\n입국 및 비자 정보: " + entryInfo +
                "\n비행 및 경로 정보: " + flightInfo +
                "\n시차: " + timeDiff +
                "\n결제 및 팁 문화: " + paymentInfo +
                "\n교통수단 및 주의사항: " + transport +
                "\n음식 및 물 관련: " + foodInfo +
                "\n숙소 주의점: " + stayInfo +
                "\n쇼핑/면세: " + shopping +
                "\n기후 및 계절 특성: " + weather +
                "\n치안 및 위험 요소: " + safety +
                "\n기타: " + etc + "\n";
    }
}