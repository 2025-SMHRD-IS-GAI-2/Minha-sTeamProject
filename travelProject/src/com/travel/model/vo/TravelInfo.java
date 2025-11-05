package com.travel.model.vo;

/**
 * <p>여행 정보 객체들의 공통적인 인터페이스입니다.</p>
 * <p>모든 VO 클래스는 이 인터페이스를 구현하여 고유 ID와 이름을 가질 수 있도록 합니다.</p>
 */
public interface TravelInfo {
    /**
     * 객체의 고유 ID를 반환합니다.
     * @return String 형태의 ID
     */
    String getId();

    /**
     * 객체의 대표 이름을 반환합니다.
     * @return String 형태의 이름
     */
    String getName();
}