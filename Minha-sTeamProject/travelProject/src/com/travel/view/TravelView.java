package com.travel.view;

import com.travel.controller.TravelController;
import com.travel.controller.TravelControllerImplement;
import com.travel.model.vo.ContinentVO;
import com.travel.model.vo.CountryVO;
import com.travel.model.vo.RestaurantVO;
import com.travel.model.vo.TouristVO;
import com.travel.model.vo.TravelTipVO;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * <p>사용자 인터페이스(UI)를 담당하는 클래스입니다.</p>
 * <p>사용자로부터 입력을 받아 TravelController에 요청하고, 결과를 화면에 출력합니다.</p>
 */
public class TravelView {

    /** 사용자 입력을 받기 위한 Scanner 객체 */
    private Scanner sc = new Scanner(System.in);
    /** 비즈니스 로직 처리를 요청할 TravelController 객체 */
    private TravelController controller = new TravelControllerImplement();

    /**
     * 프로그램의 진입점(메인 메서드)입니다.
     * @param args 프로그램 실행 시 전달되는 명령행 인수
     */
    public static void main(String[] args) {
        new TravelView().displayMainMenu(); // TravelView 객체를 생성하여 메인 메뉴를 표시
    }

    /**
     * 프로그램의 메인 메뉴를 표시하고 대륙 선택을 처리합니다.
     * 아스키 아트를 화면에 출력하고, 0을 입력하면 프로그램이 종료됩니다.
     */
    public void displayMainMenu() {
        // --- 프로그램 시작 시 출력될 아스키 아트 ---
        System.out.println("⠄⠀⠀⠀⠀⠀⠄⠀⠠⠈⠀⠀⠈⠀⡀⠁⠀⡀⠁⠀⠀⠠⠀⠀⠄⠈⠀⠠⠀⠀⠄⠈⠀⠀⠁⢀⠀⠠⠀⠀⠂⠀⠀⢀⠀⠠⠀⠀⢀⠀⠁⠀⠀⠠⠀⠀⠂⠀⠀⢀⠀⠠⠀⠀⢀⠀⠁⠀⠀⠠⠀⠀⠂⠀⠀⢀⠀⠁⠀⠀");
        System.out.println("⠀⠀⠂⠀⠁⠀⡀⠀⡀⠀⢀⠀⠂⠀⠀⠀⡀⠀⣀⠀⠁⠀⡀⠄⠀⡀⣂⣀⣄⣄⡀⠠⠀⠐⡀⠀⠀⢀⠀⠂⠀⠐⠀⠀⠀⢀⠀⠂⠀⠀⠠⠀⠁⠀⠀⠂⠀⠐⠀⠀⠀⢀⠀⢂⣀⣠⣀⡀⣁⣀⣀⣂⣄⢐⠀⡀⠀⢀⠀⠁");
        System.out.println("⠈⠀⡀⠈⠀⠀⠀⠀⠒⣑⣄⣤⣀⢄⠁⠀⠀⡚⣀⣀⠢⡇⢤⣦⣳⡿⣯⣿⡽⣟⣶⡾⣞⣦⣭⣥⣴⣴⣦⣤⣴⣄⣀⣁⡠⡀⠀⠠⠀⠁⠀⠀⠠⠈⠀⢀⠈⠠⣐⢊⢄⢀⢈⢁⣊⣀⠁⠋⠻⢾⣯⡿⣾⣟⠏⠀⠠⠀⠀⠄");
        System.out.println("⠀⠄⠀⠀⡀⠈⢀⡤⣶⠟⣩⣯⢯⣭⣵⢾⣻⣟⣯⣿⣻⣟⣿⢾⣯⣿⣻⡾⣟⣿⣽⣟⣿⣽⡷⣿⢾⡷⣿⢾⡷⣟⢯⣿⡻⠝⠃⢀⠠⣴⢾⡾⣾⣾⢶⡶⣶⣶⣤⣮⢯⡶⣻⡐⠡⣽⡻⠀⠀⠱⣟⠏⠋⠈⢤⠤⠀⠀⢀⠀");
        System.out.println("⠠⠀⠀⢄⣄⠠⠐⠉⠟⢁⣰⣶⢷⡿⣾⣟⣯⣿⣽⣾⣻⣽⣟⣯⣷⢿⣽⣟⣿⣽⡾⣯⣷⣟⣿⣻⠟⠉⠉⠉⢠⢾⠈⢀⠈⠀⣀⠚⠏⠙⠉⠙⣻⡾⣟⣿⣻⡾⣷⢿⣉⠀⠀⣴⢿⣤⠄⠀⠀⠀⠂⠀⠠⠀⠠⠀⠀⠂⠀⠀");
        System.out.println("⠀⠀⠂⠁⢚⣢⣶⢿⣻⣯⣷⢿⣻⣟⣯⣿⣽⡾⣷⢿⣽⡷⣟⣿⢾⣿⣽⡾⣿⢾⣻⡿⣾⣯⣿⣽⢿⢡⠀⠀⡀⠁⠀⡀⠀⢀⠀⠀⡀⠠⠀⠀⣽⣟⣿⣽⣯⣿⣻⣟⣿⣯⡾⣟⡟⠝⠙⠀⠈⠀⠀⠂⠀⠀⠄⠀⠐⠀⠀⠈");
        System.out.println("⠀⠂⠀⢌⣤⡿⠙⠻⢍⠷⣿⢏⢁⡋⢻⡾⡁⢾⣟⣿⢷⣿⣻⣽⣟⣷⢿⣽⣟⣿⢯⣿⣻⡾⣗⠟⢁⡃⠀⡀⠀⠀⠂⠀⢀⠀⠀⡀⠀⠀⡀⣼⢿⣽⢷⡿⣾⢯⣿⣽⢷⡿⠝⠋⠁⠀⠀⠀⠠⠀⠁⠀⠈⠀⠀⠀⠄⠀⠁⢀");
        System.out.println("⠀⢀⠀⢛⣓⣡⣤⡄⠠⠀⠁⠘⢛⢻⣟⣿⣥⣜⣯⡿⣯⣷⢿⣽⣯⢿⣻⡷⣿⣽⢿⣽⠆⠉⡆⣀⣼⠀⠀⠀⠀⠂⠀⠄⠀⠀⠀⡀⠀⠂⠀⢿⣻⣽⣟⣿⣻⣟⣷⣟⠟⠀⠂⠀⠐⠀⠈⠀⢀⠀⠄⠀⠂⠀⠈⠀⠀⠀⠂⠀");
        System.out.println("⠀⣤⡶⣿⣽⣯⣷⢿⣶⢦⣷⣖⡦⢿⣯⣷⠻⡽⣷⢿⣻⡾⣟⣷⣟⣿⢯⣿⣻⡾⣟⣯⣗⠀⠀⠉⠀⠀⠀⠁⠀⠄⠀⠄⠀⠂⠀⠀⢀⠀⠠⠸⡹⣷⢿⡝⠑⠉⠑⡇⠀⠁⠀⠈⠀⠀⠠⠀⠀⠀⡀⠀⠄⠈⠀⠀⠁⠀⠄⠐");
        System.out.println("⡼⣷⢿⣻⣾⣳⣟⣿⣽⣟⣷⣟⣿⡌⢾⣯⣷⣴⡬⠉⠙⢻⣯⡷⣿⠝⢿⣽⣯⢿⠻⠙⠀⠀⠐⠀⠐⠀⠐⠀⢀⠠⠀⠀⠠⠀⠀⠁⠀⠀⠀⠀⠀⢽⣻⣄⣠⠔⠀⠀⠀⠄⠐⠀⢀⠈⠀⠀⠈⠀⠀⠀⢀⠀⠂⠀⠁⠀⡀⠀");
        System.out.println("⣾⣻⡿⣽⡾⣯⣿⣳⡿⣾⢷⣟⣷⢿⡈⡷⡟⠎⠀⠀⢀⠀⣷⡟⠁⠀⠘⢱⡿⣦⠀⠀⢸⠀⠀⠀⠄⠀⠠⠀⠀⠀⠀⠈⠀⠀⠁⠀⠈⠀⡀⠁⠀⠀⠈⠈⠛⢶⠂⠈⣀⣀⢀⠄⠀⠀⡀⠈⠀⡀⠐⠀⠀⠀⡀⠀⠄⠀⠀⠀");
        System.out.println("⠙⡷⣟⣯⣿⣻⡾⣯⡿⣯⣿⡽⣯⣿⣻⣴⡒⠀⠀⠈⠀⠀⠘⢂⠀⠀⠀⢐⠈⠋⠀⢀⠀⢆⠀⠁⠀⠀⠂⠀⠈⠀⠀⠂⠀⠐⠀⠀⠂⠀⠀⠠⠀⠐⠀⢀⠠⠀⠉⣱⣿⣽⣯⣷⢴⡀⠀⠀⡀⠀⠀⡀⠈⠀⠀⠀⡀⠀⠁⠀");
        System.out.println("⠀⠈⠉⠈⠀⠈⣿⢯⣿⣻⣞⣿⣽⢾⣯⠗⠁⠀⠁⢀⠀⠠⠀⠀⠄⠈⠀⢣⡫⠀⣤⢿⢀⠠⠀⠠⠈⠀⠀⠀⠂⠈⠀⢀⠈⠀⠀⠁⢀⠀⠁⢀⠀⠠⠀⠀⠀⠀⠰⣷⣟⣾⣗⣿⣻⣯⣤⢄⣀⠠⠀⠀⠠⠀⠁⠀⠀⠠⠀⠁");
        System.out.println("⠀⠀⠂⠀⠀⢀⠹⣟⣷⢿⣽⢾⣯⢿⡁⠀⠀⠀⠂⠀⠀⢀⠀⠂⠀⠀⠂⠀⠛⠄⡊⠃⠘⠄⠀⠑⢲⣦⢌⠀⠀⡀⠂⠀⠀⢀⠐⠀⠀⠀⠄⠀⠀⢀⠀⠂⠀⡀⠉⢳⣟⣷⣻⣽⢷⣻⣾⣻⣽⠂⠀⠐⠀⠀⢀⠀⠂⠀⠀⠐");
        System.out.println("⠀⠠⠀⠐⠀⠀⠀⣯⢿⣽⢾⣟⣾⣟⡆⠀⢈⠀⠀⠀⠂⠀⠀⡀⠀⠂⠀⠀⠄⠀⠁⠉⠁⠀⡀⣁⡀⣈⠈⠂⠀⠀⠀⠀⠄⠀⠀⡀⠈⠀⠀⠀⠄⠀⠀⡀⠀⢀⠀⠈⠹⢾⣻⣾⣻⣽⢾⣻⡆⠀⠁⠀⠀⠄⠀⠀⠠⠀⠁⢀");
        System.out.println("⠀⢀⠀⠐⠀⠈⠐⢿⡯⣟⣯⡿⣾⠝⠀⢜⡇⠀⠀⠁⠀⠀⠂⠀⠀⠄⠀⠁⠀⠀⠂⢀⣐⣼⢾⣻⢶⣼⣂⠀⠀⠂⠈⠀⠀⠀⠂⠀⠀⠄⠈⠀⠀⠀⠐⠀⠀⠠⠀⠀⠐⠀⢸⡽⣾⣻⢾⡻⠙⠀⡀⠂⠀⠁⠀⠀⠁⠀⠀⠄⠀");
        System.out.println("⠄⠀⠀⠄⠀⠠⠀⠹⣯⣿⣳⣟⡟⠀⡀⠛⢀⠀⠁⢀⠈⠀⢀⠀⠄⠀⠠⠀⠈⠀⠀⣟⣾⢯⡿⣯⡿⣞⣿⢦⠀⠄⠀⠄⠈⠀⠀⠀⠄⠀⠀⠄⠈⠀⠀⠀⠄⠀⠠⠀⠀⢰⣟⣯⣿⣻⠁⠠⠀⠀⠀⠀⠄⠈⠀⠠⠈⠀⠀⠀");
        System.out.println("⠀⠀⠂⠀⠐⠀⠀⠈⠑⠯⠷⢛⠀⢀⠀⠀⡀⠀⢀⠀⠀⢀⠀⠀⢀⠀⠄⠀⠐⠀⠀⣹⡽⠟⠝⠫⢿⡯⣟⡟⠀⠀⢀⠠⡖⠀⠈⠀⠀⠐⠀⢀⠀⠂⠈⠀⢀⠀⠂⠀⠈⠠⣟⣷⠳⠀⠀⡀⠠⠀⠈⠀⠀⠀⠂⠀⠀⢀⠀⠁");
        System.out.println("⠈⠀⡀⠀⠄⠀⠐⠀⠁⠀⡀⠀⢀⠀⠀⡀⠀⢀⠀⠀⠄⠀⠀⠄⠀⠀⡀⠀⠄⠀⠁⠀⠀⠀⠀⠀⠈⠋⢛⠁⠀⠡⠂⠁⠀⠀⠠⠀⠁⠀⠄⠀⠀⡀⠀⠄⠀⠀⡀⠀⠄⠀⢽⣗⡀⠠⠀⠀⠀⡀⠀⠂⠁⠀⠄⠐⠀⠀⠀⠄");
        System.out.println("⠀⠄⠀⠀⡀⠀⠂⠀⠐⠀⠀⠀⡀⠀⠀⡀⠀⢀⠀⠄⠀⠐⠀⠀⠐⠀⠀⠀⢀⠀⠂⠀⠐⠀⠀⠁⠀⠐⠈⠀⠀⠂⠈⠀⢀⠈⠀⠀⠐⠀⠀⠠⠀⠀⠀⡀⠠⠀⠀⠀⠀⠀⠙⠤⠀⠀⠐⠀⠀⠀⡀⠠⠀⠀⠀⠈⠀⠀");
        System.out.println("⢀⠀⠀⠄⠀⠀⠄⠐⠀⠀⠐⠀⠀⠀⠄⠀⢀⠀⠀⢀⠀⠠⠀⠈⠀⠀⠀⠂⠀⠀⡀⠀⠄⠀⠁⢀⠈⠀⠀⠀⠄⠀⠠⠀⠀⢀⠀⠈⠀⠀⠠⠀⠀⠐⠀⠀⠀⡀⠐⠀⠀⠀⠂⠁⠀⠀⠀⠄⠀⠐⠀⠀⠀⡀⠐⠀⠀⠀⠄⠁");
        System.out.println(); // 아스키 아트와 프로그램 제목 사이 간격 조절
        
        System.out.println("=== 여행 정보 프로그램 ===");

        while (true) {
            List<ContinentVO> continents = controller.showContinents(); // 모든 대륙 정보 조회
            if (continents.isEmpty()) {
                System.out.println("조회할 대륙 정보가 없습니다.");
                break; // 대륙 정보가 없으면 프로그램 종료
            }

            System.out.println("\n--- 1. 대륙 선택 ---");
            // 대륙 목록을 번호와 함께 출력
            for (int i = 0; i < continents.size(); i++) {
                System.out.printf("%d. %s%n", (i + 1), continents.get(i).getName());
            }
            System.out.println("0. 프로그램 종료");
            System.out.print("대륙을 선택하세요 (번호): ");

            int continentChoice = -1;
            try {
                continentChoice = Integer.parseInt(sc.nextLine()); // 사용자 입력 받기
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                continue; // 잘못된 입력 시 다시 메뉴 표시
            }

            if (continentChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break; // 0 입력 시 프로그램 종료
            }

            // 선택된 번호가 유효한 범위 내에 있는지 확인
            if (continentChoice < 1 || continentChoice > continents.size()) {
                System.out.println("잘못된 대륙 번호입니다. 다시 입력해주세요.");
                continue;
            }

            String selectedContinentId = continents.get(continentChoice - 1).getId(); // 선택된 대륙의 ID 가져오기

            // --- 선택된 대륙에 맞는 아스키 아트 출력 ---
            displayContinentAsciiArt(selectedContinentId);
            // --- 여기까지 추가 ---

            displayCountryMenu(selectedContinentId); // 국가 선택 메뉴로 이동
        }
    }

