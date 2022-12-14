package fruit2;
//구매자
public class Buyer {
	//1. 속성 : 멤버변수=필드(field) (기본값->명시적 값->생성자)
	private int firstMoney; //구매자가 처음 가진 돈(=원금)
	private int money; 		//현재 잔액 = 구매자가 처음 가진 돈 - 사과를 구매한 돈
	
	int firstNumOfApple;		//구매자의 기존 사과수
	int numOfApple; 			//구매자의 기존 사과수 + 구매한 사과수
	
	
	//2. 생성자 : 멤버변수(=필드)에 값을 채워 객체 생성(=>객체 안에 존재하지 않음)
	Buyer(){super();}
	
	public Buyer(int money) {	//2000
		super();
		firstMoney = money;
		this.money = money;
		//나머지 필드는 : 기본값 0으로 채워짐
	}

	public Buyer(int money2, int numOfApple) {
		super();
		firstMoney = money2;
		//this. 생략O(이유1:같은 클래스 안에 있으므로, 이유2:멤버변수와 매개변수가 이름이 달라서 구분되므로)
		money = money2;
		
		firstNumOfApple = numOfApple;
		//this. 생략X(이유?멤버변수와 매개변수가 이름이 같아서 구분해야 하므로)
		this.numOfApple = numOfApple;
		//this. : 자기 자신의 주소로 해당 객체 안에 존재
	}
		
	//3. 기능 : 메서드 - ★★구매자가 주체
	//해당 판매자에게 사과가격 묻기
	void askApplePrice(Seller s) {
		System.out.println("[" + s +  "] 사과 1개 가격이 얼마예요?");
		System.out.println("[" + s.sellerName +  "] 사과 1개 가격이 얼마예요?");
		//System.out.println("[" + s.toString() +  "] 사과 1개 가격이 얼마예요?");
		s.answerApplePrice(); //[방법-1]
		System.out.println(s.getAPPLE_PRICE()); //[방법-2]
	}
	
	//해당 판매자에게 사과수 묻기
	void askNumOfApple(Seller s) {
		System.out.println("[" + s +  "] 사과 몇 개가 남았어요?");
		System.out.println("[" + s.sellerName +  "] 사과 몇 개가 남았어요?");
		//System.out.println("[" + s.toString() +  "] 사과 몇 개가 남았어요?");
		
		s.answerNumOfApple(); //[방법-1]
		System.out.println(s.getNumOfApple()); //[방법-2]
	}
	
	//돈을 판매자에게 주고 사과를 사는 메서드
	void buy(Seller s, int money) {
		numOfApple += s.sale(money);	//사과수 증가 = 구매자의 사과바구니에 판매자에게 돈을 주고 받은 사과(5)를 추가
		this.money -= money; 			//돈 감소 = 구매자의 기존 돈 - 판매자에게 사과를 구매할 때 사용한 돈
	}
	
	//구매자의 현재 현황
	void showBuy() {
		System.out.println("구매한 사과 수 : " + (numOfApple - firstNumOfApple));	//구매한 사과수 = 현재 사과수 - 기존 사과수
		System.out.println("구매자가 처음 가진 돈(=원금) : " + firstMoney);
		System.out.println("구매자가 사과를 구매한 돈 : " + (firstMoney - money)); //구매한돈 = 원금 - 현재잔액
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
