package ifswitch;

import java.util.Scanner;

public class CafeOrder {

	public static void main(String[] args) {
		//[과제-1] 전체적인 프로그램 흐름 참고하여 작성하기
		//별도의 과제참고자료 참조
		//주문안함, NoOrder(대소문자 구분X) 시 바로 나가기, stop 시 영수증 출력
		//주문받은 커피들을 저장하는 변수 필요
		
		String order = null; //주문 입력받는 변수
		int price_result = 0;		//주문커피 총 가격(0으로 초기화)
		int cup_result = 0;			//주문커피 잔수 합계 (0으로 초기화)
		
		final int americano_price = 3000, cafelatte_price = 4000, cappuccino_price = 3500; //커피 가격 상수
		
		int americano_cup = 0, cafelatte_cup = 0, cappuccino_cup = 0;	//주문한 커피잔수
		int americano_sum = 0, cafelatte_sum = 0, cappuccino_sum = 0;   //각 커피의 구매가격 합계가 담길 변수
		//boolean orderFlag = true;
		
		Scanner sc = new Scanner(System.in);		//입력 받기 위한 scanner 객체 생성
		
		System.out.println("--do~while문 카페 주문 처리 시작-----------");
		do {
			System.out.println("메뉴(Americano:3000원, 카페라떼:4000원, 카푸치노:3500원)중에서 주문");
			System.out.print("단, 주문안함(=NoOrder) 주문그만하고 싶으면 stop입력)>");
			order = sc.next().trim();
			
			if(order.equalsIgnoreCase("NoOrder") || order.equals("주문안함")) {
				break;
			} else if(order.equalsIgnoreCase("stop")) {	//stop 입력 시
				System.out.println("그만 주문하겠습니다.");
								
				//주문내역으로 변수 설정
				americano_sum = americano_cup * americano_price;			//아메리카노 구매가격 합계
				cafelatte_sum = cafelatte_cup * cafelatte_price;			//카페라떼 구매가격 합계
				cappuccino_sum = cappuccino_cup * cappuccino_price;			//카푸치노 구매가격 합계
				
				cup_result = americano_cup + cafelatte_cup + cappuccino_cup;	// 주문한 커피잔수 합계
				price_result = americano_sum + cafelatte_sum + cappuccino_sum;	// 주문한 커피 가격 합계
				
				break;		//do~while문 빠져나감
			}
			
			switch(order.toLowerCase()) {		//String 객체 내 값을 소문자로 모두 변환! (대소문자 구분 안함)
				case "americano":
					americano_cup++;
					break;
				case "카페라떼":
					cafelatte_cup++;
					break;
				case "카푸치노":
					cappuccino_cup++;
					break;
				default:
					System.out.println("없는 메뉴입니다.");
					continue;
			}
			System.out.println(order + "를 주문하셨습니다.");
			
		} while(true);
		
		String result = "";  	//영수증 출력 스트링 객체
		if (!(order.equalsIgnoreCase("NoOrder") || order.equals("주문안함")) && price_result > 0) {		//주문내역이 있는 경우 영수증 출력
			System.out.println("---------영수증------------------------------");
			//,를 처리할 방법
			if (americano_cup >= 1) {
				result += "Americano " + americano_cup + "잔에 " + americano_sum + "원, ";
			}
			if (cafelatte_cup >= 1) {
				result += "카페라떼 " + cafelatte_cup + "잔에 " + cafelatte_sum + "원, ";
			}
			if (cappuccino_cup >= 1) {
				result += "카푸치노 " + cappuccino_cup + "잔에 " + cappuccino_sum + "원, ";
			}
			
			if(result.length() > 0) System.out.println(result.substring(0, result.length()-2)); // substring 활용
			
			//System.out.println();	//커서를 아래로 내림
			System.out.println("총 " + cup_result + "잔, 총 가격 = " + price_result);
			System.out.println("---------영수증------------------------------");
		}
		
		System.out.println("--do~while문 카페 주문 처리 끝-------");
		
		sc.close(); // 스캐너 닫음
	}
}