    /**
     * 특정 대륙에 해당하는 국가 목록을 표시하고 국가 선택을 처리합니다.
     * 0을 입력하면 이전 메뉴(대륙 선택)로 돌아갑니다.
     * @param continentId 선택된 대륙의 ID
     */
    public void displayCountryMenu(String continentId) {
        while (true) {
            List<CountryVO> countries = controller.showCountries(continentId); // 해당 대륙의 국가 정보 조회
            if (countries.isEmpty()) {
                System.out.println("조회할 국가 정보가 없습니다. 이전 메뉴로 돌아갑니다.");
                break; // 국가 정보가 없으면 이전 메뉴로 돌아감
            }

            System.out.println("\n--- 2. 나라 선택 ---");
            // 국가 목록을 번호와 함께 출력
            for (int i = 0; i < countries.size(); i++) {
                System.out.println((i + 1) + ". " + countries.get(i).getName());
            }
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.print("나라를 선택하세요 (번호): ");

            int countryChoice = -1;
            try {
                countryChoice = Integer.parseInt(sc.nextLine()); // 사용자 입력 받기
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                continue; // 잘못된 입력 시 다시 메뉴 표시
            }

            if (countryChoice == 0) {
                break; // 0 입력 시 이전 메뉴로 돌아감
            }

            // 선택된 번호가 유효한 범위 내에 있는지 확인
            if (countryChoice < 1 || countryChoice > countries.size()) {
                System.out.println("잘못된 국가 번호입니다. 다시 입력해주세요.");
                continue;
            }

            String selectedCountryId = countries.get(countryChoice - 1).getId(); // 선택된 국가의 ID 가져오기
            displayInfoTypeMenu(selectedCountryId); // 정보 유형 선택 메뉴로 이동
        }
    }

