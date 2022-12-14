package ifswitch;

import java.util.Scanner;

public class CafeOrder2 {

	public static void main(String[] args) {
		System.out.println("--do~while문 카페 주문 처리 시작-------------------");
		Scanner sc = new Scanner(System.in);
		String order;
		int cntAmericano=0;//아메리카노 주문 횟수
		int cntCafelatte=0;//카페라떼 주문 횟수
		int cntCappuccino=0;//카푸치노 주문 횟수
		
		int totalCnt = 0; // 총 주문 횟수
		
		do {
			System.out.print("메뉴(Americano:3000원, 카페라떼:4000원, 카푸치노:3500원)중에서 주문\n(단,주문안함(=NoOrder)입력하고 바로 나감, 주문 그만하고 싶으면 stop입력)>");
			order = sc.next().trim().toLowerCase();
						
			if(order.equalsIgnoreCase("NoOrder") || order.equals("주문안함")) break;
			
			switch(order) {
			case "americano" : 
				cntAmericano++;
				totalCnt++;
				System.out.println(order+"를 주문하셨습니다.");
				break;
			case "카페라떼" : 
				cntCafelatte++;
				totalCnt++;
				System.out.println(order+"를 주문하셨습니다.");
				break;
			case "카푸치노" : 
				cntCappuccino++;
				totalCnt++;
				System.out.println(order+"를 주문하셨습니다.");
				break;
			case "stop"  : System.out.println("그만 주문하겠습니다.");
						System.out.println("---------영수증------------------------------");
							
							
							if(cntAmericano>=1) {
								System.out.print("아메리카노 "+cntAmericano+"잔에 "+(3000*cntAmericano)+"원");
								if(cntCafelatte>=1 || cntCappuccino>=1) System.out.print(", "); //, 처리
							}
		
							if(cntCafelatte>=1) {
								System.out.print("카페라떼 "+cntCafelatte+"잔에 "+(4000*cntCafelatte)+"원");
								if(cntCappuccino>=1) System.out.print(", ");//, 처리
							}
							
							if(cntCappuccino>=1) 
								System.out.print("카푸치노 "+cntCappuccino+"잔에 "+(3500*cntCappuccino)+"원");
							
							System.out.println("\n총 "+ totalCnt +"잔, 총 가격 = "+(3000*cntAmericano+4000*cntCafelatte+3500*cntCappuccino)+"원");
							
						
						System.out.println("---------영수증------------------------------"); break;
			default      : System.out.println("메뉴에 없습니다.");//break;
			}
		}while(!order.equalsIgnoreCase("stop"));
		//}while(order.toLowerCase().compareTo("stop") != 0);
		
		
		System.out.println("--do~while문 카페 주문 처리 끝-------------------");
	}

}
