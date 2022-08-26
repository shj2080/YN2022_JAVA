package ifswitch;

import java.util.Scanner;

public class CafeOrderPractice {

	public static void main(String[] args) {
		/*
		 * 6/30 테스트 연습용
		 * 주문안함, NoOrder(대소문자 구분X) 시 바로 나가기, stop 시 영수증 출력
		 * Americano(아메리카노), 카페라떼, 카푸치노
		 */
		
		//------ 변수 선언 구간 ------/
		String order = null;
		
				
		int cupAmericano = 0;			// 아메리카노 잔수
		int cupCafelatte = 0;			// 카페라떼 잔수
		int cupCafuchino = 0;			// 카푸치노 잔수
		
		int totalCupAmericano = 0;		// 아메리카노 총 잔수
		int totalCupCafelatte = 0;		// 카페라떼 총 잔수
		int totalCupCafuchino = 0;		// 카푸치노 총 잔수
				
		final int priceAmericano = 4000, priceCafelatte = 3000, priceCafuchino = 3500; //커피 가격 설정 (상수)
		
		int cupTotal = 0;			//전체 잔수
		int priceTotal = 0;		// 가격 합계
		
		Scanner sc = new Scanner(System.in);
		//------ 변수 선언 구간 ------/
		
		do {
			System.out.println("============[메뉴판]============\n" +
							   "아메리카노(Americano)\t\t" + priceAmericano + "원" +
							   "카페라떼\t\t" + priceCafelatte + "원" +
							   "카푸치노\t\t" + priceCafuchino + "원" +
							   "주문종료\t\tSTOP" + 
							   "주문안함\t\tNoOrder");
			System.out.println("==============================");
			System.out.print("주문하실 메뉴를 입력해주세요 > ");
			order = sc.next().trim().toLowerCase();		//문자열을 입력 받고 앞뒤공백을 제거 후 영어는 모두 소문자로 변환
			
			if(order.equalsIgnoreCase("NoOrder") || order.equals("주문안함")) {
				break;
			}
			
			System.out.print("몇 잔 주문하시겠습니까? > ");
			
			switch(order) {
			case "americano":
			case "아메리카노":
				cupAmericano = sc.nextInt();
				
				if(cupAmericano > 0) {
					System.out.println(order + " " + cupAmericano + "잔 주문하였습니다.");
					
					totalCupAmericano += cupAmericano;		//전체 잔수 더하기
					
					cupTotal += cupAmericano;
					priceTotal += (cupAmericano * priceAmericano);
					
				}else {
					System.out.println("0보다 큰 수를 입력해주세요.");
				}
				
				break;
			case "카페라떼":
				
				break;
			case "카푸치노":
				
				break;
			case "stop":
				if(cupTotal > 0) {
					System.out.println("그만 주문하겠습니다.");
				} else {
					
				}
				
				
				break;
				default:
					System.out.println("없는 메뉴입니다.");
			}
			
		} while(!order.equalsIgnoreCase("stop"));
		
		if(!(order.equalsIgnoreCase("NoOrder") || order.equals("주문안함")) && priceTotal > 0) {
			String result = "";
			
			System.out.println("--------------------[영수증]--------------------");
			if(totalCupAmericano >= 1) {
				result += "아메리카노 " + totalCupAmericano + "잔에 " + (totalCupAmericano * priceAmericano) + "원, ";
			}
			if(totalCupCafelatte >= 1) {
				result += "카페라떼 " + totalCupAmericano + "잔에 " + (totalCupCafelatte * priceCafelatte) + "원, ";
			}
			if(totalCupCafuchino >= 1) {
				result += "카푸치노 " + totalCupCafuchino + "잔에 " + (totalCupCafuchino * priceCafuchino) + "원, ";
			}
			
			if(result.length() > 0) System.out.println(result.substring(0, result.length()-2));
			
			System.out.println("총 " + cupTotal + "잔, " + priceTotal + "원 입니다.");
			System.out.println("--------------------[영수증]--------------------");
		}
		
		sc.close();
	}

}
