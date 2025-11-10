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

            // --- ★여기 수정★ 대륙 선택 프레임 적용 시작 ---
            printAsciiFrameTop("대륙 선택");
            System.out.println("|　                                      				|"); // 빈 줄
            System.out.println("|　             원하는 대륙의 번호를 입력해주세요. 				|");
            System.out.println("|　                                      				|"); // 빈 줄
            for (int i = 0; i < continents.size(); i++) {
                // 각 대륙 목록을 프레임 내에 출력 (총 길이 65, 앞뒤 | 및 띄어쓰기 4 포함)
                String option = String.format("%d. %s", (i + 1), continents.get(i).getName());
                // UTF-8 환경에서 한글은 2칸 차지하므로, 패딩 계산 시 고려
                int paddingLeft = 4; // '|   '
                int paddingRight = 65 - paddingLeft - option.length(); // '|' 포함
                if (continents.get(i).getName().matches(".*[가-힣]+.*")) { // 한글 포함 시
                     // 대략적인 한글 1글자 = 영어/숫자 2글자 너비로 간주
                     // 정확한 계산은 어려우므로 여백으로 조절
                    paddingRight -= (int)(continents.get(i).getName().length() * 0.5);
                }
                System.out.printf("|%s%s%s	|\n", " ".repeat(paddingLeft - 1), option, " ".repeat(paddingRight));
            }
            System.out.println("|　0. 프로그램 종료                                                		|");
            printAsciiFrameBottom();
            // --- ★여기 수정★ 대륙 선택 프레임 적용 끝 ---
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

            // --- ★여기 수정★ 나라 선택 프레임 적용 시작 ---
            printAsciiFrameTop("나라 선택");
            System.out.println("|　                                                                	|"); // 빈 줄
            System.out.println("|　             원하는 국가의 번호를 입력해주세요.                 　　　  		|");
            System.out.println("|　                                                                	|"); // 빈 줄
            for (int i = 0; i < countries.size(); i++) {
                String option = String.format("%d. %s", (i + 1), countries.get(i).getName());
                int paddingLeft = 4;
                int paddingRight = 65 - paddingLeft - option.length();
                if (countries.get(i).getName().matches(".*[가-힣]+.*")) {
                    paddingRight -= (int)(countries.get(i).getName().length() * 0.5);
                }
                System.out.printf("|%s%s%s	|\n", " ".repeat(paddingLeft - 1), option, " ".repeat(paddingRight));
            }
            System.out.println("|　0. 이전 메뉴로 돌아가기                                           		|");
            printAsciiFrameBottom();
            // --- ★여기 수정★ 나라 선택 프레임 적용 끝 ---
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
            // --- ★여기 수정★ 컨셉 선택 프레임 적용 시작 ---
            printInfoTypeAsciiFrame(countryName); // 새로운 메서드를 통해 프레임과 선택지 출력
            // --- ★여기 수정★ 컨셉 선택 프레임 적용 끝 ---
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
                	break;
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
            case "NA":
                System.out.println("\n--- 북아메리카 ---");
                printNorthAmericaAsciiArt();
                break;
            default:
                // 해당 대륙에 맞는 아스키 아트가 없는 경우 처리 (예: 아무것도 출력 안 함)
                break;
        }
        System.out.println("\n"); // 아스키 아트 후 여백
    }

    // --- 아스키 아트 프레임 헬퍼 메서드 시작 ---

    /**
     * 아스키 아트 프레임의 상단 부분(알림 제목)을 출력합니다.
     * @param title 프레임 안에 표시될 메뉴 제목 (예: "대륙 선택", "나라 선택")
     */
    private void printAsciiFrameTop(String title) {
        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        // 가운데 정렬을 위해 남은 공간 계산. 총 가로 38글자.
        String alertText = "알림 - " + title;
        int totalWidth = 65; // 프레임 내부 총 너비 (한글 2칸, 영문 1칸)
        int textLength = alertText.length();
        if (alertText.matches(".*[가-힣]+.*")) { // 한글 포함 시
            textLength += (int)(alertText.length() * 0.5); // 대략적인 한글 너비 보정
        }
        
        int rightAlignFixedPartLength = "[－][口][×]".length(); // [－][口][×] 부분의 길이
        int paddingBetweenAlertAndFixed = totalWidth - textLength - rightAlignFixedPartLength - 3; // '|' + ' ' + ' ' + '|'

        System.out.printf("|　%s%s%s 		|%n", alertText, " ".repeat(Math.max(0, paddingBetweenAlertAndFixed)), "[－][口][×]");
        System.out.println("|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|");
    }

    /**
     * 아스키 아트 프레임의 하단 부분(`원하는 정보를 선택해주세요.` 메시지와 하단 경계)을 출력합니다.
     */
    private void printAsciiFrameBottom() {
        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
    }

    /**
     * 컨셉 선택 메뉴 (맛집, 관광지, 여행 팁)를 아스키 아트 프레임 안에 출력합니다.
     * @param countryName 선택된 국가의 이름
     */
    private void printInfoTypeAsciiFrame(String countryName) {
        printAsciiFrameTop("컨셉 선택 (" + (countryName != null ? countryName : "선택된 나라") + ")");
        	System.out.println("|　 원하는 정보 타입을 선택해주세요.　　                                  					|"); // 24글자 + 32칸 공백. 총 64칸
        	System.out.println("|　                                                            					|");
        	System.out.println("|　　  ＿＿＿＿＿＿　　　   ＿＿＿＿＿＿　　　　  ＿＿＿＿＿＿　        	 ＿＿＿＿＿＿       			|");
        	System.out.println("| 　  ｜1. 맛집 ｜　　　 ｜2. 관광지｜　 　  ｜3. 여행 팁｜  		｜4. 종료  ｜				|");
	        System.out.println("|　　  ￣￣￣￣￣￣　　　   ￣￣￣￣￣￣   　　  ￣￣￣￣￣￣　    	 ￣￣￣￣￣￣				|");
	        System.out.println("|　                                                             					|"); // 빈 줄
	        System.out.println("|　	0. 이전 메뉴로 돌아가기                                           				|");
        printAsciiFrameBottom();
    }
    // --- 아스키 아트 프레임 헬퍼 메서드 끝 ---

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
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\t⢀⢮⣿⣿⣿⣦⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
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
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⡟⠁⠀⠀⠀⠀⢈⣆⠉⠀⠀⠀⠀⠀⠀⠀");
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
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\t\t\t⢀⣴⣾⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\t\t\t⠙⡟⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
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