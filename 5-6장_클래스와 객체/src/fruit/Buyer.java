package fruit;
//구매자
public class Buyer {
	//1. 속성 : 멤버변수=필드(field) (기본값->명시적 값->생성자)
	int money; 		//돈		10000 -> 5000
	int numOfApple; //사과바구니 0 -> 5
	
	
	//2. 생성자 : 멤버변수(=필드)에 값을 채워 객체 생성(=>객체 안에 존재하지 않음)
	Buyer(){super();}
	
	public Buyer(int money) {	//2000
		super();
		this.money = money;
		//numOfApple : 기본값 0으로 채워짐
	}

	public Buyer(int money2, int numOfApple) {
		super();
		//this. 생략O(이유1:같은 클래스 안에 있으므로, 이유2:멤버변수와 매개변수가 이름이 달라서 구분되므로)
		money = money2;
		//this. 생략X(이유?멤버변수와 매개변수가 이름이 같아서 구분해야 하므로)
		this.numOfApple = numOfApple;
		//this. : 자기 자신의 주소로 해당 객체 안에 존재
	}
		
	//3. 기능 : 메서드
	//돈을 판매자에게 주고 사과를 사는 메서드 - ★★구매자가 주체
	void buy(Seller s, int money) {
		numOfApple += s.sale(money);	//사과수 증가 = 구매자의 사과바구니에 판매자에게 돈을 주고 받은 사과(5)를 추가
		this.money -= money;//돈 감소 = 구매자의 기존 돈 - 판매자에게 사과를 구매할 때 사용한 돈
	}
	
	void showBuy() {
		System.out.println("가진 사과 수 : " + numOfApple);
		System.out.println("현재 잔액 : " + money);
	}
	
	//get~()와 set~()메서드 : 멤버변수에 접근
	public int getMoney() { 	//money값을 얻을 때
		return this.money;
	}

	public void setMoney(int money) { 	//money값을 변경시킬 때
		this.money = money;
	}

	public int getNumOfApple() {
		return numOfApple;
	}

	public void setNumOfApple(int numOfApple) {
		this.numOfApple = numOfApple;
	}
	
}