    /**
     * 특정 국가에 대한 정보 유형 (맛집, 관광지, 여행 Tip)을 선택하는 메뉴를 표시하고 처리합니다.
     * 0을 입력하면 이전 메뉴(국가 선택)로 돌아갑니다.
     * @param countryId 선택된 국가의 ID
     */
    public void displayInfoTypeMenu(String countryId) {
        String countryName = getCountryNameById(countryId); // 선택된 국가의 이름 가져오기

        while (true) {
            System.out.println("\n--- 3. 컨셉 선택 (" + (countryName != null ? countryName : "선택된 나라") + ") ---");
            System.out.println("1. 맛집 정보");
            System.out.println("2. 관광지 정보");
            System.out.println("3. 여행 Tip"); // 여행 Tip 메뉴 추가
            System.out.println("4. 종료");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.print("원하는 정보 타입을 선택하세요 (번호): ");

            int typeChoice = -1;
            try {
                typeChoice = Integer.parseInt(sc.nextLine()); // 사용자 입력 받기
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                continue; // 잘못된 입력 시 다시 메뉴 표시
            }

            if (typeChoice == 0) {
                break; // 0 입력 시 이전 메뉴로 돌아감
            }
            
            if (typeChoice == 4) {
            	System.out.println("시스템을 종료합니다");
            	System.exit(0);
                break; // 0 입력 시 이전 메뉴로 돌아감
            }
            // 선택된 정보 유형에 따라 해당 메서드 호출
            switch (typeChoice) {
                case 1:
                    displayRestaurants(countryId); // 맛집 정보 표시
                    break;
                case 2:
                    displayTourists(countryId); // 관광지 정보 표시
                    break;
                case 3:
                    displayTravelTips(countryId); // 여행 Tip 정보 표시
                    break;
                case 4:
                	System.exit(0);
                default:
                    System.out.println("잘못된 정보 타입입니다. 다시 선택해주세요.");
            }
        }
    }

