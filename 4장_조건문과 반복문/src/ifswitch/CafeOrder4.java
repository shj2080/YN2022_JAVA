package ifswitch;

import java.util.Scanner;

public class CafeOrder4 {

	public static void main(String[] args) {
		/**
		 * 과제 : CafeOrder4에서 바로 stop 입력 시 영수증 출력안되고 끝나도록 수정 (2022.06.24)
		 * CafeOrder3 참조
		 */
		//System.out.println("--do~while문 카페 주문 처리 시작-------------------");
		Scanner sc = new Scanner(System.in);
		
		String order = null;		//주문메뉴를 입력 받는 변수
		
		final int priceAmericano = 3000, priceCafelatte = 4000, priceCafuchino = 3500;	//가격 변경 불가
		
		int cntAmericano = 0;// 아메리카노 주문 횟수
		int cntCafelatte = 0;// 카페라떼 주문 횟수
		int cntCafuchino = 0;// 카푸치노 주문 횟수
		
		int totalCntAmericano = 0;//아메리카노 누적 주문 횟수
		int totalCntCafelatte = 0;//카페라떼 누적 주문 횟수
		int totalCntCafuchino = 0;//카푸치노 누적 주문 횟수
		
		int totalCnt = 0;//총 주문 횟수
		int totalPrice = 0;//총 지불 가격
		
		//boolean hasOrder = false;	//주문여부 (한번이라도 주문을 했다면 true로 변경)
		/* do~while문 사용이유? 적어도 한번은 주문을 받아야 하므로 */
		do {
			System.out.print(
					"------메뉴------------------\n"
					+ "아메리카노(=Americano) 3000원\n"
					+ "카페라떼              4000원\n"
					+ "카푸치노              3500원\n"
					+ "주문종료              stop\n"
					+ "주문안함    주문안함(=NoOrder)\n"
					+ "-------------------------\n"
					+ "--손님 주문해주세요> ");
			order = sc.next().trim().toLowerCase();			//메뉴를 문자열로 입력받고 앞뒤 공백 제거 후 영어는 모두 소문자로 변환

			if (order.equalsIgnoreCase("NoOrder") || order.equals("주문안함")) {
				System.out.println("주문없이 바로 나가셨습니다.");
				break; //가장 가까운 반복문이 끝
			}

			switch (order) {
			case "아메리카노":
			case "americano":
				System.out.println(order + "를 주문하셨습니다.");
				System.out.print("-- 몇 잔을 주문하시겠습니까? > ");
				cntAmericano = sc.nextInt();
				if(cntAmericano > 0) {
					System.out.println(order + " " + cntAmericano + "잔을 주문하셨습니다.");
					
									
				}else {
					System.out.println("0보다 큰 수를 입력해주세요.");
				}
				
				totalCntAmericano += cntAmericano;			//전체 잔수에 더함
				
				totalCnt += cntAmericano;
				totalPrice += (cntAmericano * priceAmericano);
				
				break;
				
			case "카페라떼":
				System.out.println(order + "를 주문하셨습니다.");
				System.out.print("-- 몇 잔을 주문하시겠습니까? > ");
				cntCafelatte = sc.nextInt();
				if(cntCafelatte > 0) {
					System.out.println(order + " " + cntCafelatte + "잔을 주문하셨습니다.");
					
					
				}else {
					System.out.println("0보다 큰 수를 입력해주세요.");
				}
				totalCntCafelatte += cntCafelatte; 			//전체 잔수에 더함
				
				totalCnt += cntCafelatte;
				totalPrice += (cntCafelatte * priceCafelatte);
				
				break;
				
			case "카푸치노":
				System.out.println(order + "를 주문하셨습니다.");
				System.out.print("-- 몇 잔을 주문하시겠습니까? > ");
				cntCafuchino = sc.nextInt();		//주문 잔수
				if(cntCafuchino > 0) {
					System.out.println(order + " " + cntCafuchino + "잔을 주문하셨습니다.");
				}else {
					System.out.println("0보다 큰 수를 입력해주세요.");
				}
				totalCntCafuchino += cntCafuchino; 			//전체 잔수에 더함
				
				totalCnt += cntCafuchino;
				totalPrice += (cntCafuchino * priceCafuchino);
				
				break;
				
			case "stop":
				if(totalCnt > 0) System.out.println("그만 주문하겠습니다.");
				else {
					System.out.println("아직 주문하시지 않았습니다.");
					//countinue; 아래 실행문들은 건너띄고 while(조건);으로 가서 조건이 거짓이 되어 반복문이 끝
					//continue; //사용하면 원하는 결과를 얻을 수 없다.
					order = "아직 주문안함";  //"stop" 제외한 아무 문자열로 초기화 가능=>while(조건);으로 가서 조건이 참이 되어 반복문 시작
				}
				break;	//switch문 빠져나옴
				/*             
				 if(totalCnt > 0) {
				        System.out.println("그만 주문하겠습니다.");
						System.out.println("***********[영수증]*****************************"); 
						String result = "";							
						if(totalCntAmericano>=1) {
							result += "아메리카노 "+totalCntAmericano+"잔에 "+(priceAmericano*totalCntAmericano)+"원, ";
							//if(cntCaferate>=1 || cntCafuchino>=1) System.out.print(", ");//, 처리
						}
				
						if(totalCntCaferate>=1) {
							result += "카페라떼 "+totalCntCaferate+"잔에 "+(priceCaferate*totalCntCaferate)+"원, ";
							//if(cntCafuchino>=1) System.out.print(", ");//, 처리
						}
						
						if(totalCntCafuchino>=1) {
							result += "카푸치노 "+totalCntCafuchino+"잔에 "+(priceCafuchino*totalCntCafuchino)+"원, ";
						}
						
						if(result.length()>0) System.out.println(result.substring(0, result.length()-2));
						System.out.println("\n총 "+ totalCnt +"잔, 총 가격 = "+ totalPrice +"원");			
					
						System.out.println("***********[영수증]*****************************"); 
						
					}else {
	                	System.out.println("아직 주문하시지 않았습니다.");
	                  //continue;아래 실행문들은 건너띄고 while(조건문);으로 가서 조건이 거짓이 되어 반복문이 끝
	                  //continue; //사용하면 원하는 결과를 얻을 수 없다.
	                	order = "아직 주문안함"; //"stop" 제외한 아무 문자열로 초기화 가능=>while(조건문);으로 가서 조건이 참이 되어 반복문 시작 	                	  
	                }	
					
					break;//switch문 빠져나감
				*/	
			default:
				System.out.println("메뉴에 없습니다.");// break;
			} //switch문 끝
			
			
		} while (!order.equalsIgnoreCase("stop"));
		// }while(order.toLowerCase().compareTo("stop") != 0);
		
		if( !(order.equalsIgnoreCase("NoOrder") || order.equals("주문안함")) && totalPrice > 0 ) {	//주문내역이 있을 경우, 주문 중 주문취소를 하지 않은 경우
			System.out.println("---------[영수증]------------------------------");
			String result = "";
			
			if (totalCntAmericano >= 1) {
				result += "아메리카노 " + totalCntAmericano + "잔에 " + (priceAmericano * totalCntAmericano) + "원, ";
				//if (cntCafelatte >= 1 || cntCafuchino >= 1) System.out.print(", "); // , 처리
			}

			if (totalCntCafelatte >= 1) {
				result += "카페라떼 " + totalCntCafelatte + "잔에 " + (priceCafelatte * totalCntCafelatte) + "원, ";
				//if (cntCafuchino >= 1) System.out.print(", ");// , 처리
			}

			if (totalCntCafuchino >= 1)
				result += "카푸치노 " + totalCntCafuchino + "잔에 " + (priceCafuchino * totalCntCafuchino) + "원, ";
			
			if(result.length() > 0) System.out.println(result.substring(0, result.length()-2));
			System.out.println("\n총 " + totalCnt + "잔, 총 가격 = " + totalPrice + "원");

			System.out.println("---------[영수증]------------------------------");
		}
		
		//System.out.println("--do~while문 카페 주문 처리 끝-------------------");
	}

}
