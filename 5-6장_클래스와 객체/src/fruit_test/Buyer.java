package fruit_test;

public class Buyer {
	//1. 속성 : 멤버변수=필드(field) (기본값->명시적값->생성자)
	int money;	//돈
	int numOfApple;	//사과바구니
	
	//2. 생성자 : 멤버변수(=필드)에 값을 채워 객체 생성(=>객체 안에 존재하지 않음)
	//생성자 여러개 만들어보기
	public Buyer() {super();}
	
	public Buyer(int money) {
		super();
		this.money = money;
	}
	
	public Buyer(int money, int numOfApple) {
		super();
		this.money = money;
		this.numOfApple = numOfApple;
	}
	
	//3. 기능 : 메서드
	//돈을 판매자에게 주고 사과를 사는 메서드 - ★★구매자가 주체
	void Buy(Seller s, int money) {
		numOfApple += s.sale(money);		//사과수 증가=구매자의 사과바구니에 판매자에게 돈을 주고 받은 사과(5)를 추가
		
		this.money -= money;	//돈 감소=구매자의 기존돈-판매자에게 사과를 구매할 때 사용한 돈
	}
/*	
	void showBuy() {
		System.out.println("구매한 사과 수 : " + );
		System.out.println("구매자가 처음 가진 돈(=원금) : " + );
		System.out.println("구매자가 사과를 구매한 돈 : " + );
		System.out.println("현재 잔액 : " + );
	}
*/
	//get~()와 set~()메서드 : 멤버변수에 접근
	public int getMoney() {	//money값을 얻을 때
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
