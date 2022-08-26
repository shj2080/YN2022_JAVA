package test;

import java.util.Scanner;

public class CafeOrderTest {

	public static void main(String[] args) {
		
		//가격, 잔수, 주문 입력받는 변수
		Scanner sc = new Scanner(System.in);
		
		String order = null;
		
		final int priceAmericano = 3500, priceCafelatte = 4000, priceCafuchino = 5000;		//가격
		
		int orderCup = 0; 		//주문할 잔수
		
		/*
		int orderCup = 0;		// 주문할 아메리카노 잔수
		int orderCup = 0;
		int orderCup = 0;
		*/
		
		int totalAmericanoCup = 0;		// 주문된 아메리카노 총 잔수
		int totalCafelatteCup = 0;
		int totalCafuchinoCup = 0;
				
		int totalPrice = 0;		//주문 총 금액
		int totalCup = 0;		//주문한 모든 커피 잔수 합계
		
		do {
			System.out.println("----------------메뉴판----------------");
			System.out.println("아메리카노(Americano) \t" + priceAmericano + "원");
			System.out.println("카페라떼 \t\t\t" + priceCafelatte + "원");
			System.out.println("카푸치노 \t\t\t" + priceCafuchino + "원");
			System.out.println("주문안함\t\t\tNoOrder");
			System.out.println("주문완료\t\t\tstop");
			System.out.println("----------------메뉴판----------------");
			
			System.out.print("--주문할 메뉴를 선택하세요 > ");
			order = sc.next().trim().toLowerCase();
			
			if(order.equalsIgnoreCase("NoOrder") || order.equals("주문안함")) {
				System.out.println("주문을 하지 않고 나갑니다.");
				break;
			}
			
			switch(order) {
				case "americano":
				case "아메리카노":
					System.out.print("몇 잔 주문하시겠습니까?");
					orderCup = sc.nextInt();
					
					if(orderCup > 0) {
						System.out.println(order + " " + orderCup + "잔 주문하셨습니다.");
						
						totalAmericanoCup += orderCup;		//아메리칸 총 잔수에 합함
						
						totalCup += orderCup;			//모든 커피잔수에 합함
						totalPrice += (orderCup * priceAmericano);	// 총 가격
						
					} else {
						System.out.println("최소 1잔 이상 주문해주세요.");
					}
					
					break;
				case "카페라떼":
					System.out.print("몇 잔 주문하시겠습니까?");
					orderCup = sc.nextInt();
					
					if(orderCup > 0) {
						System.out.println(order + " " + orderCup + "잔 주문하셨습니다.");
						
						totalCafelatteCup += orderCup;		//카페라떼 총 잔수에 합함
						
						totalCup += orderCup;			//모든 커피잔수에 합함
						totalPrice += (orderCup * priceCafelatte);	// 총 가격
						
					} else {
						System.out.println("최소 1잔 이상 주문해주세요.");
					}
					
					break;
				case "카푸치노":
					System.out.print("몇 잔 주문하시겠습니까?");
					orderCup = sc.nextInt();
					
					if(orderCup > 0) {
						System.out.println(order + " " + orderCup + "잔 주문하셨습니다.");
						
						totalCafuchinoCup += orderCup;		//카푸치노 총 잔수에 합함
						
						totalCup += orderCup;			//모든 커피잔수에 합함
						totalPrice += (orderCup * priceCafuchino);	// 총 가격
						
					} else {
						System.out.println("최소 1잔 이상 주문해주세요.");
					}
					
					break;
				case "주문완료":
				case "stop":
					if(totalPrice > 0) {
						System.out.println("주문을 그만하겠습니다.");
					}else {
						System.out.println("아직 주문한 메뉴가 없습니다.");
						order = "다시주문";			//반복문이 끝나지 않도록 order 값 임의조정
					}
					
					break;
				default:
					System.out.println("메뉴판에 없는 메뉴입니다!");					
			}
			
			
		} while(!order.equalsIgnoreCase("stop"));
		
		if( !(order.equalsIgnoreCase("NoOrder") || order.equals("주문안함")) && totalPrice > 0) {		//주문한 내역이 있거나 주문안함 or NoOrder가 아닌 경우
			System.out.println("===================[영수증]===================");
			
			String priceResult = "";
			
			if(totalAmericanoCup > 0) {
				priceResult += "아메리카노 " + totalAmericanoCup + "잔 " + (totalAmericanoCup * priceAmericano) + "원, ";
			}
			if(totalCafelatteCup > 0) {
				priceResult += "카페라떼 " + totalCafelatteCup + "잔 " + (totalCafelatteCup * priceCafelatte) + "원, ";
			}
			if(totalCafuchinoCup > 0) {
				priceResult += "카푸치노 " + totalCafuchinoCup + "잔 " + (totalCafuchinoCup * priceCafuchino) + "원, ";
			}
			
			
			if(priceResult.length() > 0) {
				System.out.println(priceResult.substring(0,priceResult.length()-2));		// 마지막 메뉴 뒤에는 , 뺌
			}
			
			System.out.println("총 " + totalCup + "잔, " + totalPrice + "원 입니다.");
			System.out.println("===================[영수증]===================");
		}
		
		sc.close();
	}

}
