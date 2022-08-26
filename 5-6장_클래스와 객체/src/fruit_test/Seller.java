package fruit_test;

public class Seller {
	int money;	// 돈 바구니
	int numOfApple;	//사과 수
	
	final int apple_price;	// 사과 가격 상수 (생성자를 통해 초기화)
	
	Seller(int money, int numOfApple, int apple_price) {
		super();
		this.money = money;
		this.numOfApple = numOfApple;
		this.apple_price = apple_price;
	}
	
	int sale(int money) {
		int numOfApple = money / apple_price;	//받은 돈 / 가격 = 돌려줄 사과 수
		
		this.money += money;
		this.numOfApple -= numOfApple;	//판매한 사과 수 만큼 남은 사과 수 감소
		
		return numOfApple;
	}
	
	void showSale() {
		System.out.println("판매한 금액 = " + money + "원");
		System.out.println("남은 사과 수 = " + numOfApple + "개");
	}
}