    /**
     * 특정 국가의 맛집 정보 목록을 표시합니다.
     * @param countryId 맛집을 조회할 국가의 ID
     */
    public void displayRestaurants(String countryId) {
        String countryName = getCountryNameById(countryId);
        System.out.println("\n--- " + (countryName != null ? countryName : "") + " 맛집 정보 ---");
        List<RestaurantVO> restaurants = controller.showRestaurants(countryId); // 해당 국가의 맛집 정보 조회
        if (restaurants.isEmpty()) {
            System.out.println("조회할 맛집 정보가 없습니다.");
        } else {
            for (RestaurantVO restaurant : restaurants) {
                System.out.println(restaurant); // 각 맛집 정보 출력
            }
        }
        System.out.println("-------------------------");
    }

    /**
     * 특정 국가의 관광지 정보 목록을 표시합니다.
     * 이 메서드는 URL 자동 열기 기능이 제거된 버전입니다.
     * @param countryId 관광지를 조회할 국가의 ID
     */
    public void displayTourists(String countryId) {
        String countryName = getCountryNameById(countryId);
        System.out.println("\n--- " + (countryName != null ? countryName : "") + " 관광지 정보 ---");
        List<TouristVO> tourists = controller.showTourists(countryId); // 해당 국가의 관광지 정보 조회
        if (tourists.isEmpty()) {
            System.out.println("조회할 관광지 정보가 없습니다.");
        } else {
            for (TouristVO tourist : tourists) {
                System.out.println(tourist); // 각 관광지 정보 출력
            }
        }
        System.out.println("-------------------------");
    }

