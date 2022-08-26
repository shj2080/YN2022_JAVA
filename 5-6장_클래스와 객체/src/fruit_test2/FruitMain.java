package fruit_test2;

public class FruitMain {

	public static void main(String[] args) {
		Buyer b = new Buyer();// 기본값 0으로 채워진 구매자 객체 생성
		// 멤버변수에 [직접 접근]하여 값을 변경
		// 돈은 30000원
		// 사과수 20개를 가진 구매자로 변경
		b.money = 30000;
		b.numOfApple = 20;
		
		System.out.println("----[멤버변수에 직접 접근] 구매자의 현재 현황-1-----------");
		System.out.println("구매자 보유 금액 = " + b.money);
		System.out.println("구매자 보유한 사과 수 = " + b.numOfApple);
		System.out.println("-------------------------------------------------");
		// 멤버변수에 [간접 접근]하여 값을 변경 : 메서드를 이용
		// 돈은 50000원
		// 사과수 70개를 가진 구매자로 변경
		b.setMoney(50000);
		b.setNumOfApple(70);
		
		System.out.println("----[멤버변수에 간접 접근] 구매자의 현재 현황-2-----------");
		System.out.println("구매자 보유 금액 = " + b.getMoney());
		System.out.println("구매자 보유한 사과 수 = " + b.getNumOfApple());
		System.out.println("-------------------------------------------------");

		// 1-1. 구매자1 생성
		// 10000원 가진 구매자 생성(사과수는 기본값 0)
		Buyer b1 = new Buyer(10000);
		
		// 1-2. 구매자2 생성
		// 20000원, 10개 사과를 가진 구매자 생성
		Buyer b2 = new Buyer(20000, 10);
		
		// 2-1. 판매자1 생성
		// 0원 사과수100개, 사과가격1000원을 가진 판매자 생성
		Seller s1 = new Seller(0,100,1000);
		
		// 2-2. 판매자2 생성
		// 0원 사과수50개, 사과가격2000원을 가진 판매자 생성
		Seller s2 = new Seller(0,50,2000);
		
		// 3-1. 구매자1이 [판매자1]한테 사과 5000원어치 구매
		b1.buy(s1, 5000);
		
		// 3-1. 구매자1이 [판매자2]한테 사과 4000원어치 구매
		b1.buy(s2, 4000);
		
		// 4. 구매자1의 현재현황 : 메서드를 이용하여 출력

		System.out.println("---- [구매자1의 현재현황] --------");
		b1.showBuy();
		
		// 5-1. 판매자1의 현재현황
		System.out.println("---- [판매자1의 현재현황] --------");
		s1.showSale();
		
		// 5-2. 판매자2의 현재현황
		System.out.println("---- [판매자2의 현재현황] --------");
		s2.showSale();

	}

}
