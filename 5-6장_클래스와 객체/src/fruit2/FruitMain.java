package fruit2;
import java.util.Scanner;

//같은 패키지 안의 클래스들은 자동 import 되므로 생략함
import fruit.*;//경고

public class FruitMain {
	
	public static void main(String[] args) {
		Buyer b = new Buyer();//기본값 0으로 채워진 구매자 객체 생성
		
		//멤버변수에 [직접 접근]하여 값을 변경
		//b.money = 30000;//오류발생?private이므로 다른 클래스에서 접근불가(접근가능한 메서드를 통해 간접접근)
		b.numOfApple = 20;//사과수 20개를 가진 구매자로 변경
		
		b.showBuy();
		
		System.out.println("----[멤버변수에 직접 접근] 구매자의 현재 현황-1-----------");		
		//System.out.println(b.money+"원");
		System.out.println(b.numOfApple+"개");
		
		System.out.println("-------------------------------------------------");
		//멤버변수에 [간접 접근]하여 값을 변경 : 메서드를 이용
		b.setMoney(50000);//돈은 50000원
		b.setNumOfApple(70);//사과수 70개를 가진 구매자로 변경
		
		b.showBuy();
		
		System.out.println("----[멤버변수에 간접 접근] 구매자의 현재 현황-2-----------");		
		System.out.println(b.getMoney()+"원");
		System.out.println(b.getNumOfApple()+"개");
		
		System.out.println("-----[구매자와 판매자]------------------------------");
		Scanner sc = new Scanner(System.in);
		
		//1-1. 구매자1 생성
		//Buyer b1 = new Buyer(10000);     //10000원 가진 구매자 생성(사과수는 기본값 0)
		//1-2. 구매자2 생성
		Buyer b2 = new Buyer(20000, 10); //20000원, 10개 사과를 가진 구매자 생성
		
		//2-1. 판매자1 생성
		Seller s1 = new Seller("판매자1", 3000, 100, 1000);
		//멤버변수에 직접접근이 가능하므로 사과가격을 10원으로 변경가능(=>문제점 해결 : 사과가격에 final 붙임)
		//s1.apple_price = 10;
		
		//2-2. 판매자2 생성
		Seller s2 = new Seller("판매자2", 4000, 50, 2000);
		
		String tmp;
		int buyCount = 0;
		
		while(b2.getMoney() != 0) {//구매자의 현재잔액이 0원이 아닐동안 
			System.out.println("-----------------------------------");
			System.out.println("(1) 판매점1");
			System.out.println("(2) 판매점2");
			System.out.print("선택하세요. (구매를 종료하려면 stop 입력)> ");
			
			//"수"-정수(음수 0 양수 1 2) 실수  "문자"-stop stop이외
			tmp = sc.next().trim();
			
			//1. "stop" -> 반복문 멈춤
			if(tmp.equalsIgnoreCase("stop")) {
				System.out.println("구매자가 구매를 중단합니다.");
				break;
			}
			
			//2. 
			int menu = 0;//지역변수는 초기화해줘야 함
			try {
				//"1.23"실수, "ㅁ" "a"문자 => 정수로 변환이 안되므로 예외객체 생성
				menu = Integer.parseInt(tmp);
			} catch (NumberFormatException e) {	//-> 예외객체 잡아서			
				//e.printStackTrace();
				System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요~");
				continue;
			}
			
			//3. 정수(음수 0 양수) => 1과 2 이외의 정수 걸러냄-[방법-1]
			//if( !( 1 <= menu && menu <= 2)) {
			if( menu != 1 && menu != 2 ) {
				System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요~");
				continue;
			}
			
			switch(menu) {
			case 1:
				 System.out.println("===== 구매자가 ["+ s1.sellerName +"]에 입장하셨습니다. =========");
				 b2.askApplePrice(s1);
				 b2.askNumOfApple(s1);
				 
				 //구매자의 현재잔액 >= 판매자1의 사과1개 가격보다 
				 if(b2.getMoney() >= s1.getAPPLE_PRICE()) {//1200 >= 1000
					 System.out.println("==========================================");
					 System.out.println("구매자의 현재잔액은 " + b2.getMoney() +"원 입니다.");
					 System.out.println(s1.sellerName +"의 사과 1개 가격은 " + s1.getAPPLE_PRICE() + "원 입니다.");
					 System.out.println("==========================================");
					 
					 while(b2.getMoney() != 0) {//2000
						 if(b2.getMoney() < s1.getAPPLE_PRICE()) {//2000 < 2000
							 System.out.println("현재 잔액이 부족하여 " +s1.sellerName +"에서는 더 이상 사과를 구매할 수 없습니다.");
							 break;////안쪽 while문 빠져나감
						 }
						 
						 System.out.print("구매할 사과 수 입력(구매멈춤:stop 또는 그만) > ");
						 String buyTempNumOfApple = sc.next();
						 if(buyTempNumOfApple.equalsIgnoreCase("stop") || buyTempNumOfApple.equals("그만")) {
								System.out.println("구매자가 "+s1.sellerName+"에서의 구매를 중단합니다.");
								break;
						 }
						 
						 //"정수",  "실수",  "stop" "그만" 이외의 문자들
						 int buyNumOfApple = 0;//반드시 int 타입이어야 함(이유?연산을 하기 위해서)
						 try {
							buyNumOfApple = Integer.parseInt(buyTempNumOfApple);
						} catch (NumberFormatException e) {							
							//e.printStackTrace();
							System.out.println("※구매할 사과 수를 정수로 입력해주세요");
							continue;
						}
						 
						 //정수 : -1  0  1
						 if(buyNumOfApple <= 0) {
							 System.out.println("※구매할 사과 수를 0보다 큰수로 입력해주세요");
							 continue;
						 }
						 
						 //구매자의 현재잔액 >= 판매자의 사과가격*구매자의 사과구매수
						 if(b2.getMoney() >= s1.getAPPLE_PRICE()*buyNumOfApple) {
							 b2.buy(s1, s1.getAPPLE_PRICE()*buyNumOfApple);
							 buyCount += buyNumOfApple;
							 System.out.println("사과 " + buyNumOfApple + "개를 구매하여 총 " + buyCount +"개가 되었습니다.");
							 
							 if(b2.getMoney() < s1.getAPPLE_PRICE()) {
								 System.out.println("현재 잔액이 부족하여 " + s1.sellerName +"에서는 더 이상 사과를 구매할 수 없습니다.");
								 break;
							 }else {//안쪽 while문 빠져나감
								 System.out.println("※ 잔액 " + b2.getMoney() +"원이 남았습니다.");
								 System.out.println("최대 " + b2.getMoney()/s1.getAPPLE_PRICE() +"개를 더 구매할 수 있습니다.");
								 
								 continue;//반복문(=안쪽 while문)의 위로 올라감
							 }
							 
						 }else { //구매자의 현재잔액 < 판매자의 사과가격*구매자의 사과구매수
							 System.out.println("※구매자의 잔액이 부족하여 " + buyNumOfApple +"개를 구매할 수는 없지만");
							 System.out.println(b2.getMoney()/s1.getAPPLE_PRICE()+"개는 구매할 수 있습니다.");
							 System.out.println("-----------------------------------------------");
						 }
						 
					 }//안쪽 while문 			 
					 
				 }else {
					 System.out.println("구매자의 잔액이 부족하여" + s1.sellerName + "에서는 사과를 구매할 수 없습니다.");
					 
				 }
				 
				 break; //switch()문 끝남
				 
			case 2:
				System.out.println("===== 구매자가 ["+ s2.sellerName +"]에 입장하셨습니다. =========");
				 b2.askApplePrice(s2);
				 b2.askNumOfApple(s2);
				 
				 //구매자의 현재잔액 >= 판매자1의 사과1개 가격보다 
				 if(b2.getMoney() >= s2.getAPPLE_PRICE()) {//1200 >= 1000
					 System.out.println("==========================================");
					 System.out.println("구매자의 현재잔액은 " + b2.getMoney() +"원 입니다.");
					 System.out.println(s2.sellerName +"의 사과 1개 가격은 " + s2.getAPPLE_PRICE() + "원 입니다.");
					 System.out.println("==========================================");
					 
					 while(b2.getMoney() != 0) {//2000
						 if(b2.getMoney() < s2.getAPPLE_PRICE()) {//2000 < 2000
							 System.out.println("현재 잔액이 부족하여 " +s2.sellerName +"에서는 더 이상 사과를 구매할 수 없습니다.");
							 break;////안쪽 while문 빠져나감
						 }
						 
						 System.out.print("구매할 사과 수 입력(구매멈춤:stop 또는 그만) > ");
						 String buyTempNumOfApple = sc.next();
						 if(buyTempNumOfApple.equalsIgnoreCase("stop") || buyTempNumOfApple.equals("그만")) {
								System.out.println("구매자가 "+s2.sellerName+"에서의 구매를 중단합니다.");
								break;
						 }
						 
						 //"정수",  "실수",  "stop" "그만" 이외의 문자들
						 int buyNumOfApple = 0;//반드시 int 타입이어야 함(이유?연산을 하기 위해서)
						 try {
							buyNumOfApple = Integer.parseInt(buyTempNumOfApple);
						} catch (NumberFormatException e) {							
							//e.printStackTrace();
							System.out.println("※구매할 사과 수를 정수로 입력해주세요");
							continue;
						}
						 
						 //정수 : -1  0  1
						 if(buyNumOfApple <= 0) {
							 System.out.println("※구매할 사과 수를 0보다 큰수로 입력해주세요");
							 continue;
						 }
						 
						 //구매자의 현재잔액 >= 판매자의 사과가격*구매자의 사과구매수
						 if(b2.getMoney() >= s2.getAPPLE_PRICE()*buyNumOfApple) {
							 b2.buy(s2, s2.getAPPLE_PRICE()*buyNumOfApple);
							 buyCount += buyNumOfApple;
							 System.out.println("사과 " + buyNumOfApple + "개를 구매하여 총 " + buyCount +"개가 되었습니다.");
							 
							 if(b2.getMoney() < s2.getAPPLE_PRICE()) {
								 System.out.println("현재 잔액이 부족하여 " + s2.sellerName +"에서는 더 이상 사과를 구매할 수 없습니다.");
								 break;
							 }else {//안쪽 while문 빠져나감
								 System.out.println("※ 잔액 " + b2.getMoney() +"원이 남았습니다.");
								 System.out.println("최대 " + b2.getMoney()/s2.getAPPLE_PRICE() +"개를 더 구매할 수 있습니다.");
								 
								 continue;//반복문(=안쪽 while문)의 위로 올라감
							 }
							 
						 }else { //구매자의 현재잔액 < 판매자의 사과가격*구매자의 사과구매수
							 System.out.println("※구매자의 잔액이 부족하여 " + buyNumOfApple +"개를 구매할 수는 없지만");
							 System.out.println(b2.getMoney()/s2.getAPPLE_PRICE()+"개는 구매할 수 있습니다.");
							 System.out.println("-----------------------------------------------");
						 }
						 
					 }//안쪽 while문 			 
					 
				 }else {
					 System.out.println("구매자의 잔액이 부족하여" + s2.sellerName + "에서는 사과를 구매할 수 없습니다.");
					 
				 }
				 
				 break; //switch()문 끝남
				
			//3. 정수(음수 0 양수) => 1과 2 이외의 정수 걸러냄-[방법-2]
			default:System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요~");
			        continue;
			
			}//switch문 끝
			
			
		}//바깥 while()문끝
		
		System.out.println("구매자의 현재잔액은 "+b2.getMoney()+"가 되어 더 이상 구매할 수 없습니다.");
		
		System.out.println();//구분위한 빈줄
		
		System.out.println("----------[구매자의 현재현황]-------------------");
		b2.showBuy();
		
		System.out.println("----------["+ s1.sellerName +"의 현재현황]----------");
		s1.showSale();
		System.out.println("----------["+ s2.sellerName +"의 현재현황]----------");
		s2.showSale();
	
	}//main()끝
	
}//Class 끝