    /**
     * 특정 국가의 여행 팁 정보 목록을 표시합니다.
     * @param countryId 여행 팁을 조회할 국가의 ID
     */
    public void displayTravelTips(String countryId) {
        String countryName = getCountryNameById(countryId);
        System.out.println("\n--- " + (countryName != null ? countryName : "") + " 여행 Tip ---");
        List<TravelTipVO> tips = controller.showTravelTips(countryId); // 해당 국가의 여행 팁 정보 조회
        if (tips.isEmpty()) {
            System.out.println("조회할 여행 Tip이 없습니다.");
        } else {
            for (TravelTipVO tip : tips) {
                System.out.println(tip); // 각 여행 팁 정보 출력
            }
        }
        System.out.println("-------------------------");
    }

    /**
     * 주어진 국가 ID에 해당하는 국가 이름을 반환합니다.
     * 이 메서드는 모든 대륙을 조회하여 국가 이름을 찾으므로, 비효율적일 수 있습니다.
     * 향후 DAO/Controller 계층에 국가 ID로 국가 정보를 직접 조회하는 메서드를 추가하여 개선할 수 있습니다.
     * @param countryId 국가 이름을 찾을 국가의 ID
     * @return 국가 이름 (찾을 수 없으면 null)
     */
    private String getCountryNameById(String countryId) {
        List<ContinentVO> allContinents = controller.showContinents(); // 모든 대륙 조회
        for (ContinentVO continent : allContinents) { // 각 대륙별로
            // 해당 대륙의 국가 목록에서 countryId와 일치하는 국가를 찾아 이름 반환
            Optional<String> countryName = controller.showCountries(continent.getId()).stream()
                    .filter(c -> c.getId().equals(countryId))
                    .map(CountryVO::getName)
                    .findFirst();
            if (countryName.isPresent()) {
                return countryName.get();
            }
        }
        return null; // 찾을 수 없으면 null 반환
    }

