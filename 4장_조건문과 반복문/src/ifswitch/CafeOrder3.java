package ifswitch;

import java.util.Scanner;

public class CafeOrder3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean isNextOrder = true;
		boolean hadOrdered = false;		//초기화 이유:주문 후 취소할 수 있으므로...
		
		final int amePrice = 3000, lattePrice = 4000, cafuPrice = 3500;
		
		int ameN = 0, latteN = 0, cafuN = 0;		//각 메뉴 주문횟수
		int amePay = 0, lattePay = 0, cafuPay = 0; //메뉴 별 지불할 금액
				
		int orderN = 0;		//주문 시 주문 횟수
		
		int totalorderN = 0;		//총 주문 횟수
		int totalpay = 0;		// 지불 해야할 금액 합계
				
		boolean isFirst = true;
cafe:	do {
			// -------------주문 확인
			System.out.println("메뉴(Americano:3000원, 카페라떼:4000원, 카푸치노:3500원)중에서 주문");
			if (isFirst) {
				System.out.println("주문하시겠습니까? 주문을 하지 않으실거면 noorder(=주문안함)를 입력해주세요");
			} else {
				System.out.println("더 주문하시겠습니까? 추가 주문이 없으시면 stop을 입력해주세요");
				System.out.println("모든 주문을 취소하실려면 noorder를 입력해주세요");
			}
			String order = sc.next().trim().toLowerCase();
			if (order.equalsIgnoreCase("noorder") || order.equals("주문안함")) {
				hadOrdered = false;
				break;
			}
			// --------------주문 확인
			boolean many = true;
			
			do {
				switch (order) {
				case "stop": //[다른점]주문하지 않고 바로 stop으로도 끝나도록 유도함
					isNextOrder = false;
					many = false;
					//break; //가장 가까운 반복문을 빠져 나감(do~while)
					
					break cafe; //밖의 반복문 빠져나감
				case "아메리카노":
				case "americano":
					hadOrdered = true;
					System.out.println("몇잔 주문 하시겠습니까?");
					orderN = sc.nextInt();
					if (orderN < 1) {
						System.out.println("1잔 이상 주문해주시길 바랍니다.");
						continue;
					}
					ameN += orderN; //아메리카노 주문 후 뒤늦게 다시 주문한 횟수 누적
					amePay += (amePrice * orderN); //아메리카노 주문 후 뒤늦게 다시 주문한 횟수에 대한 비용 누적
					
					totalorderN += orderN; //아메리카노 주문 후 전체 주문 횟수에 누적
					totalpay += (amePrice * orderN); //방금 주문한 아메리카노 비용을 전체 주문금액에 누적
					
					System.out.println(order + " " + orderN + " 잔 주문받았습니다.");
					many = false;
					break;
				case "카페라떼":
					hadOrdered = true;
					System.out.println("몇잔 주문 하시겠습니까?");
					orderN = sc.nextInt();
					if (orderN < 1) {
						System.out.println("1잔 이상 주문해주시길 바랍니다.");
						continue;
					}
					latteN += orderN;
					lattePay += (lattePrice * orderN);
					totalorderN += orderN;
					totalpay += (lattePrice * orderN);
					System.out.println(order + " " + orderN + " 잔 주문받았습니다.");
					many = false;
					break;
				case "카푸치노":
					hadOrdered = true;
					System.out.println("몇잔 주문 하시겠습니까?");
					orderN = sc.nextInt();
					if (orderN < 1) {
						System.out.println("1잔 이상 주문해주시길 바랍니다.");
						continue;
					}
					cafuN += orderN;
					cafuPay += (cafuPrice * orderN);
					totalorderN += orderN;
					totalpay += (cafuPrice * orderN);
					System.out.println(order + " " + orderN + " 잔 주문받았습니다.");
					many = false;
					break;
				default:
					System.out.println(order + " 는 메뉴에 없습니다");
					many = false;
					//break;
				}
			} while (many);

			isFirst = false;		//한 번은 주문한 경우 (주문이력 있음 => false)
			System.out.println("");
		} while (isNextOrder);

		if (hadOrdered) {
			System.out.println("-------Payment-----------");
			
			String result = ""; //빈 문자열 객체가 생성됨
			
			if (ameN > 0) {
				result += "아메리카노 " + ameN + " 잔 " + amePay + " 원, ";
			}
			if (latteN > 0) {
				result += "카페라떼 " + latteN + " 잔 " + lattePay + " 원, ";
			}
			if (cafuN > 0) {
				result += "카푸치노 " + cafuN + " 잔 " + cafuPay + " 원, ";
			}
			System.out.println(result.substring(0, result.length()-2));
			//System.out.println();
			System.out.println("총 " + totalorderN + " 잔, 총 가격 = " + totalpay + "원");
			System.out.println("-------Payment-----------");
		} else {
			System.out.println("안녕히 가세요");
		}

	}

}
