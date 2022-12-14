package fruit;

public class Seller {
	// 1. 속성 : 멤버변수=필드(field) (기본값->명시적 값->생성자)
	int money;       // 돈 바구니 0 -> 5000
	int numOfApple = 100;  // 사과 수 100 -> 95
	
	//static final int APPLE_PRICE = 1000; //사과 가격 공유 + 값 변경불가
	
	final int apple_price; //생성자를 통해 : 각 판매자마다 사과가격을 다르게 하고 가격변경불가 하게 하고 싶다면

	// 2. 기본생성자 public Seller(){super();}
	
	public Seller(int money, int numOfApple, int apple_price) {
		super();
		this.money = money;
		this.numOfApple = numOfApple;
		this.apple_price = apple_price;
	}
	
	// 3. 기능 : 메서드
	//돈을 받아 받은 돈만큼의 사과를 돌려준다.
	int sale(int money) {
		int numOfSale = money / apple_price;//	5000/1000 = 5(몫)
		
		this.money += money; 	//받은 돈만큼 판매자의 돈은 증가
		numOfApple -= numOfSale; //판매한 사가수만큼 판매자의 사과수는 감소
		
		return numOfSale;	//구매자에게 사과수를 리턴
	}
	
	void showSale() {
		System.out.println("판매 후 남은 사과 수 : " + numOfApple);
		System.out.println("판매자가 가진 전체 돈 : " + money);
	}
	
}