    /**
     * 선택된 대륙의 ID에 따라 해당하는 아스키 아트를 출력합니다.
     * @param continentId 선택된 대륙의 ID (예: "SA" for 남아메리카)
     */
    private void displayContinentAsciiArt(String continentId) {
        switch (continentId) {
            case "SA":
                System.out.println("\n--- 남아메리카 ---");
                printSouthAmericaAsciiArt();
                break;
            case "ASIA":
                System.out.println("\n--- 아시아 ---");
                printAsiaAsciiArt();
                break;
            case "AF":
                System.out.println("\n--- 아프리카 ---");
                printAfricaAsciiArt();
                break;
            case "OCEAN":
                System.out.println("\n--- 오세아니아 ---");
                printOceaniaAsciiArt();
                break;
            case "EU":
                System.out.println("\n--- 유럽 ---");
                printEuropeAsciiArt();
                break;
            case "NA": // ★여기에 북아메리카 대륙 케이스 추가★
                System.out.println("\n--- 북아메리카 ---");
                printNorthAmericaAsciiArt();
                break;
            // 다른 대륙에 대한 아스키 아트는 여기에 'case "대륙ID": printOtherContinentAsciiArt(); break;' 형태로 계속 추가할 수 있습니다.
            default:
                // 해당 대륙에 맞는 아스키 아트가 없는 경우 처리 (예: 아무것도 출력 안 함)
                break;
        }
        System.out.println("\n"); // 아스키 아트 후 여백
    }

