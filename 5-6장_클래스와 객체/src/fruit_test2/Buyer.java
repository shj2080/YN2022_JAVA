package fruit_test2;

public class Buyer {
	// 1. 속성 : 멤버변수=필드(field) (기본값->명시적값->생성자)
	int money; // 돈
	int numOfApple; // 사과바구니

	// 2. 생성자 : 멤버변수(=필드)에 값을 채워 객체 생성(=>객체 안에 존재하지 않음)
	// 생성자 여러개 만들어보기
	Buyer() {super();};
	
	public Buyer(int money) {
		this.money = money;
	}
	
	public Buyer(int money, int numOfApple) {
		super();
		this.money = money;
		this.numOfApple = numOfApple;
	}

	// 3. 기능 : 메서드
	// 돈을 판매자에게 주고 사과를 사는 메서드 - ★★구매자가 주체
	public void buy(Seller s, int money) {
		this.numOfApple += s.sale(money);
		
		this.money -= money;
	}
	
	// 필드의 값을 출력하는 메서드
	public void showBuy() {
		System.out.println("현재 가지고 있는 금액 = " + money);		
		System.out.println("현재 가지고 있는 사과 수 = " + numOfApple);
	}

	// get~()와 set~()메서드 : 멤버변수에 접근
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getNumOfApple() {
		return numOfApple;
	}

	public void setNumOfApple(int numOfApple) {
		this.numOfApple = numOfApple;
	}
}
