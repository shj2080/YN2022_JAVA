package fruit_test2;

public class Seller {
	// 1. 속성 : 멤버변수=필드(field) (기본값->명시적값->생성자)
	public int money;// 돈 바구니
	public int numOfApple;// 사과 수
	
	final int APPLE_PRICE; // 사과 가격 상수 (각 판매자마다 가격 다름)
	// static final int APPLE_PRICE = 1000;//사과가격 공유+값변경불가

	// '생성자'를 통해 : 각 판매자마다 사과가격을 다르게 하고 가격변경불가 하게 하고 한다면

	// 2. 생성자(1개) : 각 필드에 값을 채워 객체 생성
	
	public Seller(int money, int numOfApple, int apple_price) {
		this.money = money;
		this.numOfApple = numOfApple;
		this.APPLE_PRICE = apple_price;
	}
	
	// 3. 기능 : 메서드
	// 돈을 받아 받은 돈만큼의 사과를 돌려준다.
	public int sale(int money) {
		int numOfApple = money / APPLE_PRICE; // 지불한 돈 / 사과 가격 = 판매되는 사과 수
		
		this.money += money;	//수익을 현재 금액에 더함
		this.numOfApple -= numOfApple;  //사과 갯수 감소
		
		return numOfApple;
	}
	
	// 필드의 값을 출력하는 메서드
	public void showSale() {
		System.out.println("현재 판매 금액 = " + this.money);
		System.out.println("현재 남은 사과 수 = " + this.numOfApple);
		System.out.println("사과 가격 = " + this.APPLE_PRICE);
	}
	
}