    /**
     * 남아메리카를 나타내는 아스키 아트를 출력합니다.
     */
    private void printSouthAmericaAsciiArt() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⡿⢶⣿⣷⣶⣶⣵⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣀⣄⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢐⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣵⣠⣰⣷⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠘⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⢘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠉⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠁⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣍⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣗⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⢿⣿⣿⣿⣿⡦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⡿⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢮⣿⣿⣿⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠥⢿⠖⠂");
    }

    /**
     * 아시아를 나타내는 아스키 아트를 출력합니다.
     */
    private void printAsiaAsciiArt() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣶⡆⡀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣨⣿⣿⣿⣿⣿⣿⣿⣾⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢴⣶⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⢠⣾⣶⣦⣤⣦⣤⣬⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣦⣤⡀⠀⠀⢀⣠⣤⡀⠀⣾⣿⣦⣀⣀⣀⠀⠀⠀⣀⡀⠀⢠⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⢽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⣀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠘⠉⣉⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⣰⣷⠴⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⡟⠁⠀⠀⠀⠀⢈⣆⠉⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣹⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⡉⡀⠋⠈⢿⣧⡀⠀⠀⠀⠀⢀⣰⡟⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠁⠀⢀⣿⠇⠀⣠⣠⣸⣾⠿⠁⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠂⠐⣾⠑⠃⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠈⠀⠻⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⣴⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⢹⣿⣿⣿⣿⣿⣿⣿⠟⠉⠉⠘⢿⣿⣿⣿⣿⣿⣿⣿⠟⢉⣏⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠈⣿⠿⣿⣿⣿⣿⣷⣄⠈⠁⠀⠀⠀⠀⠀⣴⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣯⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⢿⡿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⢻⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⡇⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⢸⠁⠈⠻⣿⠿⠋⠀⠀⠀⠀⠀⡠⠈⢢⢝⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠃⢸⡧⠀⠀⠀⠀⠀⠀⠠⠀⠀⠙⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⣈⠀⠀⠔⢲⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠶⣆⡘⣿⡆⠀⠀⠄⠀⣀⣴⣾⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠙⢿⣾⡍⠀⠀⢰⣶⣿⣿⣿⡟⠂⠔⠔⠔⠀⢸⠀⡀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠈⢿⣿⣶⠠⠀⠹⠻⠿⡿⠀⠸⡿⣍⠀⠐⠄⠤⠌⢻⢥⣬⣶⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠫⣤⣄⣠⣀⠀⠀⠀⠈⠂⠑⠀⠀⠀⠀⢀⠀⠔⠈⢙⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠁⠊⠠⠕⠈⠬⠒⠈⠀⠀⠀⠀⠀⠈⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    /**
     * 아프리카를 나타내는 아스키 아트를 출력합니다.
     */
    private void printAfricaAsciiArt() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢠⣠⣀⣀⣤⣦⣶⣶⣶⣾⣶⣿⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⢠⣶⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣤⣄⡀⠀⠀⢀⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⢀⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣦⣾⣿⣿⣿⣿⣷⣶⣿⣷⢷⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⢈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⢴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠸⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⡀⣀⡠⠀⠀");
        System.out.println("⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⠇⠀⠀");
        System.out.println("⠀⠀⠀⠀⠉⠻⢿⣿⣿⣿⣿⣿⡿⠟⠟⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠩⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠁⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠆⠀⠄⠀⠀⠀⡀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⢀⣲⣿⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢐⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠀⠀⠠⣷⣿⣿⡗⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⠁⠀⠀⠀⠀⢀⣿⣿⡿⠁⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⢹⣿⣿⡃⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡋⠁⠀⠀⠀⠀⠀⠈⠙⠉⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠙⠉⠉⠁⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    /**
     * 오세아니아를 나타내는 아스키 아트를 출력합니다.
     */
    private void printOceaniaAsciiArt() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣶⣤⣀⠀⠀⠀⢀⡠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⢿⣶⠀⠒⠊⠀⠀⠂⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠛⠀⠀⠙⠷⢆⠄⠐⠀⠀⠀⠀⠡⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢐⣠⣦⣄⡄⠀⠀⠀⢴⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⣦⣐⣿⣿⣿⣿⡁⠀⠀⠀⣿⣧⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣦⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣴⣿⣿⣿⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠠⠆⠁⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⢀⣠⣤⣦⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢄⠠⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⣺⣿⣿⣿⢿⡿⠋⠉⠁⠀⠀⠀⠉⢻⡿⢻⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠪⢻⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⡄⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢿⡿⠿⣿⠛⠓⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣶⣤⠄⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠙⣿⠃⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡿⠂⠁⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⡟⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    /**
     * 유럽을 나타내는 아스키 아트를 출력합니다.
     */
    private void printEuropeAsciiArt() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣶⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣀⠀⠀⠀⠀⠀⠀⠠⢀⣤⣾⣿⡿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⣿⣷⣷⣶⣤⣤⣼⣆⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⢏⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⣿⣿⣿⣿⣿⠋⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣷⡄⠛⢿⣻⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣆⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣀⢐⣿⡋⠀⠀⠀⠈⢋⢉⢺⣿⣿⠏⠀⢠⣘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣴⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣵⡿⠃⡀⣿⡆⠀⠀⠀⠀⣺⠏⡼⠟⠛⠁⠀⠘⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠛⠋⠁⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣨⣻⣿⡿⠀⣠⣶⣶⣾⣷⣾⣶⣶⣿⣦⣤⣬⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣠⣤⣤⣵⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣥⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⢠⣴⣤⣤⡀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠻⣿⣛⡉⠿⣹⣿⣿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⢿⢿⣿⠻⢿⣿⣟⠹⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠘⠁⠀⠀⠙⠙⢿⣿⣿⣿⣿⣷⡤⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⡿⠟⠛⠀⠀⠀⠰⠄⢻⣿⣷⣈⠛⢿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠈⠈⠛⠿⠿⠛⠏⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠉⠻⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⣿⠀⠀⠈⠻⢿⡾⡄⢾⣿⡿⠿⠙⠛⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢤⣠⠸⠃⠀⠈⢙⣿⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠉⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    /**
     * 북아메리카를 나타내는 아스키 아트를 출력합니다.
     */
    private void printNorthAmericaAsciiArt() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⣸⣖⣄⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⢀⣝⣿⣿⣿⣿⣿⣷⣧⣆⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢴⡽⣿⠵⣿⣿⣿⣿⣿⣿⣿⣿⣷⣽⡖⣂⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠂⠀⣴⡄⢼⣿⣾⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠄⣄⢘⢷⢽⡯⠰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⢠⢀⣦⣆⣸⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⢀⡐⠽⣌⡄⣄⠵⡠⢛⣓⠀⠁⠁⠈⠙⠿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⢀⣫⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⡀⠀⠀⢰⡿⣷⣈⢁⡅⢨⢘⡜⣩⢡⢄⡀⠀⠀⠀⠀⠁⠏⢿⣿⣿⣿⡯⠁⠀⠀⠀⠀");
        System.out.println("⠁⠂⠢⠠⣀⣀⣸⣿⢿⢿⢿⣿⣽⣾⣿⣿⣿⣿⣿⣿⣶⣄⡀⣻⣿⣿⡆⠹⢫⡄⢷⣿⣿⢿⣾⣦⡀⠀⠀⠀⠙⣿⣿⣿⣿⣧⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠈⠸⠘⠀⠋⠋⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣷⣙⡛⣝⡛⠰⡍⣷⣄⢸⣆⠀⡭⢻⣿⡷⣖⠀⠀⠀⠑⠻⢿⠿⠧⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⡿⣟⡉⠀⣠⠽⣿⣷⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⢽⣿⣿⣿⣿⣿⣿⡿⡟⢿⢿⣿⣿⣿⣿⣿⣿⠛⠘⢏⠃⣐⣠⣌⡉⡁⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡳⣿⣿⣿⣿⣿⣿⣿⣾⣾⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⢻⣿⣿⣧⣠⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⢸⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⣿⣷⣳⣦⡀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣄⣄⡀⢡⣾⣿⣿⣿⣿⣿⣿⣿⣿⠏⢕⣄⡄⡀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⣻⣿⣿⣿⣿⣿⢟⡩⠅⠀⠹⠟⠋⠂");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣷⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣷⣿⣧⡠⣠⠆⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⡉⠛⣿⣿⣿⣿⣿⣿⣾⠏⡽⠊⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⡷⢫⣧⠉⣝⡿⢟⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⢸⣿⡷⣫⣽⣿⣿⣟⠋⠁⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⡿⡅⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⣷⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠻⠻⠷⠍⠉⠉⠋⠻⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣇⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠁⠀⠀⠀⠀⠀⠀⠀⠀⠻⡷⠐⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠤⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣁⠀⠁⠀⠁⠀⢀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⣀⣠⡀⠀⠊⠅⠉⠙⠹⢶⠦⠆⢡⣴⣴⠤⠀⠤");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⢿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⢀⢠⣿⣿⠁⠀⠀⠀⠀⠀⠀⠴⠀⠀⠂⠉⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠿⢿⣿⡿⣿⣿⣿⣿⣿⣿⣿⡗⢀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⠿⣿⢿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠙⠷⢶⡋⠩⠇⠀⠀");
    }
}